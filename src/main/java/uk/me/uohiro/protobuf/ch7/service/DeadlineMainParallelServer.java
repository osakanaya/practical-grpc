package uk.me.uohiro.protobuf.ch7.service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;

import io.grpc.Context;
import io.grpc.ManagedChannel;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineMainGrpc.DeadlineMainImplBase;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse.Builder;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineSubGrpc;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineSubGrpc.DeadlineSubFutureStub;
import uk.me.uohiro.protobuf.model.ch7.ex4.Empty;

public class DeadlineMainParallelServer {
	private static final Logger logger = Logger.getLogger(DeadlineMainParallelServer.class.getName());

	private final String host;
	private final int port;
	private final Server server;
	
	private final ManagedChannel deadlineSub1ServiceChannel;
	private final ManagedChannel deadlineSub2ServiceChannel;
	private final ManagedChannel deadlineSub3ServiceChannel;

	private final DeadlineSubFutureStub deadlineSub1ServiceFutureStub;
	private final DeadlineSubFutureStub deadlineSub2ServiceFutureStub;
	private final DeadlineSubFutureStub deadlineSub3ServiceFutureStub;

	public DeadlineMainParallelServer(String host, int port) throws IOException {
		this(ServerBuilder.forPort(port), host, port);
	}

	public DeadlineMainParallelServer(ServerBuilder<?> serverBuilder, String host, int port) {
		this.host = host;
		this.port = port;
		
		deadlineSub1ServiceChannel = NettyChannelBuilder.forAddress(host, 8101).usePlaintext().build();
		deadlineSub2ServiceChannel = NettyChannelBuilder.forAddress(host, 8102).usePlaintext().build();
		deadlineSub3ServiceChannel = NettyChannelBuilder.forAddress(host, 8103).usePlaintext().build();

		deadlineSub1ServiceFutureStub = DeadlineSubGrpc.newFutureStub(deadlineSub1ServiceChannel);
		deadlineSub2ServiceFutureStub = DeadlineSubGrpc.newFutureStub(deadlineSub2ServiceChannel);
		deadlineSub3ServiceFutureStub = DeadlineSubGrpc.newFutureStub(deadlineSub3ServiceChannel);

		DeadlineMainParallelService deadlineMainParallelService = new DeadlineMainParallelService(
				deadlineSub1ServiceFutureStub, deadlineSub2ServiceFutureStub, deadlineSub3ServiceFutureStub);
		this.server = serverBuilder.addService(deadlineMainParallelService).build();
	}

	public void start() throws IOException {
		server.start();
		logger.info("Server started, listening on " + port);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("*** Shutting down gRPC server since JVM is shutting down.");
				DeadlineMainParallelServer.this.stop();
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
		DeadlineMainParallelServer server = new DeadlineMainParallelServer("localhost", 8100);
		server.start();
		server.blockUntilShutdown();
	}
	
	class DeadlineMainParallelService extends DeadlineMainImplBase {
		private final DeadlineSubFutureStub deadlineSub1ServiceFutureStub;
		private final DeadlineSubFutureStub deadlineSub2ServiceFutureStub;
		private final DeadlineSubFutureStub deadlineSub3ServiceFutureStub;
		
		public DeadlineMainParallelService(
				DeadlineSubFutureStub deadlineSub1ServiceFutureStub,
				DeadlineSubFutureStub deadlineSub2ServiceFutureStub,
				DeadlineSubFutureStub deadlineSub3ServiceFutureStub
				) {
			this.deadlineSub1ServiceFutureStub = deadlineSub1ServiceFutureStub;
			this.deadlineSub2ServiceFutureStub = deadlineSub2ServiceFutureStub;
			this.deadlineSub3ServiceFutureStub = deadlineSub3ServiceFutureStub;
		}
		
		@Override
		public void fast(Empty request, StreamObserver<DeadlineResponse> responseObserver) {
			try {
				Context context = Context.current();
				if (context.getDeadline() != null) {
					context.getDeadline().runOnExpiration(() -> {
						logger.info("[main-fast]Deadline exceeded!");
					}, Executors.newSingleThreadScheduledExecutor());
				}

				ServerCallStreamObserver<DeadlineResponse> streamObserver = 
						(ServerCallStreamObserver<DeadlineResponse>)responseObserver;
				
				streamObserver.setOnCancelHandler(() -> {
					logger.warning("[main-fast-after]Call cancelled by client!");
					if (context.getDeadline() != null) {
						logger.info("[main-fast-after]Deadline reached?: " + context.getDeadline().isExpired());
						logger.info("[main-fast-after]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
					}
					logger.info("[main-fast-after]Invoke cancelled?: " + context.isCancelled());
					
				});

				if (context.getDeadline() != null) {
					logger.info("[main-fast-before]Deadline reached?: " + context.getDeadline().isExpired());
					logger.info("[main-fast-before]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
				}
				logger.info("[main-fast-before]Invoke cancelled?: " + context.isCancelled());

				Builder responseBuilder = DeadlineResponse.newBuilder();

				ListenableFuture<List<Builder>> responsesFuture = Futures.allAsList(
						Futures.transform(
								deadlineSub1ServiceFutureStub.fast(request), 
								(DeadlineResponse response) -> {
									return responseBuilder.addAllResult(response.getResultList());
								},
								MoreExecutors.directExecutor()),
						Futures.transform(
								deadlineSub2ServiceFutureStub.fast(request), 
								(DeadlineResponse response) -> {
									return responseBuilder.addAllResult(response.getResultList());
								},
								MoreExecutors.directExecutor()),
						Futures.transform(
								deadlineSub3ServiceFutureStub.fast(request), 
								(DeadlineResponse response) -> {
									return responseBuilder.addAllResult(response.getResultList());
								},
								MoreExecutors.directExecutor())
				);
				
				Futures.addCallback(responsesFuture, new FutureCallback<List<Builder>>() {
					@Override
					public void onFailure(Throwable t) {
						if (context.getDeadline() != null) {
							logger.info("[main-fast-after]Deadline reached?: " + context.getDeadline().isExpired());
							logger.info("[main-fast-after]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
						}
						logger.info("[main-fast-after]Invoke cancelled?: " + context.isCancelled());

						responseObserver.onError(t);
					}

					@Override
					public void onSuccess(@Nullable List<Builder> result) {
						if (context.getDeadline() != null) {
							logger.info("[main-fast-after]Deadline reached?: " + context.getDeadline().isExpired());
							logger.info("[main-fast-after]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
						}
						logger.info("[main-fast-after]Invoke cancelled?: " + context.isCancelled());
						
						responseObserver.onNext(responseBuilder.addResult("maim-success-fast").build());
						responseObserver.onCompleted();
					}
				}, MoreExecutors.directExecutor());
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
						logger.info("[main-slow]Deadline exceeded!");
					}, Executors.newSingleThreadScheduledExecutor());
				}

				if (context.getDeadline() != null) {
					logger.info("[main-slow-before]Deadline reached?: " + context.getDeadline().isExpired());
					logger.info("[main-slow-before]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
				}
				logger.info("[main-slow-before]Invoke cancelled?: " + context.isCancelled());

				Builder responseBuilder = DeadlineResponse.newBuilder();

				ListenableFuture<List<Builder>> responsesFuture = Futures.allAsList(
						Futures.transform(
								deadlineSub1ServiceFutureStub.slow(request), 
								(DeadlineResponse response) -> {
									logger.info("[main-slow]Received response from DeadlineSub1Server.");
									return responseBuilder.addAllResult(response.getResultList());
								},
								MoreExecutors.directExecutor()),
						Futures.transform(
								deadlineSub2ServiceFutureStub.slow(request), 
								(DeadlineResponse response) -> {
									logger.info("[main-slow]Received response from DeadlineSub2Server.");
									return responseBuilder.addAllResult(response.getResultList());
								},
								MoreExecutors.directExecutor()),
						Futures.transform(
								deadlineSub3ServiceFutureStub.slow(request), 
								(DeadlineResponse response) -> {
									logger.info("[main-slow]Received response from DeadlineSub3Server.");
									return responseBuilder.addAllResult(response.getResultList());
								},
								MoreExecutors.directExecutor())
				);
				
				ServerCallStreamObserver<DeadlineResponse> streamObserver = 
						(ServerCallStreamObserver<DeadlineResponse>)responseObserver;
				
				streamObserver.setOnCancelHandler(() -> {
					logger.warning("[main-slow-after]Call cancelled by client!");
					if (context.getDeadline() != null) {
						logger.info("[main-slow-after]Deadline reached?: " + context.getDeadline().isExpired());
						logger.info("[main-slow-after]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
					}
					logger.info("[main-slow-after]Invoke cancelled?: " + context.isCancelled());

					responsesFuture.cancel(true);
				});

				Futures.addCallback(responsesFuture, new FutureCallback<List<Builder>>() {
					@Override
					public void onFailure(Throwable t) {
						if (context.getDeadline() != null) {
							logger.info("[main-slow-after]Deadline reached?: " + context.getDeadline().isExpired());
							logger.info("[main-slow-after]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
						}
						logger.info("[main-slow-after]Invoke cancelled?: " + context.isCancelled());

						responseObserver.onError(t);
					}

					@Override
					public void onSuccess(@Nullable List<Builder> result) {
						if (context.getDeadline() != null) {
							logger.info("[main-slow-after]Deadline reached?: " + context.getDeadline().isExpired());
							logger.info("[main-slow-after]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
						}
						logger.info("[main-slow-after]Invoke cancelled?: " + context.isCancelled());
						
						responseObserver.onNext(responseBuilder.addResult("maim-success-slow").build());
						responseObserver.onCompleted();
					}
				}, MoreExecutors.directExecutor());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
