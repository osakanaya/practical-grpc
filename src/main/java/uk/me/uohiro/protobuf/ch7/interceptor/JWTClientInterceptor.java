package uk.me.uohiro.protobuf.ch7.interceptor;

import java.util.logging.Logger;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;

public class JWTClientInterceptor implements ClientInterceptor {
	private static final Logger logger = Logger.getLogger(JWTClientInterceptor.class.getName());

	@Override
	public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor,
			CallOptions callOptions, Channel channel) {
		return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(
				channel.newCall(methodDescriptor, callOptions)) {
			@Override
			public void start(Listener<RespT> responseListener, Metadata headers) {
				logger.info("ClientInterceptor: [access token]" + JWTConstants.AUTHORIZATION_CTX_KEY.get());

				// コンテキストからJWTトークンを取り出し、メタデータに設定する
				headers.put(JWTConstants.AUTHORIZATION_METADATA_KEY, JWTConstants.AUTHORIZATION_CTX_KEY.get());
				super.start(responseListener, headers);
			}
		};
	}
}
