package uk.me.uohiro.protobuf.extras.ex3.service;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.extras.ex3.Coordinates;
import uk.me.uohiro.protobuf.model.extras.ex3.HumidityResponse;
import uk.me.uohiro.protobuf.model.extras.ex3.HumidityServiceStreamingGrpc.HumidityServiceStreamingImplBase;

public class HumidityStreamingServer {
	private static final Logger logger = Logger.getLogger(HumidityStreamingServer.class.getName());

	private final int port;
	private final Server server;

	public HumidityStreamingServer(int port) throws IOException {
		this(NettyServerBuilder.forPort(port), port);
	}

	public HumidityStreamingServer(ServerBuilder<?> serverBuilder, int port) {
		this.port = port;
		this.server = serverBuilder.addService(new HumidityStreamingService()).build();
	}

	public void start() throws IOException {
		server.start();
		logger.info("Server started, listening on " + port);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("*** Shutting down gRPC server since JVM is shutting down.");
				HumidityStreamingServer.this.stop();
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
		HumidityStreamingServer server = new HumidityStreamingServer(8102);
		server.start();
		server.blockUntilShutdown();
	}
	
	class HumidityStreamingService extends HumidityServiceStreamingImplBase {
		public HumidityStreamingService() {
		}

		@Override
		public StreamObserver<Coordinates> observe(StreamObserver<HumidityResponse> responseObserver) {
			return new StreamObserver<Coordinates>() {
				@Override
				public void onCompleted() {
					responseObserver.onCompleted();
				}

				@Override
				public void onError(Throwable t) {
					logger.log(Level.WARNING, "observe cancelled");
				}

				@Override
				public void onNext(Coordinates coordinates) {
					HumidityResponse response = HumidityResponse.newBuilder().setHumidity(.65f).build();
					responseObserver.onNext(response);
				}
			};
		}
	}	
}
