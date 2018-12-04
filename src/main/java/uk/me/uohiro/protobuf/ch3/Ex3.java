package uk.me.uohiro.protobuf.ch3;

import uk.me.uohiro.protobuf.model.ch3.ex3.Film;

public class Ex3 {
	public static void main(String[] args) throws Exception {
		Film.Builder builder = Film.newBuilder();

		@SuppressWarnings("unused")
		Film film = builder
				.setTitle("title")
				.setDirector("director")
				.setProducer("producer")
				.setReleaseDate("2018/12/04")
				.putRoles("main", 
						Film.Character.newBuilder()
						.setName("character.name")
						.setBirth(1L)
						.build())
				.build();
	}
}
