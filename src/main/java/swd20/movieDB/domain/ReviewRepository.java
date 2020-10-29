package swd20.movieDB.domain;

import java.util.List;

public interface ReviewRepository {
	
	List<Review> findAll();

}
