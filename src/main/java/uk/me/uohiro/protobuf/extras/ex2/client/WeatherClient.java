package uk.me.uohiro.protobuf.extras.ex2.client;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.netty.NettyChannelBuilder;
import uk.me.uohiro.protobuf.model.extras.ex2.Coordinates;
import uk.me.uohiro.protobuf.model.extras.ex2.WeatherGrpc;
import uk.me.uohiro.protobuf.model.extras.ex2.WeatherGrpc.WeatherBlockingStub;
import uk.me.uohiro.protobuf.model.extras.ex2.WeatherRequest;
import uk.me.uohiro.protobuf.model.extras.ex2.WeatherResponse;

public class WeatherClient {
	private static final Logger logger = Logger.getLogger(WeatherClient.class.getName());

	private final ManagedChannel channel;
	private final WeatherBlockingStub blockingStub;

	public WeatherClient(String host, int port) {
		this(NettyChannelBuilder.forAddress(host, port).usePlaintext());
	}

	public WeatherClient(ManagedChannelBuilder<?> channelBuilder) {
		channel = channelBuilder.build();

		blockingStub = WeatherGrpc.newBlockingStub(channel);
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
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
	
	public static void main(String[] args) throws Exception {

		WeatherClient client = new WeatherClient("localhost", 8080);
		
		try {
			client.getWeather_SyncClient();
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
