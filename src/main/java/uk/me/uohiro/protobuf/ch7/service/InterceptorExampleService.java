package uk.me.uohiro.protobuf.ch7.service;

import java.security.SecureRandom;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.ch7.ex2.Empty;
import uk.me.uohiro.protobuf.model.ch7.ex2.GetDataRequest;
import uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse;
import uk.me.uohiro.protobuf.model.ch7.ex2.InterceptorExampleGrpc.InterceptorExampleImplBase;

public class InterceptorExampleService extends InterceptorExampleImplBase {
	private SecureRandom rand = new SecureRandom();
	
	public InterceptorExampleService() {
	}
	
	@Override
	public void getData(GetDataRequest request, StreamObserver<GetDataResponse> responseObserver) {
		if (request.getId().equals("1")) {
			GetDataResponse response = GetDataResponse.newBuilder().setData("data" + request.getId()).build();
			responseObserver.onNext(response);
			responseObserver.onCompleted();
		} else if (request.getId().equals("2")) {
			responseObserver.onError(
					Status.NOT_FOUND
					.withDescription("Data not found with id = " + request.getId())
					.withCause(new CustomException("Data not found with id = " + request.getId()))
					.asException());
		} else {
			responseObserver.onError(new IllegalArgumentException("You cannot specify id other than 1 or 2."));
		}
	}
	
	@Override
	public void getStreamData(Empty request, StreamObserver<GetDataResponse> responseObserver) {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(rand.nextInt(100) * 3L);
			} catch (InterruptedException e) {}
			
			GetDataResponse response = GetDataResponse.newBuilder().setData("data" + i).build();
			responseObserver.onNext(response);
		}
		
		responseObserver.onCompleted();
	}
}
