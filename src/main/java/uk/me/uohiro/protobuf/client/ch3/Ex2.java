package uk.me.uohiro.protobuf.client.ch3;

import uk.me.uohiro.protobuf.model.ch3.ex2.Film;
import uk.me.uohiro.protobuf.model.ch3.ex2.Film.Character;
import uk.me.uohiro.protobuf.model.ch3.ex2.OtherFilm;

public class Ex2 {
	public static void main(String[] args) throws Exception {
		Film.Builder builder1 = Film.newBuilder();
		@SuppressWarnings("unused")
		Film film = builder1
				.setTitle("title")
				.setDirector("director")
				.setProducer("producer")
				.setReleaseDate("2018/12/04")
				.addCharacter(
						Character.newBuilder()
							.setName("character.name")
							.setBirth(1L))
				.build();
		
		OtherFilm.Builder builder2 = OtherFilm.newBuilder();
		@SuppressWarnings("unused")
		OtherFilm otherFilm = builder2
				.addCharacters(
						Character.newBuilder()
							.setName("character.name")
							.setBirth(1L))
				.build();
	}
}
