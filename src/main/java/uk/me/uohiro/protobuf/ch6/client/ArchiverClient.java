package uk.me.uohiro.protobuf.ch6.client;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionService;
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
import uk.me.uohiro.protobuf.model.ch6.ex2.ArchiverGrpc;
import uk.me.uohiro.protobuf.model.ch6.ex2.ArchiverGrpc.ArchiverStub;
import uk.me.uohiro.protobuf.model.ch6.ex2.ZipRequest;
import uk.me.uohiro.protobuf.model.ch6.ex2.ZipResponse;

public class ArchiverClient {
	private static final Logger logger = Logger.getLogger(ArchiverClient.class.getName());

	private final ManagedChannel channel;
	private final ArchiverStub asyncStub;

	public ArchiverClient(String host, int port) {
		this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
	}

	public ArchiverClient(ManagedChannelBuilder<?> channelBuilder) {
		channel = channelBuilder.build();
		asyncStub = ArchiverGrpc.newStub(channel);
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public void archiveFiles() throws InterruptedException {
		logger.info("*** archiveFiles");
		final CountDownLatch finishLatch = new CountDownLatch(1);

		StreamObserver<ZipResponse> responseObserver = new StreamObserver<ZipResponse>() {

			@Override
			public void onCompleted() {
				logger.info("Archive Completed.");
				finishLatch.countDown();
			}

			@Override
			public void onError(Throwable t) {
				logger.log(Level.WARNING, "Archive Failed: {0}", Status.fromThrowable(t));
				finishLatch.countDown();
			}

			@Override
			public void onNext(ZipResponse response) {
				logger.info("Zipped contents received.");

				FileOutputStream fos = null;
				try {
					fos = new FileOutputStream(ArchiverConstants.ZIPPED_FILE);
					response.getZippedContents().writeTo(fos);

					logger.info("Zipped file placed.");
				} catch (IOException e) {
					logger.log(Level.WARNING, "Error when placing zipped contents to a file: {0}", e.getMessage());
				} finally {
					if (fos != null) {
						try {
							fos.close();
						} catch (IOException e) {
						}
					}
				}
			}
		};

		StreamObserver<ZipRequest> requestObserver = asyncStub.zip(responseObserver);

        // スレッドプールを準備
		ExecutorService executor = Executors.newFixedThreadPool(5);
		CompletionService<Boolean> completionService = new ExecutorCompletionService<Boolean>(executor);

		// 各スレッドの実行結果を保持する
		List<Future<Boolean>> futures = new ArrayList<>();
		
		// ポート番号ごとにスレッドを起動
		for(int i = 1; i <= 5; i++) {
			ArchiveRequester requester = new ArchiveRequester(requestObserver, "test" + i + ".jpg");
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
	}
	
	public static void main(String[] args) throws Exception {

		ArchiverClient client = new ArchiverClient("localhost", 8080);

		try {
			client.archiveFiles();
		} finally {
			client.shutdown();
		}
	}
}
