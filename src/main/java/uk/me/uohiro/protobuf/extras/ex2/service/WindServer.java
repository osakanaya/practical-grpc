package uk.me.uohiro.protobuf.extras.ex2.service;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.extras.ex2.Coordinates;
import uk.me.uohiro.protobuf.model.extras.ex2.Speed;
import uk.me.uohiro.protobuf.model.extras.ex2.Speed.Units;
import uk.me.uohiro.protobuf.model.extras.ex2.Wind;
import uk.me.uohiro.protobuf.model.extras.ex2.WindServiceGrpc.WindServiceImplBase;

public class WindServer {
	private static final Logger logger = Logger.getLogger(WindServer.class.getName());

	private final int port;
	private final Server server;

	public WindServer(int port) throws IOException {
		this(NettyServerBuilder.forPort(port), port);
	}

	public WindServer(ServerBuilder<?> serverBuilder, int port) {
		this.port = port;
		this.server = serverBuilder.addService(new WindService()).build();
	}

	public void start() throws IOException {
		server.start();
		logger.info("Server started, listening on " + port);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("*** Shutting down gRPC server since JVM is shutting down.");
				WindServer.this.stop();
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
		WindServer server = new WindServer(8103);
		server.start();
		server.blockUntilShutdown();
	}
	
	class WindService extends WindServiceImplBase {
		public WindService() {
		}
		
		@Override
		public void getCurrent(Coordinates request, StreamObserver<Wind> responseObserver) {
			Wind response = Wind.newBuilder().setDirection(0.6f)
					.setSpeed(Speed.newBuilder().setValue(12.3f).setUnits(Units.MPH)).build();
			
			responseObserver.onNext(response);	
			responseObserver.onCompleted();
		}
	}	
}
