package uk.me.uohiro.protobuf.ch7.service;

import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.protobuf.ProtoUtils;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.ch7.ex1.ErrorDetail;
import uk.me.uohiro.protobuf.model.ch7.ex1.ErrorDetails;
import uk.me.uohiro.protobuf.model.ch7.ex1.ErrorManagementGrpc.ErrorManagementImplBase;
import uk.me.uohiro.protobuf.model.ch7.ex1.GetDataRequest;
import uk.me.uohiro.protobuf.model.ch7.ex1.GetDataResponse;

public class ErrorManagementService extends ErrorManagementImplBase {
	public ErrorManagementService() {
	}
	
	@Override
	public void getData(GetDataRequest request, StreamObserver<GetDataResponse> responseObserver) {
		try {
			if (request.getId().equals("1")) {
				GetDataResponse response = GetDataResponse.newBuilder().setData("data").build();
				responseObserver.onNext(response);
				responseObserver.onCompleted();
			} else {
				throw new CustomException("Exception message");
			}
		} catch (CustomException e) {
            Metadata metadata = new Metadata();
            ErrorDetail detail1 = ErrorDetail.newBuilder()
                    .setKey("error1 key")
                    .setMessage("error1 message")
                    .build();
            ErrorDetail detail2 = ErrorDetail.newBuilder()
                    .setKey("error2 key")
                    .setMessage("error2 message")
                    .build();           
            ErrorDetails details = ErrorDetails.newBuilder().addDetails(detail1).addDetails(detail2).build();

            Metadata.Key<ErrorDetails> key = ProtoUtils.keyForProto(details);
            metadata.put(key, details);
            
            responseObserver.onError(
					Status.INTERNAL
						.withDescription("Error description")
						.withCause(e)
						.augmentDescription("Augmented description")
						.asException(metadata)
				);
		}
	}
}
