import React from "react"
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom"

const App = () => {
  return (
    <Router>
      <div>
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
