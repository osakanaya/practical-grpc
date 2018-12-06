package uk.me.uohiro.protobuf.ch7.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.ch7.interceptor.JWTConstants;
import uk.me.uohiro.protobuf.model.ch7.ex3.Empty;
import uk.me.uohiro.protobuf.model.ch7.ex3.Greeting;
import uk.me.uohiro.protobuf.model.ch7.ex3.ProtectedResourceGrpc.ProtectedResourceImplBase;

public class ProtectedResourceService extends ProtectedResourceImplBase {
	private static final Logger logger = Logger.getLogger(ProtectedResourceService.class.getName());

	public ProtectedResourceService() {
	}
	
	@Override
	public void sayHello(Empty request, StreamObserver<Greeting> responseObserver) {
		String sub = JWTConstants.SUB_CTX_KEY.get();
		logger.log(Level.INFO, "sub: {0}", sub);

		Greeting greeting = Greeting.newBuilder().setGreeting("Hello there, your userId is " + sub).build();
		responseObserver.onNext(greeting);

		responseObserver.onCompleted();
	}
}
