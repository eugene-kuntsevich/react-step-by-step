import React from 'react';
import './nav.scss';
import {BrowserRouter as Router, Link, Route, Switch,} from "react-router-dom";
import {WelcomePage} from "../welcome/welcom-page";

export const Nav: React.FC<any> = () => {
  return (
      <Router>
        <nav>
          <Link to="/welcome">Welcome</Link>
        </nav>
        <Switch>
          <Route path="/welcome"><WelcomePage/></Route>
        </Switch>
      </Router>)
}

