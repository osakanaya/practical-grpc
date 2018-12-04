package uk.me.uohiro.protobuf.client.ch3;

import uk.me.uohiro.protobuf.model.ch3.ex8.Film;
import uk.me.uohiro.protobuf.model.ch3.ex8.ProducerCompanies;
import uk.me.uohiro.protobuf.model.ch3.ex8.Character;

public class Ex8 {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		Film.Builder builder = Film.newBuilder();

		Film film = builder
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
				.build();
	}
}
