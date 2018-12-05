package uk.me.uohiro.protobuf.ch6.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.protobuf.ByteString;

import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeRequest;

public class TokenizeRequester implements Callable<Boolean> {
	private static final Logger logger = Logger.getLogger(TokenizeRequester.class.getName());
	
	private StreamObserver<TokenizeRequest> requestObserver;
	private String filepath;
	
	public TokenizeRequester(StreamObserver<TokenizeRequest> requestObserver, String filepath) {
		this.requestObserver = requestObserver;
		this.filepath = filepath;
	}

	@Override
	public Boolean call() throws Exception {
		try {
			logger.log(Level.INFO, "Sending file - START: {0}", filepath);
			TokenizeRequest request = TokenizeRequest.newBuilder().setFileContents(readFile(filepath)).build();
			requestObserver.onNext(request);
			logger.log(Level.INFO, "Sending file - END: {0}", filepath);
			
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
	
	public ByteString readFile(String filepath) throws IOException {
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(filepath);
			return ByteString.readFrom(fis);
		} finally {
			if (fis != null) fis.close();
		}
	}
}
