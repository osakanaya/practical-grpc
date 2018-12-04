package uk.me.uohiro.protobuf.ch4.interceptors;

import java.util.logging.Logger;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.ForwardingServerCall.SimpleForwardingServerCall;

public class HeaderServerInterceptor implements ServerInterceptor {
	private static final Logger logger = Logger.getLogger(HeaderServerInterceptor.class.getName());

	static final Metadata.Key<String> CLIENT_CUSTOM_HEADER_KEY = Metadata.Key.of("who",
			Metadata.ASCII_STRING_MARSHALLER);

	static final Metadata.Key<String> SERVER_CUSTOM_HEADER_KEY1 = Metadata.Key.of("who",
			Metadata.ASCII_STRING_MARSHALLER);

	static final Metadata.Key<String> SERVER_CUSTOM_HEADER_KEY2 = Metadata.Key.of("version",
			Metadata.ASCII_STRING_MARSHALLER);

	@Override
	public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call,
			final Metadata requestHeaders, ServerCallHandler<ReqT, RespT> next) {

		logger.info("header received from client [who]:" + requestHeaders.get(CLIENT_CUSTOM_HEADER_KEY));

		return next.startCall(new SimpleForwardingServerCall<ReqT, RespT>(call) {
			@Override
			public void sendHeaders(Metadata responseHeaders) {
				responseHeaders.put(SERVER_CUSTOM_HEADER_KEY1, "starfriends-server");
				responseHeaders.put(SERVER_CUSTOM_HEADER_KEY2, "v1");
				super.sendHeaders(responseHeaders);
			}
		}, requestHeaders);
	}
}
