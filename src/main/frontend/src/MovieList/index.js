import React from "react"
import {
  Card,
  CardDeck,
  CardColumn,
  CardGroup,
  Container,
} from "react-bootstrap"
import { Link } from "react-router-dom"
import poster from "../poster.jpg"

const MovieCard = ({ movie }) => (
  <Card style={{ flex: 1, maxWidth: "30%" }}>
    <Link style={{ textDecoration: "none" }} to={`/movies/${movie.movieId}`}>
      <Card.Img src={poster} alt="Poster" />
      <Card.Body>
        <Card.Title>{movie.title}</Card.Title>
        <Card.Subtitle className="text-muted">
          {movie.publicationYear}
        </Card.Subtitle>
      </Card.Body>
    </Link>
  </Card>
)

const MovieList = ({ movies }) => {
  const movieRows = movies.map((movie) => (
    <MovieCard key={movie.movieId} movie={movie} />
  ))

  return (
    <Container>
      <CardDeck style={{ display: "flex", flexDirection: "row" }}>
        {movieRows}
      </CardDeck>
    </Container>
  )
}

export default MovieList
