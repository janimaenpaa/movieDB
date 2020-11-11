import React from "react"
import { Navbar } from "react-bootstrap"

const AppBar = () => {
  return (
    <Navbar bg="dark" variant="dark mb-2">
      <Navbar.Brand href="/" className="d-inline-block align-top">
        MovieDB
      </Navbar.Brand>
    </Navbar>
  )
}

export default AppBar
