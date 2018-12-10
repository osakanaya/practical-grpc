package uk.me.uohiro.protobuf.extras.ex1.service;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.NettyServerBuilder;

public class WeatherServer {
	private static final Logger logger = Logger.getLogger(WeatherServer.class.getName());

	private final int port;
	private final Server server;

	public WeatherServer(int port) throws IOException {
		this(NettyServerBuilder.forPort(port), port);
	}

	public WeatherServer(ServerBuilder<?> serverBuilder, int port) {
		this.port = port;
		this.server = serverBuilder.addService(new WeatherService()).build();
	}

	public void start() throws IOException {
		server.start();
		logger.info("Server started, listening on " + port);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("*** Shutting down gRPC server since JVM is shutting down.");
				WeatherServer.this.stop();
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
		WeatherServer server = new WeatherServer(8080);
		server.start();
		server.blockUntilShutdown();
	}
}
