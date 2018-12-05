package uk.me.uohiro.protobuf.ch6.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeRequest;
import uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse;
import uk.me.uohiro.protobuf.model.ch6.ex3.TokenizerGrpc;
import uk.me.uohiro.protobuf.model.ch6.ex3.TokenizerGrpc.TokenizerStub;

public class TokenizeClient {
	private static final Logger logger = Logger.getLogger(TokenizeClient.class.getName());

	private final ManagedChannel channel;
	private final TokenizerStub asyncStub;

	public TokenizeClient(String host, int port) {
		this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
	}

	public TokenizeClient(ManagedChannelBuilder<?> channelBuilder) {
		channel = channelBuilder.build();
		asyncStub = TokenizerGrpc.newStub(channel);
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public void tokenize() throws InterruptedException {
		logger.info("*** tokenize ***");

		Map<String, Long> total = new ConcurrentHashMap<>();
		final CountDownLatch finishLatch = new CountDownLatch(1);

		StreamObserver<TokenizeResponse> responseObserver = new StreamObserver<TokenizeResponse>() {

			@Override
			public void onCompleted() {
				logger.info("Tokenize Completed.");
				finishLatch.countDown();
			}

			@Override
			public void onError(Throwable t) {
				logger.log(Level.WARNING, "Tokenize Failed: {0}", Status.fromThrowable(t));
				finishLatch.countDown();
			}

			@Override
			public void onNext(TokenizeResponse response) {
				logger.info("Result received.");

				Map<String, Long> result = response.getWordsMap();
				total.putAll(result);
			}
		};

		StreamObserver<TokenizeRequest> requestObserver = asyncStub.tokenize(responseObserver);

        // スレッドプールを準備
		ExecutorService executor = Executors.newFixedThreadPool(5);
		CompletionService<Boolean> completionService = new ExecutorCompletionService<Boolean>(executor);

		// 各スレッドの実行結果を保持する
		List<Future<Boolean>> futures = new ArrayList<>();
		
		// ポート番号ごとにスレッドを起動
		for(int i = 1; i <= 5; i++) {
			TokenizeRequester requester = new TokenizeRequester(requestObserver, "C:/temp/test" + i + ".txt");
			futures.add(completionService.submit(requester));
		}
		
        // スレッドの起動が完了するまで待機
		while(futures.size() > 0) {
			// 完了したスレッドの実行結果を取り出す（実行が完了するまでブロックされる）
			Future<Boolean> completed = completionService.take();
			futures.remove(completed);
		}

		requestObserver.onCompleted();
	
		// ZIPファイル受信まで待機する
		finishLatch.await();
		
		System.out.println(total);
	}
	
	public static void main(String[] args) throws Exception {

		TokenizeClient client = new TokenizeClient("localhost", 8080);

		try {
			client.tokenize();
		} finally {
			client.shutdown();
		}
	}
}
