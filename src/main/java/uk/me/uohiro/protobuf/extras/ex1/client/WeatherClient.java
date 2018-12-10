package uk.me.uohiro.protobuf.extras.ex1.client;

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
import io.grpc.StatusRuntimeException;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.extras.ex1.WeatherGrpc;
import uk.me.uohiro.protobuf.model.extras.ex1.WeatherGrpc.WeatherBlockingStub;
import uk.me.uohiro.protobuf.model.extras.ex1.WeatherGrpc.WeatherFutureStub;
import uk.me.uohiro.protobuf.model.extras.ex1.WeatherGrpc.WeatherStub;
import uk.me.uohiro.protobuf.model.extras.ex1.WeatherRequest;
import uk.me.uohiro.protobuf.model.extras.ex1.WeatherRequest.Coordinates;
import uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse;

public class WeatherClient {
	private static final Logger logger = Logger.getLogger(WeatherClient.class.getName());

	private final ManagedChannel channel;
	private final WeatherStub asyncStub;
	private final WeatherBlockingStub blockingStub;
	private final WeatherFutureStub futureStub;

	public WeatherClient(String host, int port) {
		this(NettyChannelBuilder.forAddress(host, port).usePlaintext());
	}

	public WeatherClient(ManagedChannelBuilder<?> channelBuilder) {
		channel = channelBuilder.build();

		asyncStub = WeatherGrpc.newStub(channel);
		blockingStub = WeatherGrpc.newBlockingStub(channel);
		futureStub = WeatherGrpc.newFutureStub(channel);
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public void getWeather_AsyncClient() throws Exception {
		info("*** GetWeather(Async Client) ***");
		
		CountDownLatch finishLatch = new CountDownLatch(1);
		
		WeatherRequest request = WeatherRequest.newBuilder()
				.setCoordinates(Coordinates.newBuilder().setLatitude(420000000)
				.setLongitude(-720000000)).build();
		
		asyncStub.getCurrent(request, new StreamObserver<WeatherResponse>() {
			@Override
			public void onNext(WeatherResponse response) {
				info("Current weather: {0}", response);
			}
			
			@Override
			public void onError(Throwable t) {
				warning("Cannot get weather. Message: {0}", t.getMessage());
			}
			
			@Override
			public void onCompleted() {
				info("Stream completed.");
				finishLatch.countDown();
			}
		});
		
		finishLatch.await();
	}
	
	public void getWeather_SyncClient() {
		info("*** GetWeather(Sync Client) ***");
		
		WeatherRequest request = WeatherRequest.newBuilder()
				.setCoordinates(Coordinates.newBuilder().setLatitude(420000000)
				.setLongitude(-720000000)).build();

		try {
			WeatherResponse response = blockingStub.getCurrent(request);
			info("Current weather: {0}", response);
		} catch (StatusRuntimeException e) {
			warning("Cannot get weather. Message: {0}", e.getMessage());
		}
	}
	
	public void getWeather_ListenableFutureAsyncClient() {
		WeatherRequest request = WeatherRequest.newBuilder()
				.setCoordinates(Coordinates.newBuilder().setLatitude(420000000)
				.setLongitude(-720000000)).build();

		ListenableFuture<WeatherResponse> future = futureStub.getCurrent(request);
		
		Futures.addCallback(future, new FutureCallback<WeatherResponse>() {
			@Override
			public void onFailure(Throwable t) {
				warning("Cannot get weather. Message: {0}", t.getMessage());
			}

			@Override
			public void onSuccess(@Nullable WeatherResponse response) {
				info("Current weather: {0}", response);
			}
		}, MoreExecutors.directExecutor());
	}
	
	public void getWeather_ListenableFutureAsyncClient2() {
		WeatherRequest request = WeatherRequest.newBuilder()
				.setCoordinates(Coordinates.newBuilder().setLatitude(420000000)
				.setLongitude(-720000000)).build();

		Futures.transform(futureStub.getCurrent(request), response -> {
			info("Current weather: {0}", response);
			return response;
		}, MoreExecutors.directExecutor());
	}
	
	public void getWeather_FutureStub() {
		info("*** GetWeather ***");
	}
	
	public static void main(String[] args) throws Exception {

		WeatherClient client = new WeatherClient("localhost", 8080);
		
		try {
			client.getWeather_AsyncClient();
			client.getWeather_SyncClient();
			client.getWeather_ListenableFutureAsyncClient();
			client.getWeather_ListenableFutureAsyncClient2();
		} finally {
			client.shutdown();
		}
	}

	private void info(String msg, Object... params) {
		logger.log(Level.INFO, msg, params);
	}
	
	private void warning(String msg, Object... params) {
		logger.log(Level.INFO, msg, params);
	}
}
