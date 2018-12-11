package uk.me.uohiro.protobuf.ch7.service;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import io.grpc.Context;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineSubGrpc.DeadlineSubImplBase;
import uk.me.uohiro.protobuf.model.ch7.ex4.Empty;

public class DeadlineSub2Server {
	private static final Logger logger = Logger.getLogger(DeadlineSub2Server.class.getName());

	private final int port;
	private final Server server;

	public DeadlineSub2Server(int port) throws IOException {
		this(ServerBuilder.forPort(port), port);
	}

	public DeadlineSub2Server(ServerBuilder<?> serverBuilder, int port) {
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
				DeadlineSub2Server.this.stop();
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
		DeadlineSub2Server server = new DeadlineSub2Server(8102);
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
				context.getDeadline().runOnExpiration(() -> {
					logger.info("[sub2-fast]Deadline exceeded!");
				}, Executors.newSingleThreadScheduledExecutor());

				logger.info("[sub2-fast-before]Deadline reached?: " + context.getDeadline().isExpired());
				logger.info("[sub2-fast-before]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
				logger.info("[sub2-fast-before]Invoke cancelled?: " + context.isCancelled());

				Thread.sleep(200L);
				
				logger.info("[sub2-fast-after]Deadline reached?: " + context.getDeadline().isExpired());
				logger.info("[sub2-fast-after]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
				logger.info("[sub2-fast-after]Invoke cancelled?: " + context.isCancelled());
				
				responseObserver.onNext(DeadlineResponse.newBuilder().addResult("sub2-success-fast").build());
				responseObserver.onCompleted();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void slow(Empty request, StreamObserver<DeadlineResponse> responseObserver) {
			try {
				Context context = Context.current();
				context.getDeadline().runOnExpiration(() -> {
					logger.info("[sub2-slow]Deadline exceeded!");
				}, Executors.newSingleThreadScheduledExecutor());

				logger.info("[sub2-slow-before]Deadline reached?: " + context.getDeadline().isExpired());
				logger.info("[sub2-slow-before]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
				logger.info("[sub2-slow-before]Invoke cancelled?: " + context.isCancelled());

				Thread.sleep(500L);
				
				logger.info("[sub2-slow-after]Deadline reached?: " + context.getDeadline().isExpired());
				logger.info("[sub2-slow-after]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
				logger.info("[sub2-slow-after]Invoke cancelled?: " + context.isCancelled());

				responseObserver.onNext(DeadlineResponse.newBuilder().addResult("sub2-success-slow").build());
				responseObserver.onCompleted();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
