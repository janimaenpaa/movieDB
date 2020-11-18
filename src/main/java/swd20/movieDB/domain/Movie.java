package swd20.movieDB.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long movieId;

	@NotNull
	@Size(min = 1, max = 500, message = "Description must be between 1 and 500 characters")
	@Column(columnDefinition = "TEXT")
	private String description;

	@NotNull
	@Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
	private String title;

	private String imgUrl, trailerYoutubeId;

	@NotNull
	@Min(value = 1850, message = "The year must be higher than 1849")
	@Max(value = 2021, message = "The year must be lower than 2022")
	private int publicationYear;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
	@JsonIgnoreProperties("movie")
	private List<Review> reviews;

	public Movie() {
	}

	public Movie(String title, String description, String imgUrl, String trailerYoutubeId, int publicationYear) {
		super();
		this.title = title;
		this.description = description;
		this.imgUrl = imgUrl;
		this.trailerYoutubeId = trailerYoutubeId;
		this.publicationYear = publicationYear;
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

	public String getTrailerYoutubeId() {
		return trailerYoutubeId;
	}

	public void setTrailerYoutubeId(String trailerYoutubeId) {
		this.trailerYoutubeId = trailerYoutubeId;
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
