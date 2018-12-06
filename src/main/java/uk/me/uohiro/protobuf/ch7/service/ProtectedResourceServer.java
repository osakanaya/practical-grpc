package uk.me.uohiro.protobuf.ch7.service;

import java.io.IOException;
import java.net.URL;
import java.security.interfaces.RSAPublicKey;
import java.util.logging.Logger;

import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.UrlJwkProvider;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerInterceptors;
import uk.me.uohiro.protobuf.ch7.interceptor.JWTServerInterceptor;

public class ProtectedResourceServer {
	private static final Logger logger = Logger.getLogger(ProtectedResourceServer.class.getName());

	private final int port;
	private final Server server;

	public ProtectedResourceServer(int port, JWTVerifier verifier) throws IOException {
		this(ServerBuilder.forPort(port), port, verifier);
	}

	public ProtectedResourceServer(ServerBuilder<?> serverBuilder, int port, JWTVerifier verifier) {
		this.port = port;

		JWTServerInterceptor interceptor = new JWTServerInterceptor(verifier);
		this.server = serverBuilder.addService(
				ServerInterceptors.intercept(new ProtectedResourceService(), interceptor)).build();
	}

	public void start() throws IOException {
		server.start();
		logger.info("Server started, listening on " + port);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("*** Shutting down gRPC server since JVM is shutting down.");
				ProtectedResourceServer.this.stop();
				System.err.println("*** Server shut down.");
			}
		});
	}

	public void stop() {
		if (server != null) {
			server.shutdown();
		}
	}

	private void blockUntilShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}

	public static void main(String[] args) throws Exception {
		// 認可サーバの公開鍵を取得する
		URL keyStore = ProtectedResourceServer.class.getClassLoader().getResource("key_store.json");
		JwkProvider provider = new UrlJwkProvider(keyStore);
		Jwk jwk = provider.get("authserver");		

		// JWTVerifierを生成する
		Algorithm algorithm = Algorithm.RSA256((RSAPublicKey)jwk.getPublicKey(), null);
		JWTVerifier verifier = JWT.require(algorithm).build();
		ProtectedResourceServer server = new ProtectedResourceServer(8080, verifier);
		server.start();
		server.blockUntilShutdown();
	}
}
