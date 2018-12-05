package uk.me.uohiro.protobuf.ch6.service;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class ArchiverServer {
	private static final Logger logger = Logger.getLogger(ArchiverServer.class.getName());

	private final int port;
	private final Server server;

	public ArchiverServer(int port) throws Exception {
		this(ServerBuilder.forPort(port), port);
	}

	public ArchiverServer(ServerBuilder<?> serverBuilder, int port) {
		this.port = port;
		this.server = serverBuilder.addService(new ArchiverService()).build();
	}

	public void start() throws IOException {
		server.start();
		logger.info("Server started, listening on " + port);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("*** Shutting down gRPC server since JVM is shutting down.");
				ArchiverServer.this.stop();
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
		ArchiverServer server = new ArchiverServer(8080);
		server.start();
		server.blockUntilShutdown();
	}
}
