package swd20.movieDB;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import swd20.movieDB.domain.Movie;
import swd20.movieDB.domain.MovieRepository;

@SpringBootApplication
public class MovieDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieDbApplication.class, args);
	}

	@Bean
	public static CommandLineRunner demoData(MovieRepository movieRepository) {
		return (args) -> {
			Movie movie1 = new Movie("Joker",
					"In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker.",
					"https://images-na.ssl-images-amazon.com/images/I/71q-7%2BKrvLL._AC_SL1350_.jpg",
					"https://www.youtube.com/watch?v=zAGVQLHvwOY", 2019);
			Movie movie2 = new Movie("Tenet",
					"Armed with only one word, Tenet, and fighting for the survival of the entire world, a Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
					"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRzBWDx-ZPxc65uJDGjleNCfIe5t3dQ8j4dnYg5QnhjiPTN4I-Q",
					"https://www.youtube.com/watch?v=AZGcmvrTX9M", 2020);

			movieRepository.save(movie1);
			movieRepository.save(movie2);
		};
	}

}
