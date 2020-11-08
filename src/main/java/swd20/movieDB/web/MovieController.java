package swd20.movieDB.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import swd20.movieDB.domain.Movie;
import swd20.movieDB.domain.MovieRepository;
import swd20.movieDB.domain.Review;
import swd20.movieDB.domain.ReviewRepository;

@Controller
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private ReviewRepository reviewRepository;

	@GetMapping("/movies")
	public String movieList(Model model) {
		model.addAttribute("movies", movieRepository.findAll());
		return "movies";
	}

	@GetMapping("/movies/{id}")
	public String moviePage(@PathVariable("id") long movieId, Model model) {
		Optional<Movie> movie = movieRepository.findById(movieId);

		if (movie != null) {
			model.addAttribute("movie", movie.get());
			model.addAttribute("reviews", reviewRepository.findByMovie(movie));
		}

		return "movie";
	}

	@GetMapping("/movies/{id}/delete")
	public String deleteMovie(@PathVariable("id") long movieId) {
		movieRepository.deleteById(movieId);
		return "redirect:/movies";
	}

	@GetMapping("/movies/{id}/edit")
	public String editMovie(@PathVariable("id") long movieId, Model model) {
		model.addAttribute("movie", movieRepository.findById(movieId));
		return "editmovie";
	}

	@GetMapping("/movies/new")
	public String newMovie(Model model) {
		model.addAttribute("movie", new Movie());
		return "newmovie";
	}

	@PostMapping("/movies/save")
	public String saveMovie(Movie movie) {
		movieRepository.save(movie);
		return "redirect:/movies";
	}
}
