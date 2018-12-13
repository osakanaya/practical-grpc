package uk.me.uohiro.protobuf.ch11.ex1.service;

import java.util.Collection;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import uk.me.uohiro.protobuf.model.ch11.ex1.Film;
import uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmRequest;
import uk.me.uohiro.protobuf.model.ch11.ex1.GetFilmResponse;
import uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsRequest;
import uk.me.uohiro.protobuf.model.ch11.ex1.ListFilmsResponse;
import uk.me.uohiro.protobuf.model.ch11.ex1.StarFriendsGrpc.StarFriendsImplBase;

public class StarFriendsAPIService extends StarFriendsImplBase {
	private final Collection<Film> films;
	
	public StarFriendsAPIService(Collection<Film> films) {
		this.films = films;
	}
	
	@Override
	public void getFilm(GetFilmRequest request, StreamObserver<GetFilmResponse> responseObserver) {
		for (Film film : films) {
			if (film.getId().equals(request.getId())) {
				GetFilmResponse response = GetFilmResponse.newBuilder().setFilm(film).build();
				responseObserver.onNext(response);
				responseObserver.onCompleted();
				return;
			}
		}

		responseObserver.onError(
				Status.NOT_FOUND
				.withDescription("Film not found with id = " + request.getId())
				.asException());
	}

	@Override
	public void listFilms(ListFilmsRequest request, StreamObserver<ListFilmsResponse> responseObserver) {
		ListFilmsResponse response = ListFilmsResponse.newBuilder().addAllFilms(films).build();
		
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}
