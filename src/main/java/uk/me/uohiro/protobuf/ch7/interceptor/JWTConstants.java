package uk.me.uohiro.protobuf.ch7.interceptor;

import io.grpc.Context;
import io.grpc.Metadata;

public class JWTConstants {
	public static final String BEARER_KEYWORD = "bearer ";
		
	public static final String TOKEN_ISSUER = "http://localhost:9001/";
	public static final String TOKEN_AUDIENCE = "http://localhost:9002/";
	
	public static final Metadata.Key<String> AUTHORIZATION_METADATA_KEY = Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER);
	
	public static final Context.Key<String> SUB_CTX_KEY = Context.key("userId");
	public static final Context.Key<String> AUTHORIZATION_CTX_KEY = Context.key("authorization");
}
