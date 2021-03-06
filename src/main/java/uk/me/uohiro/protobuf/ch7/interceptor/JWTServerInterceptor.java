package uk.me.uohiro.protobuf.ch7.interceptor;

import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jwt.SignedJWT;

import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import uk.me.uohiro.protobuf.ch7.client.JWTUtil;
import uk.me.uohiro.protobuf.ch7.service.CustomException;

public class JWTServerInterceptor implements ServerInterceptor {
	private static final Logger logger = Logger.getLogger(JWTServerInterceptor.class.getName());

	@SuppressWarnings("rawtypes")
	private static final ServerCall.Listener NOOP_LISTENER = new Listener() {
	};

	public JWTServerInterceptor() {
	}

	/*
	 * Message: onReady->onMessage->(execute)->onHalfClose->sendMessage->close->
	 * onComplete
	 */

	@SuppressWarnings("unchecked")
	@Override
	public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call,
			final Metadata requestHeaders, ServerCallHandler<ReqT, RespT> next) {

		// Authorizationヘッダ（メタデータ）からアクセストークンを取り出す
		String accessToken = requestHeaders.get(JWTConstants.AUTHORIZATION_METADATA_KEY);

		// Authorizationヘッダに値がない場合はエラー
		if (accessToken == null || accessToken.length() == 0) {
			call.close(Status.UNAUTHENTICATED.withDescription("Access Token is missing from Metadata"), requestHeaders);
			return NOOP_LISTENER;
		}

		// Bearerで始まっていない場合はエラー
		if (!accessToken.toLowerCase().startsWith(JWTConstants.BEARER_KEYWORD)) {
			call.close(Status.UNAUTHENTICATED.withDescription("Access Token is missing from Metadata"), requestHeaders);
			return NOOP_LISTENER;
		}

		// Bearerを除去した後にアクセストークンが指定されていない場合はエラー
		String tmp = accessToken.toLowerCase().substring(JWTConstants.BEARER_KEYWORD.length());

		if (tmp == null || tmp.length() == 0) {
			call.close(Status.UNAUTHENTICATED.withDescription("Access Token is missing from Metadata"), requestHeaders);
			return NOOP_LISTENER;
		}

		accessToken = accessToken.substring(JWTConstants.BEARER_KEYWORD.length());
		logger.info("Access token: " + accessToken);
		
		Context ctx = null;
		try {
			// Compact Serialization形式のJWTトークンをパースする
			SignedJWT signedJWT = SignedJWT.parse(accessToken);
			
			logger.info(signedJWT.getHeader().toJSONObject().toJSONString());
			logger.info(signedJWT.getPayload().toJSONObject().toJSONString());

			// JWTトークンの署名、ペイロードの中身を検証する
			verifyJWT(signedJWT);

			// コンテキストにJWTトークンのsubクレームの値を追加する
			ctx = Context.current().withValue(JWTConstants.SUB_CTX_KEY, signedJWT.getJWTClaimsSet().getSubject());

		} catch (Exception e) {
			logger.log(Level.WARNING, "Verification failed - Unauthenticated", e);
			call.close(Status.UNAUTHENTICATED.withDescription("JWT Token is missing from Metadata"), requestHeaders);
			return NOOP_LISTENER;
		}

		return Contexts.interceptCall(ctx, call, requestHeaders, next);
	}

	private void verifyJWT(SignedJWT token) throws Exception {
		JWSVerifier verifier = new RSASSAVerifier((RSAPublicKey)JWTUtil.loadRSAPublicKey());

		// 署名を検証する
		if (!token.verify(verifier)) {
			throw new CustomException("Cannot validate signature");
		}

		// Issuerを検証
		if (token.getJWTClaimsSet().getIssuer() == null
				|| !token.getJWTClaimsSet().getIssuer().equals(JWTConstants.TOKEN_ISSUER)) {
			throw new CustomException("Issuer not valid");
		}

		// Audienceを検証
		if (token.getJWTClaimsSet().getAudience() == null
				|| !token.getJWTClaimsSet().getAudience().get(0).equals(JWTConstants.TOKEN_AUDIENCE)) {
			throw new CustomException("Audience not valid");
		}

		// JWTトークンが有効期限切れでないことを検証
		Date current = new Date();

		if (!token.getJWTClaimsSet().getIssueTime().before(current)) {
			throw new CustomException("Token is not valid yet.");
		}

		if (!token.getJWTClaimsSet().getExpirationTime().after(current)) {
			throw new CustomException("Token is already expired.");
		}
	}
}
