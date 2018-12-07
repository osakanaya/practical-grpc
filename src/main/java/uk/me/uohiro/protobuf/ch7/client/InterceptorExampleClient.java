package uk.me.uohiro.protobuf.ch7.client;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.Channel;
import io.grpc.ClientInterceptors;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import uk.me.uohiro.protobuf.ch7.interceptor.ExampleClientInterceptor;
import uk.me.uohiro.protobuf.model.ch7.ex2.Empty;
import uk.me.uohiro.protobuf.model.ch7.ex2.GetDataRequest;
import uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse;
import uk.me.uohiro.protobuf.model.ch7.ex2.InterceptorExampleGrpc;
import uk.me.uohiro.protobuf.model.ch7.ex2.InterceptorExampleGrpc.InterceptorExampleBlockingStub;

public class InterceptorExampleClient {
	private static final Logger logger = Logger.getLogger(InterceptorExampleClient.class.getName());

	private final ManagedChannel originChannel;
	private final InterceptorExampleBlockingStub blockingStub;

	public InterceptorExampleClient(String host, int port) {
		this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
	}

	public InterceptorExampleClient(ManagedChannelBuilder<?> channelBuilder) {
		originChannel = channelBuilder.build();
		ExampleClientInterceptor interceptor = new ExampleClientInterceptor();
		Channel channel = ClientInterceptors.intercept(originChannel, interceptor);
		blockingStub = InterceptorExampleGrpc.newBlockingStub(channel);
	}

	public void shutdown() throws InterruptedException {
		originChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public void getData(String id) {
		info("*** GetData: id={0}", id);

		try {
			GetDataRequest request = GetDataRequest.newBuilder().setId(id).build();
			GetDataResponse response = blockingStub.getData(request);
			info("Data: {0}", response.getData());
		} catch (StatusRuntimeException e) {
			warning("[error][status]: {0}", e.getStatus().getCode());
			warning("[error][description]: {0}", e.getStatus().getDescription());
		}
	}
	
	public void getStreamData() {
		info("*** GetStreamData");

		Empty request = Empty.newBuilder().build();
		
		Iterator<GetDataResponse> responses = blockingStub.getStreamData(request);

		for(int i = 1; responses.hasNext(); i++) {
			GetDataResponse response = responses.next();
			info("Result #" + i + ": {0}", response.getData());
		}
	}
	
	public static void main(String[] args) throws Exception {

		InterceptorExampleClient client = new InterceptorExampleClient("localhost", 8080);
		
		try {
			client.getData("1");
			client.getData("2");
			client.getData("3");
			
			client.getStreamData();
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
