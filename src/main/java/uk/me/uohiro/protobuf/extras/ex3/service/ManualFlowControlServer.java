package uk.me.uohiro.protobuf.extras.ex3.service;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.extras.ex3.HelloRequest;
import uk.me.uohiro.protobuf.model.extras.ex3.HelloResponse;
import uk.me.uohiro.protobuf.model.extras.ex3.StreamingGreeterGrpc;
import uk.me.uohiro.protobuf.model.extras.ex3.StreamingGreeterGrpc.StreamingGreeterImplBase;

public class ManualFlowControlServer {
	private static final Logger logger = Logger.getLogger(ManualFlowControlServer.class.getName());
	
	public static void main(String[] args) throws Exception {
		StreamingGreeterGrpc.StreamingGreeterImplBase service = new StreamingGreeterImplBase() {
			@Override
			public StreamObserver<HelloRequest> sayHelloStreaming(StreamObserver<HelloResponse> responseObserver) {
				final ServerCallStreamObserver<HelloResponse> serverCallStreamObserver 
					= (ServerCallStreamObserver<HelloResponse>)responseObserver;
				
				serverCallStreamObserver.disableAutoInboundFlowControl();
				
				final AtomicBoolean wasReady = new AtomicBoolean(false);
				
				serverCallStreamObserver.setOnReadyHandler(new Runnable() {
					public void run() {
						if (serverCallStreamObserver.isReady() && wasReady.compareAndSet(false, true)) {
							logger.info("READY");
							
							serverCallStreamObserver.request(1);
						}
					}
				});
				
				return new StreamObserver<HelloRequest>() {
					@Override
					public void onCompleted() {
						logger.info("COMPLETED");
						
						responseObserver.onCompleted();
					}

					@Override
					public void onError(Throwable t) {
						t.printStackTrace();
						
						responseObserver.onCompleted();
					}

					@Override
					public void onNext(HelloRequest request) {
						try {
							String name = request.getName();
							logger.info("--> " + name);
							
							Thread.sleep(100);
							
							String message = "Hello " + name;
							logger.info("<-- " + message);
							
							HelloResponse response = HelloResponse.newBuilder().setMessage(message).build();
							responseObserver.onNext(response);
							
							if (serverCallStreamObserver.isReady()) {
								logger.info("READY");
								serverCallStreamObserver.request(1);
							} else {
								logger.info("READY -> false");
								wasReady.set(false);
							}
						} catch (Throwable t) {
							t.printStackTrace();
							responseObserver.onError(
								Status.UNKNOWN.withDescription("Error handling request").withCause(t).asException()
							);
						}
					}
				};
			}
		};
		
		
		
		final Server server = ServerBuilder.forPort(8080).addService(service).build().start();
		
		logger.info("Listening on " + server.getPort());
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				logger.info("Shutting down");
				server.shutdown();
			}
		});
		
		server.awaitTermination();
	}
}
