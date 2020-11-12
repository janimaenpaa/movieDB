import React, { useEffect, useState } from "react"
import { Card, Container, CardGroup, ListGroup } from "react-bootstrap"
import { useParams } from "react-router-dom"
import poster from "../poster.jpg"

const InfoCard = ({ movie }) => {
  return (
    <CardGroup>
      <Card>
        <Card.Img src={poster} />
      </Card>
      <Card>
        <Card.Body>
          <Card.Title>
            <h3>
              {movie.title} ({movie.publicationYear})
            </h3>
          </Card.Title>
          <Card.Text>
            <span className="h4">Rating 5.0 / 5.0</span>
          </Card.Text>
          <Card.Subtitle
            style={{ fontSize: 18, color: "#999999" }}
            className="mb-2"
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
    <ListGroup.Item>
      {review.reviewer}
      <br />
      {review.rating} / 5
      <br />
      {review.description}
    </ListGroup.Item>
  ))
  return (
    <div className="mt-4 mb-4">
      <h3>Reviews</h3>
      <Card style={{ padding: 20 }}>
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
