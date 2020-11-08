package swd20.movieDB.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import swd20.movieDB.domain.Movie;
import swd20.movieDB.domain.MovieRepository;

@CrossOrigin
@Controller
public class MovieRESTController {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@GetMapping("/api/movies")
	public @ResponseBody List<Movie> getMovies() {
		return movieRepository.findAll();
	}

	@GetMapping("/api/movies/{id}")
	public @ResponseBody Optional<Movie> getMovieById(@PathVariable("id") long id) {
		return movieRepository.findById(id);
	}

}
