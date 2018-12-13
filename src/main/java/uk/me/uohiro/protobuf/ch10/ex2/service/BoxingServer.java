package uk.me.uohiro.protobuf.ch10.ex2.service;

import java.io.IOException;
import java.util.logging.Logger;

import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.ch10.ex2.BoxingRequest;
import uk.me.uohiro.protobuf.model.ch10.ex2.BoxingResponse;
import uk.me.uohiro.protobuf.model.ch10.ex2.BoxingServiceGrpc.BoxingServiceImplBase;

public class BoxingServer {
	private static final Logger logger = Logger.getLogger(BoxingServer.class.getName());

	private final int port;
	private final Server server;

	public BoxingServer(int port) throws IOException {
		this(ServerBuilder.forPort(port), port);
	}

	public BoxingServer(ServerBuilder<?> serverBuilder, int port) {
		this.port = port;
		this.server = serverBuilder.addService(new BoxingService()).build();
	}

	public void start() throws IOException {
		server.start();
		logger.info("Server started, listening on " + port);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("*** Shutting down gRPC server since JVM is shutting down.");
				BoxingServer.this.stop();
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
		BoxingServer server = new BoxingServer(8080);
		server.start();
		server.blockUntilShutdown();
	}
	
	class BoxingService extends BoxingServiceImplBase {
		public BoxingService() {
		}
		
		@Override
		public void processRequest(BoxingRequest request, StreamObserver<BoxingResponse> responseObserver) {
			if (request.hasStringValue1()) {
				logger.info("string_value1 is not empty: " + request.getStringValue1().getValue());
			} else {
				logger.info("string_value1 is empty");
			}

			if (request.hasStringValue2()) {
				logger.info("string_value2 is not empty: " + request.getStringValue2().getValue());
			} else {
				logger.info("string_value2 is empty");
			}

			if (request.hasInt32Value1()) {
				logger.info("int32_value1 is not empty: " + request.getInt32Value1().getValue());
			} else {
				logger.info("int32_value1 is empty");
			}

			if (request.hasInt32Value2()) {
				logger.info("int32_value2 is not empty: " + request.getInt32Value2().getValue());
			} else {
				logger.info("int32_value2 is empty");
			}

			BoxingResponse response = BoxingResponse.newBuilder()
					.setStringValue2(StringValue.newBuilder().setValue("value2"))
					.setInt32Value2(Int32Value.newBuilder().setValue(200)).build();
			
			responseObserver.onNext(response);
			responseObserver.onCompleted();
		}
	}
}
