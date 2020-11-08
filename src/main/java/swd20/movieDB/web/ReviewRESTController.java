package swd20.movieDB.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import swd20.movieDB.domain.Review;
import swd20.movieDB.domain.ReviewRepository;

@CrossOrigin
@Controller
public class ReviewRESTController {

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/api/reviews")
    public @ResponseBody List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    @GetMapping("/api/reviews/{id}")
    public @ResponseBody Optional<Review> getReviewById(@PathVariable("id") long id) {
        return reviewRepository.findById(id);
    }
}
