package uk.me.uohiro.protobuf.ch10.ex1.service;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.ch10.ex1.v1.GreetingServiceGrpc.GreetingServiceImplBase;
import uk.me.uohiro.protobuf.model.ch10.ex1.v1.HelloRequest;
import uk.me.uohiro.protobuf.model.ch10.ex1.v1.HelloResponse;

public class Version1Server {
	private static final Logger logger = Logger.getLogger(Version1Server.class.getName());

	private final int port;
	private final Server server;

	public Version1Server(int port) throws IOException {
		this(ServerBuilder.forPort(port), port);
	}

	public Version1Server(ServerBuilder<?> serverBuilder, int port) {
		this.port = port;
		this.server = serverBuilder.addService(new Version1Service()).build();
	}

	public void start() throws IOException {
		server.start();
		logger.info("Server started, listening on " + port);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("*** Shutting down gRPC server since JVM is shutting down.");
				Version1Server.this.stop();
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
		Version1Server server = new Version1Server(8101);
		server.start();
		server.blockUntilShutdown();
	}
	
	class Version1Service extends GreetingServiceImplBase {
		public Version1Service() {
		}
		
		@Override
		public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
			logger.info("Got request: " + request);		

			String greeting = request.getGreeting();
			String name = request.getName().getFirstName();

			logger.info("greeting: " + greeting);
			logger.info("name: " + name);
			
			String reply = greeting + ", " + name + "!";
			HelloResponse response = HelloResponse.newBuilder().setReply(reply).build();
			
			responseObserver.onNext(response);
			responseObserver.onCompleted();
		}
	}
}
