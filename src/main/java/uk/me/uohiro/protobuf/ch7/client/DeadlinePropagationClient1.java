package uk.me.uohiro.protobuf.ch7.client;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineMainGrpc;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineMainGrpc.DeadlineMainBlockingStub;
import uk.me.uohiro.protobuf.model.ch7.ex4.DeadlineResponse;
import uk.me.uohiro.protobuf.model.ch7.ex4.Empty;

public class DeadlinePropagationClient1 {
	private static final Logger logger = Logger.getLogger(DeadlinePropagationClient1.class.getName());

	private final ManagedChannel channel;
	private final DeadlineMainBlockingStub blockingStub;

	public DeadlinePropagationClient1(String host, int port) {
		this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
	}

	public DeadlinePropagationClient1(ManagedChannelBuilder<?> channelBuilder) {
		channel = channelBuilder.build();
		blockingStub = DeadlineMainGrpc.newBlockingStub(channel).withDeadlineAfter(3000L, TimeUnit.MILLISECONDS);
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public void access() {
		Empty request = Empty.newBuilder().build();
		
		DeadlineResponse response = null;
		try {
			response = blockingStub.fast(request);
			info("Response: {0}", String.join(",", response.getResultList()));
			
			response = blockingStub.slow(request);
			info("Response: {0}", String.join(",", response.getResultList()));
		} catch (StatusRuntimeException e) {
			warning("RPC failed [code]: {0}", e.getStatus().getCode());
			warning("RPC failed [descrition]: {0}", e.getStatus().getDescription()); // Error description<cr>Augmented description]
		}		
	}

	public static void main(String[] args) throws Exception {

		DeadlinePropagationClient1 client = new DeadlinePropagationClient1("localhost", 8100);

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
