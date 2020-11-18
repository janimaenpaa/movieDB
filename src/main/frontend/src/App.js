import React, { useEffect, useState } from "react"
import { BrowserRouter as Router, Switch, Route } from "react-router-dom"
import "./bootstrap/bootstrap.min.css"
import AppBar from "./components/AppBar"
import MovieList from "./MovieList"
import MoviePage from "./MoviePage"

const App = () => {
  const [movies, setMovies] = useState([])

  useEffect(() => {
    fetch("http://localhost:8080/api/movies")
      .then((response) => response.json())
      .then((data) => {
        setMovies(data)
      })
  }, [])

  return (
    <Router>
      <>
        <AppBar />
      </>
      <Switch>
        <Route path="/movies/:id">
          <MoviePage movies={movies} />
        </Route>
        <Route path="/">
          <MovieList movies={movies} />
        </Route>
      </Switch>
    </Router>
  )
}

export default App
