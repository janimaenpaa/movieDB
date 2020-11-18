import React, { useEffect, useState } from "react"
import { Container } from "react-bootstrap"
import { useParams } from "react-router-dom"
import { averageRating } from "../utils"
import AddReview from "./AddReview"
import InfoCard from "./InfoCard"

import ReviewCard from "./ReviewCard"

const MoviePage = () => {
  const [movie, setMovie] = useState(null)
  const [reviews, setReviews] = useState([])
  const { id } = useParams()
  const [movieRating, setMovieRating] = useState()

  useEffect(() => {
    fetch(`http://localhost:8080/api/movies/${id}`)
      .then((response) => response.json())
      .then((data) => {
        console.log(data)
        setMovie(data)
        setReviews(data.reviews)
      })
  }, [id])

  useEffect(() => {
    setMovieRating(averageRating(reviews))
  }, [reviews])

  if (!movie) return <Container fluid>Movie not found...</Container>

  return (
    <Container>
      <InfoCard movie={movie} rating={movieRating} />
      <ReviewCard reviews={reviews} />
      <AddReview reviews={reviews} setReviews={setReviews} id={id} />
    </Container>
  )
}

export default MoviePage
