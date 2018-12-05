package uk.me.uohiro.protobuf.ch6.service;

import java.util.Collection;

import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.ch6.DatabaseGrpc.DatabaseImplBase;
import uk.me.uohiro.protobuf.model.ch6.SearchRequest;
import uk.me.uohiro.protobuf.model.ch6.SearchResponse;

public class DatabaseService extends DatabaseImplBase {
	private final Collection<String> contents;
	
	public DatabaseService(Collection<String> contents) {
		this.contents = contents;
	}
	
	@Override
	public void search(SearchRequest request, StreamObserver<SearchResponse> responseObserver) {
		int rank = 1;
		
		for (String content : contents) {
			String term = request.getTerm();
			
			SearchResponse response = SearchResponse.newBuilder()
					.setMatchedTerm(term)
					.setRank(rank)
					.setContent(content).build();
			
			responseObserver.onNext(response);
			
			rank++;
		}
		
		responseObserver.onCompleted();
	}
}
