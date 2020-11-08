package swd20.movieDB.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {

	List<Review> findAll();

	List<Review> findByMovie(Optional<Movie> movie);

}
