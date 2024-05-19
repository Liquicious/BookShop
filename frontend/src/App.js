import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import BookView from './book/BookView';


class App extends Component {
  render() {
    return (
        <Router>
          <Routes>
            <Route path='/' exact={true} element={<Home/>}/>
            <Route path='/book' exact={true} element={<BookView/>}/>
          </Routes>
        </Router>
    )
  }
}

export default App;