import React from "react"
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom"
import "./bootstrap/bootstrap.min.css"
import AppBar from "./components/AppBar"

const App = () => {
  return (
    <Router>
      <div>
        <AppBar />
        <Link to="/movie/1">Movie</Link>
      </div>
      <Switch>
        <Route path="/movie/:id">MoviePage</Route>
        <Route path="/">MovieList</Route>
      </Switch>
    </Router>
  )
}

export default App
