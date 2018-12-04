package uk.me.uohiro.protobuf.client.ch3;

import uk.me.uohiro.protobuf.model.ch3.ex1.Film;

public class Ex1 {
	public static void main(String[] args) throws Exception {
		Film.Builder builder = Film.newBuilder();
		Film film = builder
				.setTitle("title")
				.setDirector("director")
				.setProducer("producer")
				.build();
		
		System.out.println(film.hasTitle());			// true
		System.out.println(film.hasDirector());			// true
		System.out.println(film.hasProducer());			// true
		System.out.println(film.hasReleaseDate());		// false
		System.out.println(film.getCharacterCount());	// 0

		film = builder
				.setTitle("title")
				.setDirector("director")
				.setProducer("producer")
				.setReleaseDate("2018/12/04")
				.addCharacter("character1")
				.build();
		
		System.out.println(film.hasTitle());			// true
		System.out.println(film.hasDirector());			// true
		System.out.println(film.hasProducer());			// true
		System.out.println(film.hasReleaseDate());		// true
		System.out.println(film.getCharacterCount());	// 1
	}
}
