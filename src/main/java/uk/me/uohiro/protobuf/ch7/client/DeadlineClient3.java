package uk.me.uohiro.protobuf.ch7.client;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineExampleGrpc;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineExampleGrpc.DeadlineExampleFutureStub;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse;
import uk.me.uohiro.protobuf.model.ch7.ex4.Empty;

public class DeadlineClient3 {
	private static final Logger logger = Logger.getLogger(DeadlineClient3.class.getName());

	private final ManagedChannel channel;
	private final DeadlineExampleFutureStub futureStub;

	public DeadlineClient3(String host, int port) {
		this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
	}

	public DeadlineClient3(ManagedChannelBuilder<?> channelBuilder) {
		channel = channelBuilder.build();
		futureStub = DeadlineExampleGrpc.newFutureStub(channel);
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public void access() throws InterruptedException {
		Empty request = Empty.newBuilder().build();

		CountDownLatch finishLatch = new CountDownLatch(1);
		
		ListenableFuture<DeadlineResponse> responseFuture = futureStub.slow(request);
		Futures.addCallback(responseFuture, new FutureCallback<DeadlineResponse>() {

			@Override
			public void onFailure(Throwable t) {
				warning("Cannot get result. Message: {0}", t.getMessage());
				finishLatch.countDown();
			}

			@Override
			public void onSuccess(@Nullable DeadlineResponse response) {
				info("Result: {0}", String.join(",", response.getResultList()));
				finishLatch.countDown();
			}
		}, MoreExecutors.directExecutor());
		
		finishLatch.await();
	}
		
	public void cancel() throws InterruptedException {
		Empty request = Empty.newBuilder().build();
		
		CountDownLatch finishLatch = new CountDownLatch(1);

		ListenableFuture<DeadlineResponse> responseFuture = futureStub.withDeadlineAfter(3000L, TimeUnit.MILLISECONDS).slow(request);
		Futures.addCallback(responseFuture, new FutureCallback<DeadlineResponse>() {
			@Override
			public void onFailure(Throwable t) {
				warning("Cannot get result. Message: {0}", t.getMessage());
				finishLatch.countDown();
			}

			@Override
			public void onSuccess(@Nullable DeadlineResponse response) {
				info("Result: {0}", String.join(",", response.getResultList()));
				finishLatch.countDown();
			}
		}, MoreExecutors.directExecutor());
		
		finishLatch.await();
	}

	public static void main(String[] args) throws Exception {

		DeadlineClient3 client = new DeadlineClient3("localhost", 8080);

		try {
			client.access();
			client.cancel();
		} finally {
			client.shutdown();
		}
	}

	private void info(String msg, Object... params) {
		logger.log(Level.INFO, msg, params);
	}

	private void warning(String msg, Object... params) {
		logger.log(Level.WARNING, msg, params);
	}
}
