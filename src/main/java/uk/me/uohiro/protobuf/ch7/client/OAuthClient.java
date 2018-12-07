package uk.me.uohiro.protobuf.ch7.client;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.Channel;
import io.grpc.ClientInterceptors;
import io.grpc.Context;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import uk.me.uohiro.protobuf.ch7.interceptor.JWTClientInterceptor;
import uk.me.uohiro.protobuf.ch7.interceptor.JWTConstants;
import uk.me.uohiro.protobuf.model.ch7.ex3.Empty;
import uk.me.uohiro.protobuf.model.ch7.ex3.Greeting;
import uk.me.uohiro.protobuf.model.ch7.ex3.ProtectedResourceGrpc;
import uk.me.uohiro.protobuf.model.ch7.ex3.ProtectedResourceGrpc.ProtectedResourceBlockingStub;

public class OAuthClient {
	private static final Logger logger = Logger.getLogger(InterceptorExampleClient.class.getName());

	private final ManagedChannel originChannel;
	private final ProtectedResourceBlockingStub blockingStub;

	public OAuthClient(String host, int port) {
		this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
	}

	public OAuthClient(ManagedChannelBuilder<?> channelBuilder) {
		originChannel = channelBuilder.build();
		JWTClientInterceptor interceptor = new JWTClientInterceptor();
		Channel channel = ClientInterceptors.intercept(originChannel, interceptor);
		blockingStub = ProtectedResourceGrpc.newBlockingStub(channel);
	}

	public void shutdown() throws InterruptedException {
		originChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public void sayHello() throws Exception {
		info("*** SayHello ***");

		try {
			Context.current().withValue(JWTConstants.AUTHORIZATION_CTX_KEY, "Bearer " + JWTUtil.createJWTToken()).run(() -> {
				Empty request = Empty.newBuilder().build();
				Greeting response = blockingStub.sayHello(request);

				info("Greeting: {0}", response.getGreeting());
			});
			
		} catch (StatusRuntimeException e) {
			warning("[error][status]: {0}", e.getStatus().getCode());
			warning("[error][description]: {0}", e.getStatus().getDescription());
		}
	}
	
	public static void main(String[] args) throws Exception {

		OAuthClient client = new OAuthClient("localhost", 8080);
		
		try {
			client.sayHello();
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
