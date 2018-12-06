package uk.me.uohiro.protobuf.ch7.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerInterceptors;
import uk.me.uohiro.protobuf.ch7.interceptor.ExampleServerInterceptor;

public class InterceptorExampleServer {
	private static final Logger logger = Logger.getLogger(InterceptorExampleServer.class.getName());

	private final int port;
	private final Server server;

	public InterceptorExampleServer(int port) throws IOException {
		this(ServerBuilder.forPort(port), port);
	}

	public InterceptorExampleServer(ServerBuilder<?> serverBuilder, int port) {
		this.port = port;
		
	    ExampleServerInterceptor interceptor = new ExampleServerInterceptor(Arrays.asList(
	            IllegalArgumentException.class
	    ));
	    
		this.server = serverBuilder.addService(
				ServerInterceptors.intercept(new InterceptorExampleService(), interceptor)).build();
	}

	public void start() throws IOException {
		server.start();
		logger.info("Server started, listening on " + port);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("*** Shutting down gRPC server since JVM is shutting down.");
				InterceptorExampleServer.this.stop();
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
		InterceptorExampleServer server = new InterceptorExampleServer(8080);
		server.start();
		server.blockUntilShutdown();
	}
}
