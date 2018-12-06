package uk.me.uohiro.protobuf.ch7.interceptor;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.ForwardingServerCall;
import io.grpc.ForwardingServerCallListener.SimpleForwardingServerCallListener;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse;

public class ExampleServerInterceptor implements ServerInterceptor {
	private static final Logger logger = Logger.getLogger(ExampleServerInterceptor.class.getName());

	private final Set<Class<? extends Throwable>> autowrapThrowables = new HashSet<>();
	
	private long startTime;
	
	public ExampleServerInterceptor(Collection<Class<? extends Throwable>> autowrapThrowables) {
		this.autowrapThrowables.addAll(autowrapThrowables);
	}
	
	/*
	 * Message: onReady->onMessage->(execute)->onHalfClose->sendMessage->close->onComplete
	 */
	
	@Override
	public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call,
			final Metadata requestHeaders, ServerCallHandler<ReqT, RespT> next) {

		ServerCall<ReqT, RespT> wrappedCall = new ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT>(call) {
			@SuppressWarnings("unchecked")
			@Override
			public void sendMessage(RespT message) {
				long endTime = new Date().getTime();

				logger.info("sendMessage called.");
				logger.log(Level.INFO, "response [message]: {0}", message.toString());
				logger.log(Level.INFO, "response [duration]: {0} ms", (endTime - startTime));
				
				// レスポンスを変換する（わざと）
				if (message.getClass().getName().equals("uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse")) {
					GetDataResponse temp = (GetDataResponse)message;
					message = (RespT)GetDataResponse.newBuilder().mergeFrom(temp).setData(temp.getData().toUpperCase()).build();
				}
				
				super.sendMessage(message);
			}

			@Override
			public void close(Status status, Metadata trailers) {
				logger.info("close called.");

				if (status.getCause() != null) {
					logger.log(Level.WARNING, "status [cause][class]: {0}", status.getCause().getClass().getName());
					logger.log(Level.WARNING, "status [cause][message]: {0}", status.getCause().getMessage());
				}
				
				if (status.getCode() == Status.Code.UNKNOWN
						&& status.getDescription() == null
						&& status.getCause() != null
						&& autowrapThrowables.contains(status.getCause().getClass())) {
					Throwable t = status.getCause();
					status = Status.INTERNAL
							.withDescription(t.getMessage())
							.augmentDescription(stacktraceToString(t));
				}
				
				super.close(status, trailers);
			}
		};
		
		final ServerCall.Listener<ReqT> original = next.startCall(wrappedCall, requestHeaders);
		
		return new SimpleForwardingServerCallListener<ReqT>(original) {
			@Override
			public void onMessage(ReqT message) {
				startTime = new Date().getTime();
				
				logger.info("onMessage called.");
				
				logger.log(Level.INFO, "request [method name]: {0}", call.getMethodDescriptor().getFullMethodName());
				logger.log(Level.INFO, "request [message]: {0}", message.toString());

				super.onMessage(message);
			}

			@Override
			public void onCancel() {
				logger.info("onCancel called.");
				super.onCancel();
			}

			@Override
			public void onComplete() {
				logger.info("onComplete called.");
				super.onComplete();
			}

			@Override
			public void onHalfClose() {
				logger.info("onHalfClose called.");
				super.onHalfClose();
			}

			@Override
			public void onReady() {
				logger.info("onReady called.");
				super.onReady();
			}
		};
	}
	
	private String stacktraceToString(Throwable t) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		t.printStackTrace(printWriter);
		
		return stringWriter.toString();
	}
}
