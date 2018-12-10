package uk.me.uohiro.protobuf.extras.ex2.service;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.extras.ex2.Coordinates;
import uk.me.uohiro.protobuf.model.extras.ex2.HumidityResponse;
import uk.me.uohiro.protobuf.model.extras.ex2.HumidityServiceGrpc.HumidityServiceImplBase;

public class HumidityServer {
	private static final Logger logger = Logger.getLogger(HumidityServer.class.getName());

	private final int port;
	private final Server server;

	public HumidityServer(int port) throws IOException {
		this(NettyServerBuilder.forPort(port), port);
	}

	public HumidityServer(ServerBuilder<?> serverBuilder, int port) {
		this.port = port;
		this.server = serverBuilder.addService(new HumidityService()).build();
	}

	public void start() throws IOException {
		server.start();
		logger.info("Server started, listening on " + port);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("*** Shutting down gRPC server since JVM is shutting down.");
				HumidityServer.this.stop();
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
		HumidityServer server = new HumidityServer(8102);
		server.start();
		server.blockUntilShutdown();
	}
	
	class HumidityService extends HumidityServiceImplBase {
		public HumidityService() {
		}
		
		@Override
		public void getCurrent(Coordinates request, StreamObserver<HumidityResponse> responseObserver) {
			HumidityResponse response = HumidityResponse.newBuilder().setHumidity(.65f).build();
			
			responseObserver.onNext(response);	
			responseObserver.onCompleted();
		}
	}	
}
