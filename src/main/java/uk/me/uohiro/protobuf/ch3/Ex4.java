package uk.me.uohiro.protobuf.ch3;

import uk.me.uohiro.protobuf.model.ch3.ex4.Film;

public class Ex4 {
	public static void main(String[] args) throws Exception {
		Film.Builder builder = Film.newBuilder();

		Film film = builder
				.setTitle("title")
				.setDirector("director")
				.setProducer("producer")
				.setReleaseDate("2018/12/04")
				.putRoles("main", 
						Film.Character.newBuilder()
						.setName("character.name")
						.setBirth(1L)
						.setLaserGunModel("laser_gun_model")	// not effective
						.setLaserSwordPower(100)
						.build())
				.build();
		
		System.out.println(film.getRolesOrThrow("main").hasLaserGunModel());	// false
		System.out.println(film.getRolesOrThrow("main").hasLaserSwordPower());	// true
	}
}
