package uk.me.uohiro.protobuf.ch6.service;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class TokenizeServer {
	private static final Logger logger = Logger.getLogger(TokenizeServer.class.getName());

	private final int port;
	private final Server server;

	public TokenizeServer(int port) throws Exception {
		this(ServerBuilder.forPort(port), port);
	}

	public TokenizeServer(ServerBuilder<?> serverBuilder, int port) {
		this.port = port;
		this.server = serverBuilder.addService(new TokenizerService()).build();
	}

	public void start() throws IOException {
		server.start();
		logger.log(Level.INFO, "Server started, listening on {0}", port);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				logger.warning("*** Shutting down gRPC server since JVM is shutting down.");
				TokenizeServer.this.stop();
				logger.warning("*** Server shut down.");
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
		TokenizeServer server = new TokenizeServer(8080);
		server.start();
		server.blockUntilShutdown();
	}
}
