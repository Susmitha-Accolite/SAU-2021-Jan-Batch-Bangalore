import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import React from 'react';
import  Todos  from '../components/Todos';
const Routes = () => {
    return (
        <Router>
            <Switch>
                <Route exact path="/" component={Todos} />
            </Switch>
        </Router>
    );
}

export default Routes;