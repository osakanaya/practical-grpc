package uk.me.uohiro.protobuf.ch10.ex1.service;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.ch10.ex1.v2.GreetingServiceGrpc.GreetingServiceImplBase;
import uk.me.uohiro.protobuf.model.ch10.ex1.v2.HelloRequest;
import uk.me.uohiro.protobuf.model.ch10.ex1.v2.HelloResponse;

public class Version2Server {
	private static final Logger logger = Logger.getLogger(Version2Server.class.getName());

	private final int port;
	private final Server server;

	public Version2Server(int port) throws IOException {
		this(ServerBuilder.forPort(port), port);
	}

	public Version2Server(ServerBuilder<?> serverBuilder, int port) {
		this.port = port;
		this.server = serverBuilder.addService(new Version2Service()).build();
	}

	public void start() throws IOException {
		server.start();
		logger.info("Server started, listening on " + port);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("*** Shutting down gRPC server since JVM is shutting down.");
				Version2Server.this.stop();
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
		Version2Server server = new Version2Server(8102);
		server.start();
		server.blockUntilShutdown();
	}
	
	class Version2Service extends GreetingServiceImplBase {
		public Version2Service() {
		}
		
		@Override
		public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
			logger.info("Got request: " + request);		

			String englishGreeting = request.getEnglishGreeting();
			String japaneseGreeting = request.getJapaneseGreeting();
			logger.info("englishGreeting: " + englishGreeting);
			logger.info("japaneseGreeting: " + japaneseGreeting);
			
			String firstName = request.getName().getFirstName();
			String lastName = request.getName().getLastName();
			logger.info("firstName: " + firstName);
			logger.info("lastName: " + lastName);
			
			String englishReply = englishGreeting + ", " + firstName + " " + lastName + "!";
			String japaneseReply = japaneseGreeting + ", " + lastName + " " + firstName + "さん!";
			HelloResponse response = HelloResponse.newBuilder().setEnglishReply(englishReply).setJapaneseReply(japaneseReply).build();
			
			responseObserver.onNext(response);
			responseObserver.onCompleted();
		}
	}
}
