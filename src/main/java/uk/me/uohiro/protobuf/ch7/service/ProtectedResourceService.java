package uk.me.uohiro.protobuf.ch7.service;

import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.ch7.ex3.GetDataRequest;
import uk.me.uohiro.protobuf.model.ch7.ex3.GetDataResponse;
import uk.me.uohiro.protobuf.model.ch7.ex3.ProtectedResourceGrpc.ProtectedResourceImplBase;

public class ProtectedResourceService extends ProtectedResourceImplBase {
	public ProtectedResourceService() {
	}
	
	@Override
	public void getData(GetDataRequest request, StreamObserver<GetDataResponse> responseObserver) {
		GetDataResponse response = GetDataResponse.newBuilder().setData("data" + request.getId()).build();

		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}
