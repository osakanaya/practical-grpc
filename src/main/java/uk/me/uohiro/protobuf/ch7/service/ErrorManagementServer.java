package uk.me.uohiro.protobuf.ch7.service;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class ErrorManagementServer {
	private static final Logger logger = Logger.getLogger(ErrorManagementServer.class.getName());

	private final int port;
	private final Server server;

	public ErrorManagementServer(int port) throws IOException {
		this(ServerBuilder.forPort(port), port);
	}

	public ErrorManagementServer(ServerBuilder<?> serverBuilder, int port) {
		this.port = port;
		this.server = serverBuilder.addService(new ErrorManagementService()).build();
	}

	public void start() throws IOException {
		server.start();
		logger.info("Server started, listening on " + port);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("*** Shutting down gRPC server since JVM is shutting down.");
				ErrorManagementServer.this.stop();
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
		ErrorManagementServer server = new ErrorManagementServer(8080);
		server.start();
		server.blockUntilShutdown();
	}
}
