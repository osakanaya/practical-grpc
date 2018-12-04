package uk.me.uohiro.protobuf.client.ch3;

import uk.me.uohiro.protobuf.model.ch3.ex10.Film;
import uk.me.uohiro.protobuf.model.ch3.ex10.ProducerCompanies;
import uk.me.uohiro.protobuf.model.ch3.ex10.TerrorFilm;

import com.google.protobuf.Any;

import uk.me.uohiro.protobuf.model.ch3.ex10.Character;

public class Ex10 {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		TerrorFilm.Builder builder1 = TerrorFilm.newBuilder();
		TerrorFilm terrorFilm = builder1
				.setHasZombies(true)
				.build();

		Any filmDetail = Any.pack(terrorFilm);
		
		Film.Builder builder2 = Film.newBuilder();
		Film film1 = builder2
				.setTitle("title")
				.setDirector("director")
				.setProducer("producer")
				.setReleaseDate("2018/12/04")
				.putRoles("main", 
						Character.newBuilder()
						.setName("character.name")
						.setBirth(1L)
						.setLaserGunModel("laser_gun_model")	// not effective
						.setLaserSwordPower(100)
						.build())
				.setProducerCompany(ProducerCompanies.PARAMOUNT)
				.setFilmDetail(filmDetail)
				.build();
	}
}
