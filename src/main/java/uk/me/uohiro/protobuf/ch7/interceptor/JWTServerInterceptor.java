package uk.me.uohiro.protobuf.ch7.interceptor;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;

import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import uk.me.uohiro.protobuf.ch7.service.CustomException;

public class JWTServerInterceptor implements ServerInterceptor {
	private static final Logger logger = Logger.getLogger(JWTServerInterceptor.class.getName());

	@SuppressWarnings("rawtypes")
	private static final ServerCall.Listener NOOP_LISTENER = new Listener() {
	};
	
	private final JWTVerifier verifier;

	public JWTServerInterceptor(JWTVerifier verifier) {
		this.verifier = verifier;
	}
	
	/*
	 * Message: onReady->onMessage->(execute)->onHalfClose->sendMessage->close->onComplete
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call,
			final Metadata requestHeaders, ServerCallHandler<ReqT, RespT> next) {

		String accessToken = requestHeaders.get(JWTConstants.JWT_METADATA_KEY);
		
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
		accessToken = accessToken.toLowerCase().substring(JWTConstants.BEARER_KEYWORD.length());
		
		if (accessToken == null || accessToken.length() == 0) {
			call.close(Status.UNAUTHENTICATED.withDescription("Access Token is missing from Metadata"), requestHeaders);
			return NOOP_LISTENER;
		}
		
		Context ctx = null;
		try {
			DecodedJWT verified = verifier.verify(accessToken);

			verifyJWT(verified);
			
			ctx = Context.current().
					withValue(JWTConstants.SUB_CTX_KEY, verified.getClaim("sub").asString());
			
		} catch (Exception e) {
			logger.log(Level.WARNING, "Verification failed - Unauthenticated", e);
			call.close(Status.UNAUTHENTICATED.withDescription("JWT Token is missing from Metadata"), requestHeaders);
			return NOOP_LISTENER;
		}
		
		return Contexts.interceptCall(ctx, call, requestHeaders, next);
	}
	
	private void verifyJWT(DecodedJWT token) throws CustomException {
		if (token.getIssuer() != null && token.getIssuer().equals(JWTConstants.TOKEN_ISSUER)) {
			throw new CustomException("Issuer not valid");
		}
		
		if (token.getAudience() != null && token.getAudience().equals(JWTConstants.TOKEN_AUDIENCE)) {
			throw new CustomException("Audience not valid");
		}
		
		Date current = new Date();
		
		if (!token.getIssuedAt().before(current)) {
			throw new CustomException("Token is not valid yet.");
		}
		
		if (!token.getExpiresAt().after(current)) {
			throw new CustomException("Token is already expired.");
		}
	}
}
