import React from "react"
import { Badge, Card, CardDeck, Container } from "react-bootstrap"
import { Link } from "react-router-dom"
import { averageRating } from "../utils"

const MovieCard = ({ movie }) => {
  const rating = averageRating(movie.reviews)
  return (
    <Card style={{ flex: 1, minWidth: "30%", maxWidth: "30%", margin: 10 }}>
      <Link style={{ textDecoration: "none" }} to={`/movies/${movie.movieId}`}>
        <Card.Img src={movie.imgUrl} alt="Poster" />
      </Link>
      <Card.Body className="d-flex justify-content-between">
        <div>
          <Link
            style={{ textDecoration: "none" }}
            to={`/movies/${movie.movieId}`}
          >
            <Card.Title>{movie.title}</Card.Title>
          </Link>
          <Card.Subtitle className="text-muted">
            {movie.publicationYear}
          </Card.Subtitle>
        </div>
        <Card.Text
          style={{ fontSize: 20 }}
          className="d-flex align-items-center"
        >
          {rating ? (
            <Badge pill variant="warning p-2">{`${rating} / 5.0`}</Badge>
          ) : (
            <Badge pill variant="warning p-2">
              No rating
            </Badge>
          )}
        </Card.Text>
      </Card.Body>
    </Card>
  )
}

const MovieList = ({ movies }) => {
  const movieRows = movies.map((movie) => (
    <MovieCard key={movie.movieId} movie={movie} />
  ))

  return (
    <Container>
      <CardDeck style={{ padding: 20 }}>{movieRows}</CardDeck>
    </Container>
  )
}

export default MovieList
