package uk.me.uohiro.protobuf.ch7.client;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Logger;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

public class JWTUtil {
	private static final Logger logger = Logger.getLogger(JWTUtil.class.getName());
	
	/*
	 * 以下で作成したプライベートキーをロードする
	 * 
	 * openssl genrsa -out private_key.pem 2048
	 * penssl pkcs8 -topk8 -inform PEM -outform DER -in private_key.pem -out private_key.der -nocrypt
	 * 
	 */
	public static PrivateKey loadRSAPrivateKey() throws Exception {
		byte[] privateKeyBytes = null;
	    byte[] buffer = new byte[1024];
	    InputStream privateKeyStream = null;
	    ByteArrayOutputStream baos = null;
	    try {
			privateKeyStream = OAuthClient.class.getClassLoader().getResourceAsStream("private_key.der");
	    	baos = new ByteArrayOutputStream();

	    	while(true) {
		        int len = privateKeyStream.read(buffer);
		        if(len < 0) {
		            break;
		        }
		        baos.write(buffer, 0, len);
		    }
		    privateKeyBytes=  baos.toByteArray();
	    } finally {
	    	if (privateKeyStream != null) {
	    		try {
	    			privateKeyStream.close();
	    		} catch (Exception e) {}
	    	}
	    	if (baos != null) {
	    		try {
	    			baos.close();
	    		} catch (Exception e) {}
	    	}
	    }

	    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(privateKeyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return keyFactory.generatePrivate(spec);
	}

	/*
	 * 以下で作成したパブリックキーをロードする
	 * 
	 * openssl rsa -in private_key.pem -pubout -outform DER -out public_key.der
	 */
	public static PublicKey loadRSAPublicKey() throws Exception {
		byte[] publicKeyBytes = null;
	    byte[] buffer = new byte[1024];
	    InputStream publicKeyStream = null;
	    ByteArrayOutputStream baos = null;
	    try {
			publicKeyStream = OAuthClient.class.getClassLoader().getResourceAsStream("public_key.der");
	    	baos = new ByteArrayOutputStream();

	    	while(true) {
		        int len = publicKeyStream.read(buffer);
		        if(len < 0) {
		            break;
		        }
		        baos.write(buffer, 0, len);
		    }
		    publicKeyBytes=  baos.toByteArray();
	    } finally {
	    	if (publicKeyStream != null) {
	    		try {
	    			publicKeyStream.close();
	    		} catch (Exception e) {}
	    	}
	    	if (baos != null) {
	    		try {
	    			baos.close();
	    		} catch (Exception e) {}
	    	}
	    }

	    X509EncodedKeySpec  spec = new X509EncodedKeySpec (publicKeyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return keyFactory.generatePublic(spec);
	}
	
	/*
	 * RSAキーのキーペアを作成する
	 */
	public static RSAKey generateRSAKey() throws Exception {
		RSAKey jwk = new RSAKey.Builder((RSAPublicKey)loadRSAPublicKey())
				.privateKey((RSAPrivateKey)loadRSAPrivateKey())
				.keyID("authserver")
				.build();
		
		return jwk;
	}

	// 署名付きのJWTトークンを生成する
	public static String createJWTToken() throws Exception {
		// RSAキーペア
		RSAKey jwk = generateRSAKey();
		
		// ペイロードのクレームを設定する
		Date issuedAt = new Date();
		Date expiresAt = new Date(issuedAt.getTime() + 5 * 60 * 1000L);

		JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
				.subject("hideo")
				.issuer("http://localhost:9001/")
				.audience("http://localhost:9002/")
				.issueTime(issuedAt)
				.expirationTime(expiresAt)
				.jwtID(UUID.randomUUID().toString())
				.build();

		// JWTトークンに署名する
		JWSSigner signer = new RSASSASigner(jwk.toPrivateKey());
		
		SignedJWT signedJWT = new SignedJWT(
			    new JWSHeader.Builder(JWSAlgorithm.RS256).keyID(jwk.getKeyID()).build(),
			    claimsSet);

		signedJWT.sign(signer);

		// JWTトークンのペイロードを確認する
		logger.info("[access token] header: " + signedJWT.getHeader().toJSONObject().toJSONString());
		logger.info("[access token] payload: " + signedJWT.getPayload().toJSONObject().toJSONString());
		
		// Compact Serialization形式で返却する
		return signedJWT.serialize();
	}
}
