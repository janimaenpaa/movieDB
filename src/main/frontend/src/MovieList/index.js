import React from "react"
import { CardDeck, Container } from "react-bootstrap"
import { averageRating } from "../utils"
import MovieCard from "./MovieCard"

const MovieList = (props) => {
  const movies = props.movies.sort((a, b) =>
    averageRating(a.reviews) > averageRating(b.reviews) ? -1 : 1
  )

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
