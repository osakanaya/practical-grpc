package uk.me.uohiro.protobuf.ch10.ex1.client;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import uk.me.uohiro.protobuf.model.ch10.ex1.v2.GreetingServiceGrpc;
import uk.me.uohiro.protobuf.model.ch10.ex1.v2.GreetingServiceGrpc.GreetingServiceBlockingStub;
import uk.me.uohiro.protobuf.model.ch10.ex1.v2.HelloRequest;
import uk.me.uohiro.protobuf.model.ch10.ex1.v2.HelloResponse;
import uk.me.uohiro.protobuf.model.ch10.ex1.v2.Name;

public class Version2Client {
	private static final Logger logger = Logger.getLogger(Version2Client.class.getName());

	private final ManagedChannel channelv1;
	private final ManagedChannel channelv2;
	
	private final GreetingServiceBlockingStub blockingStubv1;
	private final GreetingServiceBlockingStub blockingStubv2;
	
	public Version2Client(String host, int portv1, int portv2) {
		channelv1 = NettyChannelBuilder.forAddress(host, portv1).usePlaintext().build();
		channelv2 = NettyChannelBuilder.forAddress(host, portv2).usePlaintext().build();
		
		blockingStubv1 = GreetingServiceGrpc.newBlockingStub(channelv1);
		blockingStubv2 = GreetingServiceGrpc.newBlockingStub(channelv2);
	}

	public void shutdown() throws InterruptedException {
		channelv1.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		channelv2.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public void getReplyV1() throws Exception {
		info("*** Request to V1 server ***");

		HelloRequest request = HelloRequest.newBuilder()
				.setEnglishGreeting("Hello")
				.setJapaneseGreeting("こんにちは")
				.setName(Name.newBuilder().setFirstName("Hideo").setLastName("Sashida")).build();
		
		HelloResponse response = blockingStubv1.sayHello(request);
		info("Response from V1 server: " + response.getEnglishReply());
		info("Response from V1 server: " + response.getJapaneseReply());
	}
	
	public void getReplyV2() throws Exception {
		info("*** Request to V2 server ***");

		HelloRequest request = HelloRequest.newBuilder()
				.setEnglishGreeting("Hello")
				.setJapaneseGreeting("こんにちは")
				.setName(Name.newBuilder().setFirstName("Hideo").setLastName("Sashida")).build();

		HelloResponse response = blockingStubv2.sayHello(request);
		info("Response from V2 server: " + response.getEnglishReply());
		info("Response from V2 server: " + response.getJapaneseReply());
	}
	
	public static void main(String[] args) throws Exception {

		Version2Client client = new Version2Client("localhost", 8101, 8102);
		
		try {
			client.getReplyV1();
			client.getReplyV2();
		} finally {
			client.shutdown();
		}
	}

	private void info(String msg, Object... params) {
		logger.log(Level.INFO, msg, params);
	}
}
