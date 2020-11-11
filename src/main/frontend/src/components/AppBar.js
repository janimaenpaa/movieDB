import React from "react"
import { Navbar } from "react-bootstrap"
import { Link } from "react-router-dom"

const AppBar = () => {
  return (
    <Navbar bg="dark" variant="dark mb-2">
      <Navbar.Brand className="d-inline-block align-top">
        <Link style={{ color: "#fff", textDecoration: "none" }} to="/">
          MovieDB
        </Link>
      </Navbar.Brand>
    </Navbar>
  )
}

export default AppBar
