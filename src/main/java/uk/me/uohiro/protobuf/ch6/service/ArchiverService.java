package uk.me.uohiro.protobuf.ch6.service;

import java.io.ByteArrayOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.google.protobuf.ByteString;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.ch6.ex2.ArchiverGrpc.ArchiverImplBase;
import uk.me.uohiro.protobuf.model.ch6.ex2.ZipRequest;
import uk.me.uohiro.protobuf.model.ch6.ex2.ZipResponse;

public class ArchiverService extends ArchiverImplBase {

	public ArchiverService() {}
	
	@Override
	public StreamObserver<ZipRequest> zip(StreamObserver<ZipResponse> responseObserver) {
		return new StreamObserver<ZipRequest>() {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ZipOutputStream zipOut = new ZipOutputStream(baos);
			
			@Override
			public void onCompleted() {
				responseObserver.onNext(
					ZipResponse.newBuilder().setZippedContents(ByteString.copyFrom(baos.toByteArray())).build()
				);
				
				responseObserver.onCompleted();
			}

			@Override
			public void onError(Throwable t) {
				responseObserver.onError(
						Status.INTERNAL
						.withDescription("Error createing zip archive")
						.withCause(t)
						.asException());
			}

			@Override
			public void onNext(ZipRequest request) {
				try {
					ZipEntry entry = new ZipEntry(request.getFileName());
					zipOut.putNextEntry(entry);
					zipOut.write(request.getContents().toByteArray());
					zipOut.closeEntry();
				} catch (Exception e) {
					onError(e);
				}
			}
		};
	}
}
