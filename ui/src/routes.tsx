import * as React from 'react';
import {Route, Switch} from "react-router";
import {BrowserRouter} from "react-router-dom";
import Index from "./components/MainPage";

export default () => {
    return (
        <BrowserRouter>
            <Switch>
                <Route path={'/'} exact={true} component={Index}/>
            </Switch>
        </BrowserRouter>
    )
}