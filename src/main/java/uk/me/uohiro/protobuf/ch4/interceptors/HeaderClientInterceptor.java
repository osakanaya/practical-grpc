package uk.me.uohiro.protobuf.ch4.interceptors;

import java.util.logging.Logger;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;

public class HeaderClientInterceptor implements ClientInterceptor {
	private static final Logger logger = Logger.getLogger(HeaderClientInterceptor.class.getName());
	
	static final Metadata.Key<String> CLIENT_CUSTOM_HEADER_KEY = Metadata.Key.of("who",
			Metadata.ASCII_STRING_MARSHALLER);

	static final Metadata.Key<String> SERVER_CUSTOM_HEADER_KEY1 = Metadata.Key.of("who",
			Metadata.ASCII_STRING_MARSHALLER);

	static final Metadata.Key<String> SERVER_CUSTOM_HEADER_KEY2 = Metadata.Key.of("version",
			Metadata.ASCII_STRING_MARSHALLER);

	  @Override
	  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method,
	      CallOptions callOptions, Channel next) {
	    return new SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {

	      @Override
	      public void start(Listener<RespT> responseListener, Metadata headers) {
	        headers.put(CLIENT_CUSTOM_HEADER_KEY, "starfriends-java-client");
	        super.start(new SimpleForwardingClientCallListener<RespT>(responseListener) {
	          @Override
	          public void onHeaders(Metadata headers) {
	            logger.info("header received from server [who]:" + headers.get(SERVER_CUSTOM_HEADER_KEY1));
	            logger.info("header received from server [version]:" + headers.get(SERVER_CUSTOM_HEADER_KEY2));
	            super.onHeaders(headers);
	          }
	        }, headers);
	      }
	    };
	}
}
