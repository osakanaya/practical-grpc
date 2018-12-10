package uk.me.uohiro.protobuf.extras.ex1.service;

import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.extras.ex1.Temperature;
import uk.me.uohiro.protobuf.model.extras.ex1.Temperature.Units;
import uk.me.uohiro.protobuf.model.extras.ex1.WeatherGrpc.WeatherImplBase;
import uk.me.uohiro.protobuf.model.extras.ex1.WeatherRequest;
import uk.me.uohiro.protobuf.model.extras.ex1.WeatherResponse;

public class WeatherService extends WeatherImplBase {
	public WeatherService() {
	}
	
	@Override
	public void getCurrent(WeatherRequest request, StreamObserver<WeatherResponse> responseObserver) {
		WeatherResponse response = WeatherResponse.newBuilder()
				.setTemperature(Temperature.newBuilder().setDegrees(70).setUnits(Units.FAHRENHEIT))
				.setHumidity(.65f).build();
		
		responseObserver.onNext(response);	
		responseObserver.onCompleted();
	}
}
