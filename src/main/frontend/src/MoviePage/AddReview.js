import React, { useState } from "react"
import { Button, Card, Form } from "react-bootstrap"

const AddReview = ({ reviews, setReviews, id }) => {
  const [reviewer, setReviewer] = useState("")
  const [rating, setRating] = useState(5)
  const [review, setReview] = useState("")

  const handleSubmit = (event) => {
    event.preventDefault()

    const body = { reviewer, rating, description: review }
    console.log(body)

    const requestOptions = {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(body),
    }

    fetch(`http://localhost:8080/api/movies/${id}/reviews`, requestOptions)
      .then((response) => response.json())
      .then((result) => {
        console.log("Success:", result)
        setReviews([...reviews, result])
        setReview("")
        setReviewer("")
      })
      .catch((error) => console.error("Error:", error))
  }

  return (
    <Card className="p-4 mb-4">
      <Card.Header className="mb-3">
        <h4>Add a Review</h4>
      </Card.Header>
      <Form onSubmit={handleSubmit}>
        <Form.Label>Reviewer</Form.Label>
        <Form.Control
          className="mb-3"
          type="text"
          placeholder="Your name..."
          value={reviewer}
          onChange={(event) => setReviewer(event.target.value)}
        />
        <Form.Label>Rating</Form.Label>
        <Form.Control
          className="mb-3"
          as="select"
          value={rating}
          onChange={(event) => setRating(event.target.value)}
        >
          <option>5</option>
          <option>3</option>
          <option>4</option>
          <option>2</option>
          <option>1</option>
        </Form.Control>
        <Form.Label>Review</Form.Label>
        <Form.Control
          className="mb-3"
          type="text"
          as="textarea"
          rows={4}
          placeholder="Type your review here..."
          value={review}
          name="review"
          onChange={(event) => setReview(event.target.value)}
        />
        <Button variant="success" type="submit" style={{ width: "100%" }}>
          Submit
        </Button>
      </Form>
    </Card>
  )
}

export default AddReview
