package uk.me.uohiro.protobuf.ch6.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.protobuf.ByteString;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.ch6.ex2.ArchiverGrpc;
import uk.me.uohiro.protobuf.model.ch6.ex2.ArchiverGrpc.ArchiverStub;
import uk.me.uohiro.protobuf.model.ch6.ex2.ZipRequest;
import uk.me.uohiro.protobuf.model.ch6.ex2.ZipResponse;

public class ArchiverClient {
	private static final Logger logger = Logger.getLogger(ArchiverClient.class.getName());

	private static final String FILE_LOCATION = "C:/temp";
	private static final String BASE_FILE = FILE_LOCATION + File.separator + "image.jpg";
	
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

	public void archive(String fileName) {
		info("*** archive: file={0}", fileName);

		StreamObserver<ZipResponse> responseObserver = new StreamObserver<ZipResponse>() {

			@Override
			public void onCompleted() {
				info("Finished archiving.");
			}

			@Override
			public void onError(Throwable t) {
				warning("RecordRoute Failed: {0}", Status.fromThrowable(t));
			}

			@Override
			public void onNext(ZipResponse response) {
				info("Finished archiving.");
			}
			
		};
		
		StreamObserver<ZipRequest> requestObserver = asyncStub.zip(responseObserver);

		try {
			requestObserver.onNext(ZipRequest.newBuilder().setFileName("test1.jpg").setContents(readFile()).build());
		} catch (StatusRuntimeException e) {
			warning("RPC failed: {0}", e.getStatus());
			requestObserver.onError(e);
		} catch (IOException e) {
			warning("Error when reading file: {0}", e.getMessage());
			requestObserver.onError(e);
		}
		
		requestObserver.onCompleted();
	}
	
	public ByteString readFile() throws IOException {
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(BASE_FILE);
			
			return ByteString.readFrom(fis);
		} finally {
			if (fis != null) fis.close();
		}
	}

	public static void main(String[] args) throws Exception {

		ArchiverClient client = new ArchiverClient("localhost", 8080);

		try {
			client.archive("test1.jpg");
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
