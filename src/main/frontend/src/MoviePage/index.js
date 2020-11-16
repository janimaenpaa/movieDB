import React, { useEffect, useState } from "react"
import { Card, Container, CardGroup, ListGroup, Badge } from "react-bootstrap"
import { useParams } from "react-router-dom"
import YouTube from "react-youtube"
import poster from "../poster.jpg"
import { averageRating } from "../utils"

const InfoCard = ({ movie }) => {
  const rating = averageRating(movie.reviews)
  return (
    <CardGroup>
      <Card style={{ flexGrow: 2 }}>
        <Card.Img src={poster} style={{ height: "100%" }} />
      </Card>
      <Card style={{ flexGrow: 3 }}>
        <Card.Body>
          <Card.Title>
            <h3 style={{ color: "#00bc8c" }}>
              {movie.title} ({movie.publicationYear})
            </h3>
          </Card.Title>
          <Card.Text>
            <Badge pill variant="warning p-2">
              <span style={{ fontSize: 20 }}>{rating} / 5.0</span>
            </Badge>
          </Card.Text>
          <YouTube videoId={movie.trailerUrl} opts={{ width: "100%" }} />
          <Card.Subtitle
            style={{ fontSize: "1rem", color: "#999999" }}
            className="mt-2 mb-2"
          >
            {movie.description}
          </Card.Subtitle>
        </Card.Body>
      </Card>
    </CardGroup>
  )
}

const ReviewCard = ({ movie }) => {
  const reviewRows = movie.reviews.map((review) => (
    <ListGroup.Item className="d-flex flex-column">
      <span className="h5">{review.reviewer}</span>
      <span>{review.rating} / 5</span>
      <span>{review.description}</span>
    </ListGroup.Item>
  ))
  return (
    <div className="mt-4 mb-4">
      <Card style={{ padding: 20 }}>
        <Card.Header>
          <h4>Reviews</h4>
        </Card.Header>
        <Card.Body>
          <ListGroup variant="flush">{reviewRows}</ListGroup>
        </Card.Body>
      </Card>
    </div>
  )
}

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
