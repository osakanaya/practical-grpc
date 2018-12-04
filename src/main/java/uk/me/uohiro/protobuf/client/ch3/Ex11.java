package uk.me.uohiro.protobuf.client.ch3;

import uk.me.uohiro.protobuf.model.ch3.ex11.Film;
import uk.me.uohiro.protobuf.model.ch3.ex11.ProducerCompanies;
import uk.me.uohiro.protobuf.model.ch3.ex11.ScienceFictionFilm;
import uk.me.uohiro.protobuf.model.ch3.ex11.TerrorFilm;
import uk.me.uohiro.protobuf.model.ch3.ex11.Character;

public class Ex11 {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		Film.Builder builder1 = Film.newBuilder();
		Film film1 = builder1
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
				.setComment("comment")
				.build();
		
		TerrorFilm.Builder builder2 = TerrorFilm.newBuilder();
		TerrorFilm terrorFilm = builder2
				.setHasZombies(true)
				.build();
		
		Film.Builder builder3 = Film.newBuilder();
		Film film2 = builder3
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
				.setExtension(TerrorFilm.film, terrorFilm)
				.build();
		
		ScienceFictionFilm.Builder builder4 = ScienceFictionFilm.newBuilder();
		ScienceFictionFilm scienceFictionFilm = builder4
				.setHasJedis(false)
				.build();
		
		Film.Builder builder5 = Film.newBuilder();
		Film film3 = builder5
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
				.setExtension(ScienceFictionFilm.film, scienceFictionFilm)
				.build();
	}
}
