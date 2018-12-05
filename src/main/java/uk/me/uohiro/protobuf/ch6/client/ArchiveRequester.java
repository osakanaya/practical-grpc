package uk.me.uohiro.protobuf.ch6.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.protobuf.ByteString;

import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.ch6.ex2.ZipRequest;

public class ArchiveRequester implements Callable<Boolean> {
	private static final Logger logger = Logger.getLogger(ArchiveRequester.class.getName());
	
	private StreamObserver<ZipRequest> requestObserver;
	private String fileName;
	
	public ArchiveRequester(StreamObserver<ZipRequest> requestObserver, String fileName) {
		this.requestObserver = requestObserver;
		this.fileName = fileName;
	}

	@Override
	public Boolean call() throws Exception {
		try {
			logger.log(Level.INFO, "Sending file - START: {0}", fileName);
			ZipRequest request = ZipRequest.newBuilder().setFileName(fileName).setContents(readFile()).build();
			requestObserver.onNext(request);
			logger.log(Level.INFO, "Sending file - END: {0}", fileName);
			
			return Boolean.TRUE;
		} catch (StatusRuntimeException e) {
			logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
			requestObserver.onError(e);

			return Boolean.FALSE;
		} catch (IOException e) {
			logger.log(Level.WARNING, "Error when reading file: {0}", e.getMessage());
			requestObserver.onError(e);

			return Boolean.FALSE;
		}
	}
	
	public ByteString readFile() throws IOException {
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(ArchiverConstants.BASE_FILE);
			return ByteString.readFrom(fis);
		} finally {
			if (fis != null) fis.close();
		}
	}
}
