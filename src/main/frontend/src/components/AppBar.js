import React from "react"
import { Button, Navbar } from "react-bootstrap"
import { Link } from "react-router-dom"

const AppBar = () => {
  return (
    <Navbar bg="dark" expand="true" variant="dark mb-4">
      <Navbar.Brand className="d-inline-block align-top">
        <Link style={{ color: "#fff", textDecoration: "none" }} to="/">
          MovieDB
        </Link>
      </Navbar.Brand>
      <Button className="d-inline-block align-top" variant="secondary">
        <a style={{ color: "#fff", textDecoration: "none" }} href="#">
          Admin
        </a>
      </Button>
    </Navbar>
  )
}

export default AppBar
