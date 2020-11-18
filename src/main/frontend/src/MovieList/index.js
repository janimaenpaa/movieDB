import React from "react"
import { CardDeck, Container } from "react-bootstrap"
import MovieCard from "./MovieCard"

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
