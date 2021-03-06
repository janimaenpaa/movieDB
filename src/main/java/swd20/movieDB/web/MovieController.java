package swd20.movieDB.web;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import swd20.movieDB.aws.AWSS3Service;
import swd20.movieDB.domain.Movie;
import swd20.movieDB.domain.MovieRepository;
import swd20.movieDB.domain.ReviewRepository;

@Controller
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private AWSS3Service s3Service;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	// See all movies
	@GetMapping("/")
	public String movieList(Model model) {
		model.addAttribute("movies", movieRepository.findAll());
		return "movies";
	}

	// See a single movie
	@GetMapping("/movies/{id}")
	public String moviePage(@PathVariable("id") long movieId, Model model) {
		Optional<Movie> movie = movieRepository.findById(movieId);

		if (movie != null) {
			model.addAttribute("movie", movie.get());
			model.addAttribute("reviews", reviewRepository.findByMovie(movie));
		}

		return "movie";
	}

	// Delete movie by id
	@GetMapping("/movies/{id}/delete")
	public String deleteMovie(@PathVariable("id") long movieId) {
		movieRepository.deleteById(movieId);
		return "redirect:/";
	}

	// Edit movie by id
	@GetMapping("/movies/{id}/edit")
	public String editMovie(@PathVariable("id") long movieId, Model model) {
		model.addAttribute("movie", movieRepository.findById(movieId));
		return "editmovie";
	}

	// Create new movie
	@GetMapping("/movies/new")
	public String newMovie(Model model) {
		model.addAttribute("movie", new Movie());
		return "newmovie";
	}

	// Save created movie
	@PostMapping("/movies/save")
	public String saveMovie(@RequestParam("image") MultipartFile image, @Valid Movie movie,
			BindingResult bindingResult) {
		String mockPosterUrl = "https://moviedb-imageupload.s3.eu-north-1.amazonaws.com/4d025af0-d350-4e9e-9d03-b15ccec4f195";

		if (bindingResult.hasErrors()) {
			return "newmovie";
		}

		if (!image.isEmpty()) {
			String uploadedImageUrl = s3Service.uploadImage(image);
			movie.setImgUrl(uploadedImageUrl);
		} else {
			movie.setImgUrl(mockPosterUrl);
		}

		movieRepository.save(movie);
		return "redirect:/";
	}

	// Update a movie
	@PostMapping("/movies/update")
	public String updateMovie(@Valid Movie movie, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "editmovie";
		}

		movieRepository.save(movie);
		return "redirect:/movies/" + movie.getMovieId();
	}

	@GetMapping("/movies/{id}/reviews/{reviewId}")
	public String deleteReview(@PathVariable("id") long movieId, @PathVariable("reviewId") long reviewId) {
		reviewRepository.deleteById(reviewId);
		return "redirect:/movies/" + String.valueOf(movieId);
	}
}
