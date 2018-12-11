package uk.me.uohiro.protobuf.extras.ex3.client;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.ClientCallStreamObserver;
import io.grpc.stub.ClientResponseObserver;
import uk.me.uohiro.protobuf.model.extras.ex3.HelloRequest;
import uk.me.uohiro.protobuf.model.extras.ex3.HelloResponse;
import uk.me.uohiro.protobuf.model.extras.ex3.StreamingGreeterGrpc;
import uk.me.uohiro.protobuf.model.extras.ex3.StreamingGreeterGrpc.StreamingGreeterStub;

public class ManualControlFlowClient {
	private static final Logger logger = Logger.getLogger(ManualControlFlowClient.class.getName());

	public static void main(String[] args) throws Exception {
		final CountDownLatch done = new CountDownLatch(1);

		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();

		StreamingGreeterStub stub = StreamingGreeterGrpc.newStub(channel);

		ClientResponseObserver<HelloRequest, HelloResponse> clientResponseObserver = new ClientResponseObserver<HelloRequest, HelloResponse>() {

			ClientCallStreamObserver<HelloRequest> requestStream;

			@Override
			public void beforeStart(ClientCallStreamObserver<HelloRequest> requestStream) {
				this.requestStream = requestStream;

				requestStream.disableAutoInboundFlowControl();

				requestStream.setOnReadyHandler(new Runnable() {
					Iterator<String> iterator = names().iterator();
					@Override
					public void run() {
						while (requestStream.isReady()) {
							if (iterator.hasNext()) {
								String name = iterator.next();
								logger.info("--> " + name);
								
								HelloRequest requets = HelloRequest.newBuilder().setName(name).build();
								requestStream.onNext(requets);
							} else {
								requestStream.onCompleted();
							}
						}
					}
				});
			}

			@Override
			public void onCompleted() {
				logger.info("ALL DONE");
				done.countDown();
			}

			@Override
			public void onError(Throwable t) {
				logger.warning("ERROR");
				t.printStackTrace();
				done.countDown();
			}

			@Override
			public void onNext(HelloResponse response) {
				logger.info("<-- " + response.getMessage());
				requestStream.request(1);
			}

		};
		
		stub.sayHelloStreaming(clientResponseObserver);
		
		done.await();
		
		channel.shutdown();
		channel.awaitTermination(1, TimeUnit.SECONDS);
	}

	private static List<String> names() {
		return Arrays.asList("Sophia", "Jackson", "Emma", "Aiden", "Olivia", "Lucas", "Ava", "Liam", "Mia", "Noah",
				"Isabella", "Ethan", "Riley", "Mason", "Aria", "Caden", "Zoe", "Oliver", "Charlotte", "Elijah", "Lily",
				"Grayson", "Layla", "Jacob", "Amelia", "Michael", "Emily", "Benjamin", "Madelyn", "Carter", "Aubrey",
				"James", "Adalyn", "Jayden", "Madison", "Logan", "Chloe", "Alexander", "Harper", "Caleb", "Abigail",
				"Ryan", "Aaliyah", "Luke", "Avery", "Daniel", "Evelyn", "Jack", "Kaylee", "William", "Ella", "Owen",
				"Ellie", "Gabriel", "Scarlett", "Matthew", "Arianna", "Connor", "Hailey", "Jayce", "Nora", "Isaac",
				"Addison", "Sebastian", "Brooklyn", "Henry", "Hannah", "Muhammad", "Mila", "Cameron", "Leah", "Wyatt",
				"Elizabeth", "Dylan", "Sarah", "Nathan", "Eliana", "Nicholas", "Mackenzie", "Julian", "Peyton", "Eli",
				"Maria", "Levi", "Grace", "Isaiah", "Adeline", "Landon", "Elena", "David", "Anna", "Christian",
				"Victoria", "Andrew", "Camilla", "Brayden", "Lillian", "John", "Natalie", "Lincoln");
	}
}
