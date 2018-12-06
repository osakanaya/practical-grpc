package uk.me.uohiro.protobuf.ch7.interceptor;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;

public class ExampleClientInterceptor implements ClientInterceptor {
	private static final Logger logger = Logger.getLogger(ExampleClientInterceptor.class.getName());

	/*
	 * request->sendMessage->halfClose->(server processing)->onReady->onHeaders->onMessage->onClose
	 */
	
	@Override
	public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method,
			CallOptions callOptions, Channel next) {
		
		return new SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
			private long startTime;
			
			// リクエスト送信時に呼ばれる
			@Override
			public void sendMessage(ReqT message) {
				startTime = new Date().getTime();
				
				logger.info("sendMessage called.");
				logger.log(Level.INFO, "request [method name]: {0}", method.getFullMethodName());
				logger.log(Level.INFO, "request [message]: {0}", message.toString());

				super.sendMessage(message);
			}

			@Override
			public void cancel(String message, Throwable cause) {
				logger.info("cancel called.");
				super.cancel(message, cause);
			}

			@Override
			public void halfClose() {
				logger.info("halfClose called.");
				super.halfClose();
			}

			@Override
			public void request(int numMessages) {
				logger.info("request called.");
				super.request(numMessages);
			}

			@Override
			public void setMessageCompression(boolean enabled) {
				logger.info("setMessageCompression called.");
				super.setMessageCompression(enabled);
			}

			@Override
			public void start(Listener<RespT> responseListener, Metadata headers) {
				super.start(new SimpleForwardingClientCallListener<RespT>(responseListener) {
					// レスポンス受信時に呼ばれる
					@Override
					public void onMessage(RespT message) {
						logger.info("onMessage called.");

						long endTime = new Date().getTime();
						logger.log(Level.INFO, "reponse [duration]: {0} ms", (endTime - startTime));
						logger.log(Level.INFO, "response [method name]: {0}", method.getFullMethodName());
						logger.log(Level.INFO, "response [message]: {0}", message.toString());

						super.onMessage(message);
					}

					@Override
					public void onClose(Status status, Metadata trailers) {
						logger.info("onClose called.");
						super.onClose(status, trailers);
					}

					@Override
					public void onHeaders(Metadata headers) {
						logger.info("onHeaders called.");
						super.onHeaders(headers);
					}

					@Override
					public void onReady() {
						logger.info("onReady called.");
						super.onReady();
					}
				}, headers);

			}
		};
	}
}
