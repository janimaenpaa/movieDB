package swd20.movieDB.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull
	@Size(min = 2, max = 80, message = "Reviewer must be between 1 and 80 characters")
	private String reviewer;
	
	@NotNull
	@Size(min = 10, max = 400, message = "Review must be between 10 and 400 characters")
	@Column(columnDefinition = "TEXT")
	private String description;

	private Date date;

	@NotNull
	@Min(value = 1, message = "Rating can't be lower than 1")
	@Max(value = 5, message = "Rating can't be higher than 5")
	private int rating;
	
	@ManyToOne
	@JsonIgnoreProperties("reviews")
	@JoinColumn(name = "movieId")
	private Movie movie;

	public Review() {
	}

	public Review(String reviewer, String description, Date date, int rating, Movie movie) {
		super();
		this.reviewer = reviewer;
		this.description = description;
		this.date = date;
		this.rating = rating;
		this.movie = movie;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", reviewer=" + reviewer + ", description=" + description + ", date=" + date + "]";
	}

}
