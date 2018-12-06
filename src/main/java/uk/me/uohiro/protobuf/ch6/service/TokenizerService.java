package uk.me.uohiro.protobuf.ch6.service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeRequest;
import uk.me.uohiro.protobuf.model.ch6.ex3.TokenizeResponse;
import uk.me.uohiro.protobuf.model.ch6.ex3.TokenizerGrpc.TokenizerImplBase;

public class TokenizerService extends TokenizerImplBase {
	private static final Logger logger = Logger.getLogger(TokenizerService.class.getName());
	
	public TokenizerService() {}

	@Override
	public StreamObserver<TokenizeRequest> tokenize(StreamObserver<TokenizeResponse> responseObserver) {
		return new StreamObserver<TokenizeRequest>() {
			private Map<String, Long> words = new HashMap<>();
			
			@Override
			public void onCompleted() {
				responseObserver.onCompleted();
			}

			@Override
			public void onError(Throwable t) {
				logger.log(Level.WARNING, "tokenize cancelled", t);
			}

			@Override
			public void onNext(TokenizeRequest request) {
				InputStream is = null;
				BufferedReader br = null;
				
				try {
					is = new ByteArrayInputStream(request.getFileContents().toByteArray());
					br = new BufferedReader(new InputStreamReader(is));
					
					String line;
					while ((line = br.readLine()) != null) {
						if (line.equals("")) {
							continue;
						}
						
						line = line.replace(".", "").replace(",", "");
						
						for (String word : line.split("\\s")) {
							if (words.containsKey(word.toLowerCase())) {
								long current = words.get(word.toLowerCase());
								words.put(word.toLowerCase(), ++current);
							} else {
								words.put(word.toLowerCase(), 1L);
							}
						}
					}
					
					TokenizeResponse response = TokenizeResponse.newBuilder().putAllWords(words).build();
					responseObserver.onNext(response);
				} catch (IOException e) {
					responseObserver.onError(
							Status.INTERNAL
							.withDescription("Error tokenizing file")
							.withCause(e)
							.asException());
				} finally {
					try {
						if (is != null) {
							is.close();
						}
						if (br != null) {
							br.close();
						}
					} catch (IOException e) {}
				}
			}
		};
	}
}
