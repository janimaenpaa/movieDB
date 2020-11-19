package swd20.movieDB.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import swd20.movieDB.domain.Movie;
import swd20.movieDB.domain.MovieRepository;
import swd20.movieDB.domain.Review;
import swd20.movieDB.domain.ReviewRepository;

@CrossOrigin
@RestController
public class ReviewRESTController {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/api/reviews")
    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    @GetMapping("/api/reviews/{id}")
    public Optional<Review> getReviewById(@PathVariable("id") long id) {
        return reviewRepository.findById(id);
    }

    @GetMapping("/api/movies/{id}/reviews")
    public List<Review> getReviewsByMovie(@PathVariable("id") long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return (List<Review>) reviewRepository.findByMovie(movie);
    }

    @PostMapping(value = "/api/movies/{id}/reviews")
    public Review saveReview(@PathVariable("id") long id, @RequestBody Review review) {
        Movie movie = movieRepository.findById(id).orElse(null);
        review.setMovie(movie);
        return reviewRepository.save(review);
    }

}
