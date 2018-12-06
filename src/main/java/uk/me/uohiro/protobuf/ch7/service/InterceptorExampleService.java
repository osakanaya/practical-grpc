package uk.me.uohiro.protobuf.ch7.service;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.ch7.ex2.GetDataRequest;
import uk.me.uohiro.protobuf.model.ch7.ex2.GetDataResponse;
import uk.me.uohiro.protobuf.model.ch7.ex2.InterceptorExampleGrpc.InterceptorExampleImplBase;

public class InterceptorExampleService extends InterceptorExampleImplBase {
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
}
