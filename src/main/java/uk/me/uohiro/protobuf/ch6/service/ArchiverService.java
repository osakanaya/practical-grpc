package uk.me.uohiro.protobuf.ch6.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
				System.out.println("onCompleted");
				try {
					responseObserver.onNext(
							ZipResponse.newBuilder().setZippedContents(ByteString.copyFrom(baos.toByteArray())).build()
						);
						
					responseObserver.onCompleted();
				} finally {
					if (baos != null) {
						try {
							baos.close();
						} catch (IOException e) {
						}
					}
					
					if (zipOut != null) {
						try {
							zipOut.close();
						} catch (IOException e) {
						}
					}
				}
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("onError");
				try {
					responseObserver.onError(
							Status.INTERNAL
							.withDescription("Error createing zip archive")
							.withCause(t)
							.asException());
				} finally {
					if (baos != null) {
						try {
							baos.close();
						} catch (IOException e) {
						}
					}
					
					if (zipOut != null) {
						try {
							zipOut.close();
						} catch (IOException e) {
						}
					}
				}
			}

			@Override
			public void onNext(ZipRequest request) {
				System.out.println("onNext");
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
