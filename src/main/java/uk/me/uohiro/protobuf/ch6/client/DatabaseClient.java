package uk.me.uohiro.protobuf.ch6.client;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import uk.me.uohiro.protobuf.model.ch6.DatabaseGrpc;
import uk.me.uohiro.protobuf.model.ch6.DatabaseGrpc.DatabaseBlockingStub;
import uk.me.uohiro.protobuf.model.ch6.SearchRequest;
import uk.me.uohiro.protobuf.model.ch6.SearchResponse;

public class DatabaseClient {
	private static final Logger logger = Logger.getLogger(DatabaseClient.class.getName());

	private final ManagedChannel channel;
	private final DatabaseBlockingStub blockingStub;

	public DatabaseClient(String host, int port) {
		this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
	}

	public DatabaseClient(ManagedChannelBuilder<?> channelBuilder) {
		channel = channelBuilder.build();
		blockingStub = DatabaseGrpc.newBlockingStub(channel);
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public void search(String term) {
		info("*** search: term={0}", term);

		SearchRequest request = SearchRequest.newBuilder().setTerm(term).setMaxResults(100L).build();

		Iterator<SearchResponse> matches;
		try {
			matches = blockingStub.search(request);

			for(int i = 1; matches.hasNext(); i++) {
				SearchResponse matched = matches.next();
				info("Resutl #" + i + ": {0}", matched);
			}
		} catch (StatusRuntimeException e) {
			warning("RPC failed: {0}", e.getStatus());
		}
	}

	public static void main(String[] args) throws Exception {

		DatabaseClient client = new DatabaseClient("localhost", 8080);

		try {
			client.search("test term");
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
