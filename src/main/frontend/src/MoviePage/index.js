import React, { useEffect, useState } from "react"
import {
  Container
} from "react-bootstrap"
import { useParams } from "react-router-dom"
import InfoCard from "./InfoCard"

import ReviewCard from "./ReviewCard"

const MoviePage = () => {
  const [movie, setMovie] = useState(null)
  const { id } = useParams()

  useEffect(() => {
    fetch(`http://localhost:8080/api/movies/${id}`)
      .then((response) => response.json())
      .then((data) => {
        console.log(data)
        setMovie(data)
      })
  }, [id])

  if (!movie) return <Container fluid>Movie not found...</Container>

  return (
    <Container>
      <InfoCard movie={movie} />
      <ReviewCard movie={movie} />
    </Container>
  )
}

export default MoviePage
