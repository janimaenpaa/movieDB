package swd20.movieDB.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long movieId;
	private String title, description, imgUrl, trailerLink;
	private int publicationYear;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
	@JsonIgnoreProperties("movie")
	private List<Review> reviews;

	public Movie() {
	}

	public Movie(long movieId, String title, String description, String imgUrl, String trailerLink, int publicationYear,
			List<Review> reviews) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.description = description;
		this.imgUrl = imgUrl;
		this.trailerLink = trailerLink;
		this.publicationYear = publicationYear;
		this.reviews = reviews;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getTrailerLink() {
		return trailerLink;
	}

	public void setTrailerLink(String trailerLink) {
		this.trailerLink = trailerLink;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", description=" + description + ", imgUrl=" + imgUrl
				+ ", publicationYear=" + publicationYear + "]";
	}

}
