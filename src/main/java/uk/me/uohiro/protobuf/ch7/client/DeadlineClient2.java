package uk.me.uohiro.protobuf.ch7.client;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineExampleGrpc;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineExampleGrpc.DeadlineExampleBlockingStub;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse;
import uk.me.uohiro.protobuf.model.ch7.ex4.Empty;

public class DeadlineClient2 {
	private static final Logger logger = Logger.getLogger(DeadlineClient2.class.getName());

	private final ManagedChannel channel;
	private final DeadlineExampleBlockingStub blockingStub;

	public DeadlineClient2(String host, int port) {
		this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
	}

	public DeadlineClient2(ManagedChannelBuilder<?> channelBuilder) {
		channel = channelBuilder.build();
		blockingStub = DeadlineExampleGrpc.newBlockingStub(channel);
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public void access() {
		Empty request = Empty.newBuilder().build();
		
		DeadlineResponse response = null;
		try {
			response = blockingStub.withDeadlineAfter(3000L, TimeUnit.MILLISECONDS).fast(request);
			info("Response: {0}", response.getMessage());
			
			response = blockingStub.withDeadlineAfter(3000L, TimeUnit.MILLISECONDS).slow(request);
			info("Response: {0}", response.getMessage());
		} catch (StatusRuntimeException e) {
			warning("RPC failed [code]: {0}", e.getStatus().getCode());
			warning("RPC failed [descrition]: {0}", e.getStatus().getDescription()); // Error description<cr>Augmented description]
		}		
	}

	public static void main(String[] args) throws Exception {

		DeadlineClient2 client = new DeadlineClient2("localhost", 8080);

		try {
			client.access();
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
