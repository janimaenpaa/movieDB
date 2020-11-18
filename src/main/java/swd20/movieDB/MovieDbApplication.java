package swd20.movieDB;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import swd20.movieDB.domain.Movie;
import swd20.movieDB.domain.MovieRepository;
import swd20.movieDB.domain.Review;
import swd20.movieDB.domain.ReviewRepository;

@SpringBootApplication
public class MovieDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieDbApplication.class, args);
	}

	@Bean
	public static CommandLineRunner demoData(MovieRepository movieRepository, ReviewRepository reviewRepository) {
		return (args) -> {
			Movie movie1 = new Movie("Joker",
					"In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker.",
					"https://moviedb-imageupload.s3.eu-north-1.amazonaws.com/0c1b79c8-43b9-481e-b8c4-598deee60cc3",
					"zAGVQLHvwOY", 2019);
			Movie movie2 = new Movie("Tenet",
					"Armed with only one word, Tenet, and fighting for the survival of the entire world, a Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
					"https://moviedb-imageupload.s3.eu-north-1.amazonaws.com/d6a75b11-8878-404a-8678-d26ed6334aff",
					"AZGcmvrTX9M", 2020);
			Movie movie3 = new Movie("The King's Speech",
					"The story of King George VI, his impromptu ascension to the throne of the British Empire in 1936, and the speech therapist who helped the unsure monarch overcome his stammer.",
					"https://moviedb-imageupload.s3.eu-north-1.amazonaws.com/2c7ab309-6d36-4830-9de7-d6e401c0354e",
					"EcxBrTvLbBM", 2010);
			Movie movie4 = new Movie("Inception",
					"A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
					"https://moviedb-imageupload.s3.eu-north-1.amazonaws.com/d143d6ec-1d8e-45a3-9284-dca0cd4c1b09",
					"fTRnWXXDcL4", 2010);
			Movie movie5 = new Movie("Parasite",
					"Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.",
					"https://moviedb-imageupload.s3.eu-north-1.amazonaws.com/f18f44cf-9547-410a-9919-bdc710f179b2",
					"SEUXfv87Wpk", 2019);
			Movie movie6 = new Movie("Intouchables",
					"After he becomes a quadriplegic from a paragliding accident, an aristocrat hires a young man from the projects to be his caregiver.",
					"https://moviedb-imageupload.s3.eu-north-1.amazonaws.com/b286fc0a-beeb-414d-9ec5-130bd1f8f7df",
					"34WIbmXkewU", 2012);
			Movie movie7 = new Movie("Spider-Man: Into the Spider-Verse",
					"Teen Miles Morales becomes the Spider-Man of his universe, and must join with five spider-powered individuals from other dimensions to stop a threat for all realities.",
					"https://moviedb-imageupload.s3.eu-north-1.amazonaws.com/1ff0b7d8-16ad-4595-905d-d568c6ccd4eb",
					"g4Hbz2jLxvQ", 2018);
			Movie movie8 = new Movie("The Wolf of Wall Street",
					"Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.",
					"https://moviedb-imageupload.s3.eu-north-1.amazonaws.com/93d7a1f9-6d4c-4047-8327-0b87b006d308",
					"iszwuX1AK6A", 2013);

			movieRepository.save(movie1);
			movieRepository.save(movie2);
			movieRepository.save(movie3);
			movieRepository.save(movie4);
			movieRepository.save(movie5);
			movieRepository.save(movie6);
			movieRepository.save(movie8);
			movieRepository.save(movie7);

			Review review1 = new Review("John", "A very good movie.", new Date(), 5, movie1);
			Review review2 = new Review("Jake", "A very interesting movie.", new Date(), 4, movie1);
			Review review3 = new Review("Adam", "Fantastic.", new Date(), 3, movie2);
			Review review4 = new Review("Jake", "The best movie ever.", new Date(), 5, movie2);
			Review review5 = new Review("Jesus",
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque in tincidunt erat. Suspendisse ultricies vel urna in auctor. Mauris velit lacus, tristique eget odio sed, congue molestie massa.",
					new Date(), 5, movie1);
			Review review6 = new Review("Jack",
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque in tincidunt erat. Suspendisse ultricies vel urna in auctor. Mauris velit lacus, tristique eget odio sed, congue molestie massa.",
					new Date(), 5, movie2);
			Review review7 = new Review("Mike",
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque in tincidunt erat. Suspendisse ultricies vel urna in auctor. Mauris velit lacus, tristique eget odio sed, congue molestie massa.",
					new Date(), 5, movie3);
			Review review8 = new Review("Jack",
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque in tincidunt erat. Suspendisse ultricies vel urna in auctor. Mauris velit lacus, tristique eget odio sed, congue molestie massa.",
					new Date(), 5, movie2);
			Review review9 = new Review("Tom",
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque in tincidunt erat. Suspendisse ultricies vel urna in auctor. Mauris velit lacus, tristique eget odio sed, congue molestie massa.",
					new Date(), 5, movie3);
			Review review10 = new Review("Leonardo",
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque in tincidunt erat. Suspendisse ultricies vel urna in auctor. Mauris velit lacus, tristique eget odio sed, congue molestie massa.",
					new Date(), 3, movie3);
			Review review11 = new Review("Kate",
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque in tincidunt erat. Suspendisse ultricies vel urna in auctor. Mauris velit lacus, tristique eget odio sed, congue molestie massa.",
					new Date(), 3, movie4);
			Review review12 = new Review("Emily",
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque in tincidunt erat. Suspendisse ultricies vel urna in auctor. Mauris velit lacus, tristique eget odio sed, congue molestie massa.",
					new Date(), 4, movie4);
			Review review13 = new Review("Emily",
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque in tincidunt erat. Suspendisse ultricies vel urna in auctor. Mauris velit lacus, tristique eget odio sed, congue molestie massa.",
					new Date(), 4, movie5);
			Review review14 = new Review("Katlyn",
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque in tincidunt erat. Suspendisse ultricies vel urna in auctor. Mauris velit lacus, tristique eget odio sed, congue molestie massa.",
					new Date(), 5, movie6);
			Review review15 = new Review("Katlyn",
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque in tincidunt erat. Suspendisse ultricies vel urna in auctor. Mauris velit lacus, tristique eget odio sed, congue molestie massa.",
					new Date(), 4, movie8);
			Review review16 = new Review("Jennifer",
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque in tincidunt erat. Suspendisse ultricies vel urna in auctor. Mauris velit lacus, tristique eget odio sed, congue molestie massa.",
					new Date(), 5, movie8);

			reviewRepository.save(review1);
			reviewRepository.save(review2);
			reviewRepository.save(review3);
			reviewRepository.save(review4);
			reviewRepository.save(review5);
			reviewRepository.save(review6);
			reviewRepository.save(review7);
			reviewRepository.save(review8);
			reviewRepository.save(review9);
			reviewRepository.save(review10);
			reviewRepository.save(review11);
			reviewRepository.save(review12);
			reviewRepository.save(review13);
			reviewRepository.save(review14);
			reviewRepository.save(review15);
			reviewRepository.save(review16);
		};
	}

}
