import React from "react"
import { Card, CardGroup, Badge } from "react-bootstrap"
import YouTube from "react-youtube"
import { averageRating } from "../utils"

const getRating = (rating) => {
  if (!rating) {
    return <span style={{ fontSize: 18, padding: 4 }}>No rating</span>
  }

  return <span style={{ fontSize: 18, padding: 4 }}>{rating} / 5.0</span>
}

const InfoCard = ({ movie, rating }) => {
  return (
    <CardGroup>
      <Card style={{ flexGrow: 2 }}>
        <Card.Img src={movie.imgUrl} style={{ height: "100%" }} />
      </Card>
      <Card style={{ flexGrow: 3 }}>
        <Card.Body>
          <Card.Title>
            <h3 style={{ color: "#00bc8c" }}>
              {movie.title} ({movie.publicationYear})
            </h3>
          </Card.Title>
          <Card.Text>
            <Badge pill variant="warning">
              {getRating(rating)}
            </Badge>
          </Card.Text>
          <YouTube videoId={movie.trailerYoutubeId} opts={{ width: "100%" }} />
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

export default InfoCard
