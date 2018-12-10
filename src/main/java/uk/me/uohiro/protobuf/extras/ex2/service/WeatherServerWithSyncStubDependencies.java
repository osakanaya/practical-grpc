package uk.me.uohiro.protobuf.extras.ex2.service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.extras.ex2.HumidityResponse;
import uk.me.uohiro.protobuf.model.extras.ex2.HumidityServiceGrpc;
import uk.me.uohiro.protobuf.model.extras.ex2.HumidityServiceGrpc.HumidityServiceBlockingStub;
import uk.me.uohiro.protobuf.model.extras.ex2.Temperature;
import uk.me.uohiro.protobuf.model.extras.ex2.TemperatureServiceGrpc;
import uk.me.uohiro.protobuf.model.extras.ex2.TemperatureServiceGrpc.TemperatureServiceBlockingStub;
import uk.me.uohiro.protobuf.model.extras.ex2.WeatherGrpc.WeatherImplBase;
import uk.me.uohiro.protobuf.model.extras.ex2.WeatherRequest;
import uk.me.uohiro.protobuf.model.extras.ex2.WeatherResponse;
import uk.me.uohiro.protobuf.model.extras.ex2.Wind;
import uk.me.uohiro.protobuf.model.extras.ex2.WindServiceGrpc;
import uk.me.uohiro.protobuf.model.extras.ex2.WindServiceGrpc.WindServiceBlockingStub;

public class WeatherServerWithSyncStubDependencies {

	private static final Logger logger = Logger.getLogger(WeatherServerWithSyncStubDependencies.class.getName());

	private final String host;
	private final int port;
	private final Server server;

	private final ManagedChannel temperatureServiceChannel;
	private final ManagedChannel humidityServiceChannel;
	private final ManagedChannel windServiceChannel;

	private final TemperatureServiceBlockingStub temperatureServiceBlockingStub;
	private final HumidityServiceBlockingStub humidityServiceBlockingStub;
	private final WindServiceBlockingStub windServiceBlockingStub;

	public WeatherServerWithSyncStubDependencies(String host, int port) throws IOException {
		this(NettyServerBuilder.forPort(port), host, port);
	}

	public WeatherServerWithSyncStubDependencies(ServerBuilder<?> serverBuilder, String host, int port) {
		this.host = host;
		this.port = port;
		
		temperatureServiceChannel = NettyChannelBuilder.forAddress(host, 8101).usePlaintext().build();
		humidityServiceChannel = NettyChannelBuilder.forAddress(host, 8102).usePlaintext().build();
		windServiceChannel = NettyChannelBuilder.forAddress(host, 8103).usePlaintext().build();

		temperatureServiceBlockingStub = TemperatureServiceGrpc.newBlockingStub(temperatureServiceChannel);
		humidityServiceBlockingStub = HumidityServiceGrpc.newBlockingStub(humidityServiceChannel);
		windServiceBlockingStub = WindServiceGrpc.newBlockingStub(windServiceChannel);

		WeatherService weatherServce = new WeatherService(
				temperatureServiceBlockingStub,
				humidityServiceBlockingStub,
				windServiceBlockingStub);
		
		this.server = serverBuilder.addService(weatherServce).build();
	}

	public void start() throws IOException {
		server.start();
		logger.info("Server started, listening on " + port);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("*** Shutting down gRPC server since JVM is shutting down.");
				try {
					WeatherServerWithSyncStubDependencies.this.stop();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.err.println("*** Server shut down.");
			}
		});
	}

	public void stop() throws InterruptedException {
		if (server != null) {
			temperatureServiceChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
			humidityServiceChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
			windServiceChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
			server.shutdown();
		}
	}

	private void blockUntilShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}

	public static void main(String[] args) throws Exception {
		WeatherServerWithSyncStubDependencies server = new WeatherServerWithSyncStubDependencies("localhost", 8080);
		server.start();
		server.blockUntilShutdown();
	}
	
	class WeatherService extends WeatherImplBase {
		private final TemperatureServiceBlockingStub temperatureServiceBlockingStub;
		private final HumidityServiceBlockingStub humidityServiceBlockingStub;
		private final WindServiceBlockingStub windServiceBlockingStub;
		
		public WeatherService(TemperatureServiceBlockingStub temperatureServiceBlockingStub,
				HumidityServiceBlockingStub humidityServiceBlockingStub,
				WindServiceBlockingStub windServiceBlockingStub) {
			this.temperatureServiceBlockingStub = temperatureServiceBlockingStub;
			this.humidityServiceBlockingStub = humidityServiceBlockingStub;
			this.windServiceBlockingStub = windServiceBlockingStub;
		}
		
		@Override
		public void getCurrent(WeatherRequest request, StreamObserver<WeatherResponse> responseObserver) {
			Temperature temperature = temperatureServiceBlockingStub.getCurrent(request.getCoordinates());
			HumidityResponse humidity = humidityServiceBlockingStub.getCurrent(request.getCoordinates());
			Wind wind = windServiceBlockingStub.getCurrent(request.getCoordinates());
			
			WeatherResponse response = WeatherResponse.newBuilder()
					.setTemperature(temperature)
					.setHumidity(humidity.getHumidity())
					.setWind(wind)
					.build();
			
			responseObserver.onNext(response);	
			responseObserver.onCompleted();
		}
	}
}
