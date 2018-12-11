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
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineSubGrpc.DeadlineSubImplBase;
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

	public DeadlineMainServer(ServerBuilder<?> serverBuilder, int port) {
		this.host = host;
		this.port = port;
		
		deadlineSubServiceChannel = NettyChannelBuilder.forAddress(host, 8102).usePlaintext().build();
		deadlineSubServiceBlockingStub = DeadlineSubGrpc.newBlockingStub(deadlineSubServiceChannel);

		deadlineMainService = new 
		
		this.server = serverBuilder.addService(new DeadlineSubService()).build();
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
		DeadlineMainServer server = new DeadlineMainServer(8101);
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
				logger.info("[main-fast]Deadline reached?: " + context.getDeadline().isExpired());
				logger.info("[main-fast]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
				logger.info("[main-fast]Invoke cancelled?: " + context.isCancelled());
				
				context.getDeadline().runOnExpiration(() -> {
					logger.info("[main-fast]Deadline exceeded!");
				}, Executors.newSingleThreadScheduledExecutor());
				
				responseObserver.onNext(DeadlineResponse.newBuilder().setMessage("main-success-fast").build());
				responseObserver.onCompleted();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void slow(Empty request, StreamObserver<DeadlineResponse> responseObserver) {
			try {
				Thread.sleep(10000L);
				
				Context context = Context.current();
				logger.info("[slow]Deadline reached?: " + context.getDeadline().isExpired());
				logger.info("[slow]Deadline time remaining: " + context.getDeadline().timeRemaining(TimeUnit.MILLISECONDS));
				logger.info("[slow]Invoke cancelled?: " + context.isCancelled());

				context.getDeadline().runOnExpiration(() -> {
					logger.info("[slow]Deadline exceeded!");
				}, Executors.newSingleThreadScheduledExecutor());

				responseObserver.onNext(DeadlineResponse.newBuilder().setMessage("success - slow").build());
				responseObserver.onCompleted();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
