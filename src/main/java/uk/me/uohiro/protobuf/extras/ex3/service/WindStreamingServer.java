package uk.me.uohiro.protobuf.extras.ex3.service;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.extras.ex3.Coordinates;
import uk.me.uohiro.protobuf.model.extras.ex3.Speed;
import uk.me.uohiro.protobuf.model.extras.ex3.Speed.Units;
import uk.me.uohiro.protobuf.model.extras.ex3.Wind;
import uk.me.uohiro.protobuf.model.extras.ex3.WindServiceStreamingGrpc.WindServiceStreamingImplBase;

public class WindStreamingServer {
	private static final Logger logger = Logger.getLogger(WindStreamingServer.class.getName());

	private final int port;
	private final Server server;

	public WindStreamingServer(int port) throws IOException {
		this(NettyServerBuilder.forPort(port), port);
	}

	public WindStreamingServer(ServerBuilder<?> serverBuilder, int port) {
		this.port = port;
		this.server = serverBuilder.addService(new WindStreamingService()).build();
	}

	public void start() throws IOException {
		server.start();
		logger.info("Server started, listening on " + port);

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("*** Shutting down gRPC server since JVM is shutting down.");
				WindStreamingServer.this.stop();
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
		WindStreamingServer server = new WindStreamingServer(8103);
		server.start();
		server.blockUntilShutdown();
	}
	
	class WindStreamingService extends WindServiceStreamingImplBase {
		public WindStreamingService() {
		}
		
		@Override
		public StreamObserver<Coordinates> observe(StreamObserver<Wind> responseObserver) {
			return new StreamObserver<Coordinates>() {
				@Override
				public void onNext(Coordinates coordinates) {
					Wind response = Wind.newBuilder().setDirection(0.6f)
							.setSpeed(Speed.newBuilder().setValue(12.3f).setUnits(Units.MPH)).build();
					
					responseObserver.onNext(response);	
				}
				
				@Override
				public void onError(Throwable t) {
					logger.log(Level.WARNING, "observe cancelled");
				}
				
				@Override
				public void onCompleted() {
					responseObserver.onCompleted();
				}
			};
		}
	}	
}
