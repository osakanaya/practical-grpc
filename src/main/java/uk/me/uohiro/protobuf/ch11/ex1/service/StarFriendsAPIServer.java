package uk.me.uohiro.protobuf.ch11.ex1.service;

import java.io.IOException;
import java.util.Collection;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerInterceptors;
import uk.me.uohiro.protobuf.ch4.interceptors.HeaderServerInterceptor;
import uk.me.uohiro.protobuf.model.ch11.ex1.Film;

public class StarFriendsAPIServer {
	private static final Logger logger = Logger.getLogger(StarFriendsAPIService.class.getName());
	
	private final int port;
	private final Server server;
	
	public StarFriendsAPIServer(int port) throws Exception {
		this(port, StarFriendsAPIUtil.getDefaultFilms());
	}
	
	public StarFriendsAPIServer(int port, Collection<Film> films) throws IOException {
		this(ServerBuilder.forPort(port), port, films);
	}
	
	public StarFriendsAPIServer(ServerBuilder<?> serverBuilder, int port, Collection<Film> films) {
		this.port = port;
		this.server = serverBuilder.addService(
			ServerInterceptors.intercept(new StarFriendsAPIService(films), 
					new HeaderServerInterceptor())).build();
	}

	public void start() throws IOException {
		server.start();
		logger.info("Server started, listening on " + port);
		
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run() {
				System.err.println("*** Shutting down gRPC server since JVM is shutting down.");
				StarFriendsAPIServer.this.stop();
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
		StarFriendsAPIServer server = new StarFriendsAPIServer(8080);
		server.start();
		server.blockUntilShutdown();
	}
}
