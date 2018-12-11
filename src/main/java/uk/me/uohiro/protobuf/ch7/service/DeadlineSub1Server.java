package uk.me.uohiro.protobuf.ch7.service;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import io.grpc.Context;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineSubGrpc.DeadlineSubImplBase;
import uk.me.uohiro.protobuf.model.ch7.ex4.Empty;

public class DeadlineSub1Server {
	private static final Logger logger = Logger.getLogger(DeadlineSub1Server.class.getName());

	private final int port;
	private final Server server;

	public DeadlineSub1Server(int port) throws IOException {
		this(ServerBuilder.forPort(port), port);
	}

	public DeadlineSub1Server(ServerBuilder<?> serverBuilder, int port) {
		this.port = port;
		this.server = serverBuilder.addService(new DeadlineSubService()).build();
	}

	public void start() throws IOException {
		server.start();
		logger.info("Server started, listening on " + port);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("*** Shutting down gRPC server since JVM is shutting down.");
				DeadlineSub1Server.this.stop();
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
		DeadlineSub1Server server = new DeadlineSub1Server(8101);
		server.start();
		server.blockUntilShutdown();
	}
	
	class DeadlineSubService extends DeadlineSubImplBase {
		public DeadlineSubService() {
		}
		
		@Override
		public void fast(Empty request, StreamObserver<DeadlineResponse> responseObserver) {
			try {
				Context context = Context.current();
				if (context.getDeadline() != null) {
					context.getDeadline().runOnExpiration(() -> {
						logger.info("[sub1-fast]Deadline exceeded!");
					}, Executors.newSingleThreadScheduledExecutor());
				}

				ServerCallStreamObserver<DeadlineResponse> streamObserver = 
						(ServerCallStreamObserver<DeadlineResponse>)responseObserver;
				streamObserver.setOnCancelHandler(() -> {
					logger.warning("[sub1-fast-after]Call cancelled by client!");
				});

				if (context.getDeadline() != null) {
					logger.info("[sub1-fast-before]Deadline reached?: " + context.getDeadline().isExpired());
					logger.info("[sub1-fast-before]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
				}
				logger.info("[sub1-fast-before]Invoke cancelled?: " + context.isCancelled());

				Thread.sleep(200L);
				
				if (context.getDeadline() != null) {
					logger.info("[sub1-fast-after]Deadline reached?: " + context.getDeadline().isExpired());
					logger.info("[sub1-fast-after]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
				}
				logger.info("[sub1-fast-after]Invoke cancelled?: " + context.isCancelled());
				
				responseObserver.onNext(DeadlineResponse.newBuilder().addResult("sub1-success-fast").build());
				responseObserver.onCompleted();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void slow(Empty request, StreamObserver<DeadlineResponse> responseObserver) {
			try {
				Context context = Context.current();
				if (context.getDeadline() != null) {
					context.getDeadline().runOnExpiration(() -> {
						logger.info("[sub1-slow]Deadline exceeded!");
					}, Executors.newSingleThreadScheduledExecutor());
				}

				ServerCallStreamObserver<DeadlineResponse> streamObserver = 
						(ServerCallStreamObserver<DeadlineResponse>)responseObserver;
				streamObserver.setOnCancelHandler(() -> {
					logger.warning("[sub1-slow-after]Call cancelled by client!");
				});

				if (context.getDeadline() != null) {
					logger.info("[sub1-slow-before]Deadline reached?: " + context.getDeadline().isExpired());
					logger.info("[sub1-slow-before]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
				}
				logger.info("[sub1-slow-before]Invoke cancelled?: " + context.isCancelled());

				Thread.sleep(10000L);

				if (context.getDeadline() != null) {
					logger.info("[sub1-slow-after]Deadline reached?: " + context.getDeadline().isExpired());
					logger.info("[sub1-slow-after]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
				}
				logger.info("[sub1-slow-after]Invoke cancelled?: " + context.isCancelled());

				responseObserver.onNext(DeadlineResponse.newBuilder().addResult("sub1-success-slow").build());
				responseObserver.onCompleted();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
