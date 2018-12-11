package uk.me.uohiro.protobuf.ch7.service;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import io.grpc.Context;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineExampleGrpc.DeadlineExampleImplBase;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse;
import uk.me.uohiro.protobuf.model.ch7.ex4.Empty;

public class DeadlineServer {
	private static final Logger logger = Logger.getLogger(DeadlineServer.class.getName());

	private final int port;
	private final Server server;

	public DeadlineServer(int port) throws IOException {
		this(ServerBuilder.forPort(port), port);
	}

	public DeadlineServer(ServerBuilder<?> serverBuilder, int port) {
		this.port = port;
		this.server = serverBuilder.addService(new DeadlineService()).build();
	}

	public void start() throws IOException {
		server.start();
		logger.info("Server started, listening on " + port);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("*** Shutting down gRPC server since JVM is shutting down.");
				DeadlineServer.this.stop();
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
		DeadlineServer server = new DeadlineServer(8080);
		server.start();
		server.blockUntilShutdown();
	}
	
	class DeadlineService extends DeadlineExampleImplBase {
		public DeadlineService() {
		}
		
		@Override
		public void fast(Empty request, StreamObserver<DeadlineResponse> responseObserver) {
			try {
				Context context = Context.current();

				logger.info("[fast-before]Deadline reached?: " + context.getDeadline().isExpired());
				logger.info("[fast-before]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
				logger.info("[fast-before]Invoke cancelled?: " + context.isCancelled());

				Thread.sleep(200L);
				
				logger.info("[fast-after]Deadline reached?: " + context.getDeadline().isExpired());
				logger.info("[fast-after]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
				logger.info("[fast-after]Invoke cancelled?: " + context.isCancelled());
				
				context.getDeadline().runOnExpiration(() -> {
					logger.info("[fast]Deadline exceeded!");
				}, Executors.newSingleThreadScheduledExecutor());

				responseObserver.onNext(DeadlineResponse.newBuilder().addResult("success - fast").build());
				responseObserver.onCompleted();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void slow(Empty request, StreamObserver<DeadlineResponse> responseObserver) {
			try {
				Context context = Context.current();

				logger.info("[slow-before]Deadline reached?: " + context.getDeadline().isExpired());
				logger.info("[slow-before]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
				logger.info("[slow-before]Invoke cancelled?: " + context.isCancelled());

				Thread.sleep(10000L);
				
				logger.info("[slow-after]Deadline reached?: " + context.getDeadline().isExpired());
				logger.info("[slow-after]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
				logger.info("[slow-after]Invoke cancelled?: " + context.isCancelled());

				context.getDeadline().runOnExpiration(() -> {
					logger.info("[slow]Deadline exceeded!");
				}, Executors.newSingleThreadScheduledExecutor());

				responseObserver.onNext(DeadlineResponse.newBuilder().addResult("success - slow").build());
				responseObserver.onCompleted();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
