package uk.me.uohiro.protobuf.ch10.ex2.client;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;

import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import uk.me.uohiro.protobuf.model.ch10.ex2.BoxingRequest;
import uk.me.uohiro.protobuf.model.ch10.ex2.BoxingResponse;
import uk.me.uohiro.protobuf.model.ch10.ex2.BoxingServiceGrpc;
import uk.me.uohiro.protobuf.model.ch10.ex2.BoxingServiceGrpc.BoxingServiceBlockingStub;

public class BoxingClient {
	private static final Logger logger = Logger.getLogger(BoxingClient.class.getName());

	private final ManagedChannel channel;
	
	private final BoxingServiceBlockingStub blockingStub;
	
	public BoxingClient(String host, int port) {
		channel = NettyChannelBuilder.forAddress(host, port).usePlaintext().build();
		blockingStub = BoxingServiceGrpc.newBlockingStub(channel);
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public void getBoxedResponse() throws Exception {
		BoxingRequest request = BoxingRequest.newBuilder()
				.setStringValue1(StringValue.newBuilder().setValue("value1"))
				.setInt32Value1(Int32Value.newBuilder().setValue(100)).build();
		
		BoxingResponse response = blockingStub.processRequest(request);
		
		if (response.hasStringValue1()) {
			logger.info("string_value1 is not empty: " + response.getStringValue1().getValue());
		} else {
			logger.info("string_value1 is empty");
		}

		if (response.hasStringValue2()) {
			logger.info("string_value2 is not empty: " + response.getStringValue2().getValue());
		} else {
			logger.info("string_value2 is empty");
		}

		if (response.hasInt32Value1()) {
			logger.info("int32_value1 is not empty: " + response.getInt32Value1().getValue());
		} else {
			logger.info("int32_value1 is empty");
		}

		if (response.hasInt32Value2()) {
			logger.info("int32_value2 is not empty: " + response.getInt32Value2().getValue());
		} else {
			logger.info("int32_value2 is empty");
		}
	}
	
	public static void main(String[] args) throws Exception {

		BoxingClient client = new BoxingClient("localhost", 8080);
		
		try {
			client.getBoxedResponse();
		} finally {
			client.shutdown();
		}
	}
}
