package uk.me.uohiro.protobuf.extras.ex2.service;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.extras.ex2.Coordinates;
import uk.me.uohiro.protobuf.model.extras.ex2.Temperature;
import uk.me.uohiro.protobuf.model.extras.ex2.Temperature.Units;
import uk.me.uohiro.protobuf.model.extras.ex2.TemperatureServiceGrpc.TemperatureServiceImplBase;

public class TemperatureServer {
	private static final Logger logger = Logger.getLogger(TemperatureServer.class.getName());

	private final int port;
	private final Server server;

	public TemperatureServer(int port) throws IOException {
		this(NettyServerBuilder.forPort(port), port);
	}

	public TemperatureServer(ServerBuilder<?> serverBuilder, int port) {
		this.port = port;
		this.server = serverBuilder.addService(new TemperatureService()).build();
	}

	public void start() throws IOException {
		server.start();
		logger.info("Server started, listening on " + port);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("*** Shutting down gRPC server since JVM is shutting down.");
				TemperatureServer.this.stop();
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
		TemperatureServer server = new TemperatureServer(8101);
		server.start();
		server.blockUntilShutdown();
	}
	
	class TemperatureService extends TemperatureServiceImplBase {
		public TemperatureService() {
		}
		
		@Override
		public void getCurrent(Coordinates request, StreamObserver<Temperature> responseObserver) {
			Temperature response = Temperature.newBuilder().setDegrees(70).setUnits(Units.FAHRENHEIT).build();
			
			responseObserver.onNext(response);	
			responseObserver.onCompleted();
		}
	}	
}
