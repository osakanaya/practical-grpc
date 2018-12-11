package uk.me.uohiro.protobuf.ch7.service;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.google.common.util.concurrent.MoreExecutors;

import io.grpc.Context;
import io.grpc.Context.CancellationListener;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineExampleGrpc.DeadlineExampleImplBase;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse;
import uk.me.uohiro.protobuf.model.ch7.ex4.Empty;

public class CancellationServer2 {
	private static final Logger logger = Logger.getLogger(CancellationServer2.class.getName());

	private final int port;
	private final Server server;

	public CancellationServer2(int port) throws IOException {
		this(ServerBuilder.forPort(port), port);
	}

	public CancellationServer2(ServerBuilder<?> serverBuilder, int port) {
		this.port = port;
		this.server = serverBuilder.addService(new CancellationService()).build();
	}

	public void start() throws IOException {
		server.start();
		logger.info("Server started, listening on " + port);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("*** Shutting down gRPC server since JVM is shutting down.");
				CancellationServer2.this.stop();
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
		CancellationServer2 server = new CancellationServer2(8080);
		server.start();
		server.blockUntilShutdown();
	}
	
	class CancellationService extends DeadlineExampleImplBase {
		public CancellationService() {
		}
		
		@Override
		public void fast(Empty request, StreamObserver<DeadlineResponse> responseObserver) {
			try {
				Context context = Context.current();
				if (context.getDeadline() != null) {
					context.getDeadline().runOnExpiration(() -> {
						logger.info("[fast]Deadline exceeded!");
					}, Executors.newSingleThreadScheduledExecutor());
				}

				Context.current().withCancellation().addListener(new CancellationListener() {
					@Override
					public void cancelled(Context context) {
						logger.warning("[fast-after]Call cancelled by client!");
						if (context.getDeadline() != null) {
							logger.info("[fast-after]Deadline reached?: " + context.getDeadline().isExpired());
							logger.info("[fast-after]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
						}
						logger.info("[fast-after]Invoke cancelled?: " + context.isCancelled());
					}
				}, MoreExecutors.directExecutor());
				
				if (context.getDeadline() != null) {
					logger.info("[fast-before]Deadline reached?: " + context.getDeadline().isExpired());
					logger.info("[fast-before]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
				}
				logger.info("[fast-before]Invoke cancelled?: " + context.isCancelled());

				Thread.sleep(200L);
				
				if (context.getDeadline() != null) {
					logger.info("[fast-after]Deadline reached?: " + context.getDeadline().isExpired());
					logger.info("[fast-after]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
				}
				logger.info("[fast-after]Invoke cancelled?: " + context.isCancelled());
				
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
				if (context.getDeadline() != null) {
					context.getDeadline().runOnExpiration(() -> {
						logger.info("[slow]Deadline exceeded!");
					}, Executors.newSingleThreadScheduledExecutor());
				}

				Context.current().withCancellation().addListener(new CancellationListener() {
					@Override
					public void cancelled(Context context) {
						logger.warning("[fast-after]Call cancelled by client!");
						if (context.getDeadline() != null) {
							logger.info("[fast-after]Deadline reached?: " + context.getDeadline().isExpired());
							logger.info("[fast-after]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
						}
						logger.info("[fast-after]Invoke cancelled?: " + context.isCancelled());
					}
				}, MoreExecutors.directExecutor());
				
				if (context.getDeadline() != null) {
					logger.info("[slow-before]Deadline reached?: " + context.getDeadline().isExpired());
					logger.info("[slow-before]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
				}
				logger.info("[slow-before]Invoke cancelled?: " + context.isCancelled());

				Thread.sleep(10000L);
				
				if (context.getDeadline() != null) {
					logger.info("[slow-after]Deadline reached?: " + context.getDeadline().isExpired());
					logger.info("[slow-after]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
				}
				logger.info("[slow-after]Invoke cancelled?: " + context.isCancelled());

				responseObserver.onNext(DeadlineResponse.newBuilder().addResult("success - slow").build());
				responseObserver.onCompleted();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
