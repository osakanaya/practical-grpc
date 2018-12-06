package uk.me.uohiro.protobuf.ch7.client;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.ProtoUtils;
import uk.me.uohiro.protobuf.model.ch7.ex1.ErrorDetails;
import uk.me.uohiro.protobuf.model.ch7.ex1.ErrorManagementGrpc;
import uk.me.uohiro.protobuf.model.ch7.ex1.ErrorManagementGrpc.ErrorManagementBlockingStub;
import uk.me.uohiro.protobuf.model.ch7.ex1.GetDataRequest;
import uk.me.uohiro.protobuf.model.ch7.ex1.GetDataResponse;

public class ErrorManagementClient {
	private static final Logger logger = Logger.getLogger(ErrorManagementClient.class.getName());

	private final ManagedChannel channel;
	private final ErrorManagementBlockingStub blockingStub;

	public ErrorManagementClient(String host, int port) {
		this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
	}

	public ErrorManagementClient(ManagedChannelBuilder<?> channelBuilder) {
		channel = channelBuilder.build();
		blockingStub = ErrorManagementGrpc.newBlockingStub(channel);
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public void getData(String id) {
		info("*** GetData: id={0}", id);

		GetDataRequest request = GetDataRequest.newBuilder().setId(id).build();

		try {
			GetDataResponse response = blockingStub.getData(request);
			info("Data: {0}", response.getData());
		} catch (StatusRuntimeException e) {
			warning("RPC failed [code]: {0}", e.getStatus().getCode());
			warning("RPC failed [descrition]: {0}", e.getStatus().getDescription()); // Error description<cr>Augmented description]

			Metadata metadata = e.getTrailers();
			ErrorDetails errorDetails = metadata.get(ProtoUtils.keyForProto(ErrorDetails.getDefaultInstance()));
			
			for (int i = 0; i < errorDetails.getDetailsList().size(); i++) {
				warning("RPC failed [trailers {0}][key]: {1}", (i+1), errorDetails.getDetailsList().get(i).getKey());
				warning("RPC failed [trailers {0}][message]: {1}", (i+1), errorDetails.getDetailsList().get(i).getMessage());
			}
		}		
	}

	public static void main(String[] args) throws Exception {

		ErrorManagementClient client = new ErrorManagementClient("localhost", 8080);

		try {
			client.getData("1");
			client.getData("2");
		} finally {
			client.shutdown();
		}
	}

	private void info(String msg, Object... params) {
		logger.log(Level.INFO, msg, params);
	}

	private void warning(String msg, Object... params) {
		logger.log(Level.WARNING, msg, params);
	}
}
