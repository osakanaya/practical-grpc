package uk.me.uohiro.protobuf.ch10.ex3.client;

import java.util.concurrent.TimeUnit;

import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import com.google.protobuf.util.FieldMaskUtil;

import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskRequest;
import uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskRequest.NestedMessage;
import uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskResponse;
import uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskServiceGrpc;
import uk.me.uohiro.protobuf.model.ch10.ex3.FieldMaskServiceGrpc.FieldMaskServiceBlockingStub;

public class FieldMaskClient {
	private final ManagedChannel channel;
	
	private final FieldMaskServiceBlockingStub blockingStub;
	
	public FieldMaskClient(String host, int port) {
		channel = NettyChannelBuilder.forAddress(host, port).usePlaintext().build();
		blockingStub = FieldMaskServiceGrpc.newBlockingStub(channel);
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public void getFieldMaskResponse() throws Exception {
		FieldMaskRequest request = FieldMaskRequest.newBuilder()
				.setStringValue(StringValue.newBuilder().setValue("Value1"))
				.setInt32Value(Int32Value.newBuilder().setValue(100))
				.setNestedMessage(
						NestedMessage.newBuilder()
							.setStringValue(StringValue.newBuilder().setValue("NestedValue1"))
							.setInt32Value(Int32Value.newBuilder().setValue(200)))
				.setMask(FieldMaskUtil.fromString("int32_value,nested_message.string_value"))
				.build();
		
		@SuppressWarnings("unused")
		FieldMaskResponse response = blockingStub.processRequest(request);
	}
	
	public static void main(String[] args) throws Exception {

		FieldMaskClient client = new FieldMaskClient("localhost", 8080);
		
		try {
			client.getFieldMaskResponse();
		} finally {
			client.shutdown();
		}
	}
}
