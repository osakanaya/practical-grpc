package uk.me.uohiro.protobuf.extras.ex3.service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;

import io.grpc.ManagedChannel;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.extras.ex3.Coordinates;
import uk.me.uohiro.protobuf.model.extras.ex3.HumidityServiceStreamingGrpc;
import uk.me.uohiro.protobuf.model.extras.ex3.HumidityServiceStreamingGrpc.HumidityServiceStreamingStub;
import uk.me.uohiro.protobuf.model.extras.ex3.TemperatureServiceStreamingGrpc;
import uk.me.uohiro.protobuf.model.extras.ex3.TemperatureServiceStreamingGrpc.TemperatureServiceStreamingStub;
import uk.me.uohiro.protobuf.model.extras.ex3.WeatherRequest;
import uk.me.uohiro.protobuf.model.extras.ex3.WeatherResponse;
import uk.me.uohiro.protobuf.model.extras.ex3.WeatherStreamingGrpc.WeatherStreamingImplBase;
import uk.me.uohiro.protobuf.model.extras.ex3.WindServiceStreamingGrpc;
import uk.me.uohiro.protobuf.model.extras.ex3.WindServiceStreamingGrpc.WindServiceStreamingStub;

public class WeatherStreamingServer {

	private static final Logger logger = Logger.getLogger(WeatherStreamingServer.class.getName());

	private final String host;
	private final int port;
	private final Server server;

	private final ManagedChannel temperatureServiceChannel;
	private final ManagedChannel humidityServiceChannel;
	private final ManagedChannel windServiceChannel;

	private final TemperatureServiceStreamingStub temperatureServiceStreamingStub;
	private final HumidityServiceStreamingStub humidityServiceStreamingStub;
	private final WindServiceStreamingStub windServiceStreamingStub;

	public WeatherStreamingServer(String host, int port) throws IOException {
		this(NettyServerBuilder.forPort(port), host, port);
	}

	public WeatherStreamingServer(ServerBuilder<?> serverBuilder, String host, int port) {
		this.host = host;
		this.port = port;
		
		temperatureServiceChannel = NettyChannelBuilder.forAddress(host, 8101).usePlaintext().build();
		humidityServiceChannel = NettyChannelBuilder.forAddress(host, 8102).usePlaintext().build();
		windServiceChannel = NettyChannelBuilder.forAddress(host, 8103).usePlaintext().build();

		temperatureServiceStreamingStub = TemperatureServiceStreamingGrpc.newStub(temperatureServiceChannel);
		humidityServiceStreamingStub = HumidityServiceStreamingGrpc.newStub(humidityServiceChannel);
		windServiceStreamingStub = WindServiceStreamingGrpc.newStub(windServiceChannel);

		WeatherService weatherServce = new WeatherService(
				temperatureServiceStreamingStub,
				humidityServiceStreamingStub,
				windServiceStreamingStub);
		
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
					WeatherStreamingServer.this.stop();
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
		WeatherStreamingServer server = new WeatherStreamingServer("localhost", 8080);
		server.start();
		server.blockUntilShutdown();
	}
	
	class WeatherStreamingService extends WeatherStreamingImplBase {
		private final TemperatureServiceStreamingStub temperatureServiceStreamingStub;
		private final HumidityServiceStreamingStub humidityServiceStreamingStub;
		private final WindServiceStreamingStub windServiceStreamingStub;
		
		public WeatherStreamingService(TemperatureServiceStreamingStub temperatureServiceStreamingStub,
				HumidityServiceStreamingStub humidityServiceStreamingStub,
				WindServiceStreamingStub windServiceStreamingStub) {
			this.temperatureServiceStreamingStub = temperatureServiceStreamingStub;
			this.humidityServiceStreamingStub = humidityServiceStreamingStub;
			this.windServiceStreamingStub = windServiceStreamingStub;
		}
		
		@Override
		public StreamObserver<WeatherRequest> observe(StreamObserver<WeatherResponse> responseObserver) {
			StreamObserver<Coordinates> temperatureClientStream = 
					temperatureServiceStreamingStub.observe(
					})
			
			
			return null;
		}
	
		// p.95
		private <T> StreamObserver<T> newStreamObserver(StreamObserver<V>)

		@Override
		public void getCurrent(WeatherRequest request, StreamObserver<WeatherResponse> responseObserver) {
			Coordinates coordinates = request.getCoordinates();
			Builder responseBuilder = WeatherResponse.newBuilder();

			ListenableFuture<List<Builder>> responsesFuture = Futures.allAsList(
					Futures.transform(
							temperatureServiceFutureStub.getCurrent(coordinates), 
							(Temperature response) -> {
								return responseBuilder.setTemperature(response);
							},
							MoreExecutors.directExecutor()),
					Futures.transform(
							humidityServiceFutureStub.getCurrent(coordinates),
							(HumidityResponse response) -> {
								return responseBuilder.setHumidity(response.getHumidity());
							},
							MoreExecutors.directExecutor()),
					Futures.transform(
							windServiceFutureStub.getCurrent(coordinates), 
							(Wind response) -> {
								return responseBuilder.setWind(response); 
							},
							MoreExecutors.directExecutor())
			);
			
			Futures.addCallback(responsesFuture, new FutureCallback<List<Builder>>() {
				@Override
				public void onFailure(Throwable t) {
					responseObserver.onError(t);
				}

				@Override
				public void onSuccess(@Nullable List<Builder> result) {
					responseObserver.onNext(responseBuilder.build());
					responseObserver.onCompleted();
				}
			}, MoreExecutors.directExecutor());
		}
	}
}
