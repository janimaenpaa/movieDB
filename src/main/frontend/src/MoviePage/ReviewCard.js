import React from "react"
import { Card, ListGroup, Button } from "react-bootstrap"

const ReviewCard = ({ reviews }) => {
  const reviewRows = reviews.map((review) => (
    <ListGroup.Item key={review.id} className="d-flex flex-column">
      <span className="h5">{review.reviewer}</span>
      <Button
        disabled
        style={{ width: "4rem", backgroundColor: "#f39c12", opacity: 100 }}
      >
        {review.rating} / 5
      </Button>
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
          {reviews.length === 0 ? (
            <div>No reviews yet...</div>
          ) : (
            <ListGroup variant="flush">{reviewRows}</ListGroup>
          )}
        </Card.Body>
      </Card>
    </div>
  )
}

export default ReviewCard
