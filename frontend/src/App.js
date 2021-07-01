import React from 'react';
import ListEmployee from "./component/ListEmployee";
import CreateEmployee from "./component/CreateEmployee";
import {BrowserRouter as Router, Switch,Route} from 'react-router-dom';
import UpdateEmployee from './component/UpdateEmployee';

//route paths
function App() {
  return (
    <div>

    <Router>
    <div className="container">
      <Switch>
        <Route path="/" exact component= {ListEmployee}></Route>
        <Route path="/employees"  component= {ListEmployee}></Route>
        <Route path="/createemployee" component={CreateEmployee}></Route>
        <Route path="/updateemployee/:id" component={UpdateEmployee}></Route>
        <Route path="/viewemployee/:id" component={viewEmployee}></Route>
      </Switch>
    </div>
    </Router>
    </div>

  );
}

export default App;