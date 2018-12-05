package uk.me.uohiro.protobuf.ch6.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class DatabaseServer {
	private static final Logger logger = Logger.getLogger(DatabaseServer.class.getName());

	private static final Collection<String> contents = Arrays.asList(
			"Highest ranked content", 
			"Some ranked content",
			"Some ranked content", 
			"Lowest ranked content"
	);

	private final int port;
	private final Server server;

	public DatabaseServer(int port) throws Exception {
		this(port, contents);
	}

	public DatabaseServer(int port, Collection<String> contents) throws IOException {
		this(ServerBuilder.forPort(port), port, contents);
	}

	public DatabaseServer(ServerBuilder<?> serverBuilder, int port, Collection<String> contents) {
		this.port = port;
		this.server = serverBuilder.addService(new DatabaseService(contents)).build();
	}

	public void start() throws IOException {
		server.start();
		logger.info("Server started, listening on " + port);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("*** Shutting down gRPC server since JVM is shutting down.");
				DatabaseServer.this.stop();
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
		DatabaseServer server = new DatabaseServer(8080);
		server.start();
		server.blockUntilShutdown();
	}
}
