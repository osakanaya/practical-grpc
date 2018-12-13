package uk.me.uohiro.protobuf.ch10.ex3.service;

import java.io.IOException;
import java.util.logging.Logger;

import com.google.protobuf.util.FieldMaskUtil;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskRequest;
import uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskResponse;
import uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskServiceGrpc.FieldMaskServiceImplBase;

public class FieldMaskServer {
	private static final Logger logger = Logger.getLogger(FieldMaskServer.class.getName());

	private final int port;
	private final Server server;

	public FieldMaskServer(int port) throws IOException {
		this(ServerBuilder.forPort(port), port);
	}

	public FieldMaskServer(ServerBuilder<?> serverBuilder, int port) {
		this.port = port;
		this.server = serverBuilder.addService(new FieldMaskService()).build();
	}

	public void start() throws IOException {
		server.start();
		logger.info("Server started, listening on " + port);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("*** Shutting down gRPC server since JVM is shutting down.");
				FieldMaskServer.this.stop();
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
		FieldMaskServer server = new FieldMaskServer(8080);
		server.start();
		server.blockUntilShutdown();
	}
	
	class FieldMaskService extends FieldMaskServiceImplBase {
		public FieldMaskService() {
		}
		
		@Override
		public void processRequest(FieldMaskRequest request, StreamObserver<FieldMaskResponse> responseObserver) {
			logger.info("original request: " + request);
			
			FieldMaskRequest.Builder maskedRequestBuilder = FieldMaskRequest.newBuilder();
			FieldMaskUtil.merge(request.getMask(), request, maskedRequestBuilder);

			FieldMaskRequest maskedRequest =  maskedRequestBuilder.build();

			logger.info("masked request: " + maskedRequest);
			
			if (maskedRequest.hasStringValue()) {
				logger.info("string_value is not empty: " + maskedRequest.getStringValue().getValue());
			} else {
				logger.info("string_value is empty");
			}
			
			if (maskedRequest.hasInt32Value()) {
				logger.info("int32_value is not empty: " + maskedRequest.getInt32Value().getValue());
			} else {
				logger.info("int32_value is empty");
			}

			if (maskedRequest.hasNestedMessage()) {
				if (maskedRequest.getNestedMessage().hasStringValue()) {
					logger.info("nested_message/string_value is not empty: " + maskedRequest.getNestedMessage().getStringValue());
				} else {
					logger.info("nested_message/string_value is empty");
				}

				if (maskedRequest.getNestedMessage().hasInt32Value()) {
					logger.info("nested_message/int32_value is not empty: " + maskedRequest.getNestedMessage().getInt32Value());
				} else {
					logger.info("nested_message/int32_value is empty");
				}
			} else {
				logger.info("nested_message is empty");
			}
			
			FieldMaskResponse response = FieldMaskResponse.newBuilder().build();

			responseObserver.onNext(response);
			responseObserver.onCompleted();
		}
	}
}
