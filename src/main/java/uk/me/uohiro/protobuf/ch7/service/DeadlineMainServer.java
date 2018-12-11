package uk.me.uohiro.protobuf.ch7.service;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import io.grpc.Context;
import io.grpc.ManagedChannel;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineMainGrpc.DeadlineMainImplBase;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineSubGrpc;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineSubGrpc.DeadlineSubBlockingStub;
import uk.me.uohiro.protobuf.model.ch7.ex4.Empty;

public class DeadlineMainServer {
	private static final Logger logger = Logger.getLogger(DeadlineMainServer.class.getName());

	private final String host;
	private final int port;
	private final Server server;
	
	private final ManagedChannel deadlineSubServiceChannel;
	private final DeadlineSubBlockingStub deadlineSubServiceBlockingStub;

	public DeadlineMainServer(String host, int port) throws IOException {
		this(ServerBuilder.forPort(port), host, port);
	}

	public DeadlineMainServer(ServerBuilder<?> serverBuilder, String host, int port) {
		this.host = host;
		this.port = port;
		
		deadlineSubServiceChannel = NettyChannelBuilder.forAddress(host, 8102).usePlaintext().build();
		deadlineSubServiceBlockingStub = DeadlineSubGrpc.newBlockingStub(deadlineSubServiceChannel);

		DeadlineMainService deadlineMainService = new DeadlineMainService(deadlineSubServiceBlockingStub);
		this.server = serverBuilder.addService(deadlineMainService).build();
	}

	public void start() throws IOException {
		server.start();
		logger.info("Server started, listening on " + port);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("*** Shutting down gRPC server since JVM is shutting down.");
				DeadlineMainServer.this.stop();
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
		DeadlineMainServer server = new DeadlineMainServer("localhost", 8101);
		server.start();
		server.blockUntilShutdown();
	}
	
	class DeadlineMainService extends DeadlineMainImplBase {
		private final DeadlineSubBlockingStub deadlineSubServiceBlockingStub;
		
		public DeadlineMainService(DeadlineSubBlockingStub deadlineSubServiceBlockingStub) {
			this.deadlineSubServiceBlockingStub = deadlineSubServiceBlockingStub;
		}
		
		@Override
		public void fast(Empty request, StreamObserver<DeadlineResponse> responseObserver) {
			try {
				Context context = Context.current();
				context.getDeadline().runOnExpiration(() -> {
					logger.info("[main-fast]Deadline exceeded!");
				}, Executors.newSingleThreadScheduledExecutor());

				logger.info("[main-fast-before]Deadline reached?: " + context.getDeadline().isExpired());
				logger.info("[main-fast-before]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
				logger.info("[main-fast-before]Invoke cancelled?: " + context.isCancelled());
				
				DeadlineResponse subResponse = deadlineSubServiceBlockingStub.fast(Empty.newBuilder().build());
				
				logger.info("[main-fast-after]Deadline reached?: " + context.getDeadline().isExpired());
				logger.info("[main-fast-after]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
				logger.info("[main-fast-after]Invoke cancelled?: " + context.isCancelled());

				DeadlineResponse mainResponse = DeadlineResponse.newBuilder().setMessage("maim-success-fast," + subResponse.getMessage()).build();
				responseObserver.onNext(mainResponse);
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
					logger.info("[main-slow]Deadline exceeded!");
				}, Executors.newSingleThreadScheduledExecutor());

				logger.info("[main-slow-before]Deadline reached?: " + context.getDeadline().isExpired());
				logger.info("[main-slow-before]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
				logger.info("[main-slow-before]Invoke cancelled?: " + context.isCancelled());
				
				DeadlineResponse subResponse = deadlineSubServiceBlockingStub.slow(Empty.newBuilder().build());
				
				logger.info("[main-slow-after]Deadline reached?: " + context.getDeadline().isExpired());
				logger.info("[main-slow-after]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
				logger.info("[main-slow-after]Invoke cancelled?: " + context.isCancelled());

				DeadlineResponse mainResponse = DeadlineResponse.newBuilder().setMessage("maim-success-slow," + subResponse.getMessage()).build();
				responseObserver.onNext(mainResponse);
				responseObserver.onCompleted();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
