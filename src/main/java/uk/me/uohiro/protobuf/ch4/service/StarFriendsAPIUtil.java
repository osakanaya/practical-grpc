package uk.me.uohiro.protobuf.ch4.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.google.protobuf.Timestamp;

import uk.me.uohiro.protobuf.model.ch4.Film;
import uk.me.uohiro.protobuf.model.ch4.StarFriendsGrpc.StarFriendsImplBase;

public class StarFriendsAPIUtil extends StarFriendsImplBase {
	public static Collection<Film> getDefaultFilms() throws Exception {
		List<Film> films = new ArrayList<>();
		
		films.add(generateFilm("4", "A New Hope", "George Lucas", "Gary Kurtz, Rick McCallum", "1977-05-25"));
		films.add(generateFilm("5", "The Empire Strikes Back", "Irvin Kershner", "Gary Kurtz, Rick McCallum", "1980-05-17"));
		films.add(generateFilm("6", "Return of the Jedi", "Richard Marquand", "Howard G. Kazanjian, George Lucas, Rick McCallum", "1983-05-25"));

		return films;
	}
	
	private static Film generateFilm(
			String id, String title, String director, String producer, String releaseDateStr) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date releaseDate = sdf.parse(releaseDateStr);

		Film.Builder builder = Film.newBuilder();
		return builder
				.setId(id)
				.setTitle(title)
				.setDirector(director)
				.setProducer(producer)
				.setReleaseDate(Timestamp.newBuilder().setSeconds(releaseDate.toInstant().getEpochSecond()).build())
				.build();
	}
}
