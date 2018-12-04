package uk.me.uohiro.protobuf.ch4.client;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.Channel;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import uk.me.uohiro.protobuf.ch4.interceptors.HeaderClientInterceptor;
import uk.me.uohiro.protobuf.model.ch4.GetFilmRequest;
import uk.me.uohiro.protobuf.model.ch4.GetFilmResponse;
import uk.me.uohiro.protobuf.model.ch4.ListFilmsRequest;
import uk.me.uohiro.protobuf.model.ch4.ListFilmsResponse;
import uk.me.uohiro.protobuf.model.ch4.StarFriendsGrpc;
import uk.me.uohiro.protobuf.model.ch4.StarFriendsGrpc.StarFriendsBlockingStub;

public class StarFriendsAPIClient {
	private static final Logger logger = Logger.getLogger(StarFriendsAPIClient.class.getName());

	private final ManagedChannel originChannel;
	private final StarFriendsBlockingStub blockingStub;

	public StarFriendsAPIClient(String host, int port) {
		this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
	}

	public StarFriendsAPIClient(ManagedChannelBuilder<?> channelBuilder) {
		originChannel = channelBuilder.build();
		ClientInterceptor interceptor = new HeaderClientInterceptor();
		Channel channel = ClientInterceptors.intercept(originChannel, interceptor);
		blockingStub = StarFriendsGrpc.newBlockingStub(channel);
	}

	public void shutdown() throws InterruptedException {
		originChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public void getFilm(String id) {
		info("*** GetFilm: id={0}", id);

		GetFilmRequest request = GetFilmRequest.newBuilder().setId(id).build();

		GetFilmResponse response;
		try {
			response = blockingStub.getFilm(request);

			System.out.println(response.getFilm());
		} catch (StatusRuntimeException e) {
			warning("RPC failed: {0}", e.getStatus());
		}
	}

	public void ListFilms() {
		info("*** ListFilms:");

		ListFilmsRequest request = ListFilmsRequest.newBuilder().build();

		ListFilmsResponse response;
		try {
			response = blockingStub.listFilms(request);

			System.out.println(response.getFilmsList());
		} catch (StatusRuntimeException e) {
			warning("RPC failed: {0}", e.getStatus());
		}
	}

	public static void main(String[] args) throws Exception {

		StarFriendsAPIClient client = new StarFriendsAPIClient("localhost", 8080);

		try {
			// Invoke GetFilm (Found)
			client.getFilm("4");

			// Invoke GetFilm (Not Found)
			client.getFilm("7");

			// Invoke ListFilms
			client.ListFilms();

		} finally {
			client.shutdown();
		}
	}

	private void info(String msg, Object... params) {
		logger.log(Level.INFO, msg, params);
	}

	private void warning(String msg, Object... params) {
		logger.log(Level.WARNING, msg, params);
	}
}
