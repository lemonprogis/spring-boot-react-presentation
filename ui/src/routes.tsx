import * as React from 'react';
import {Route, Switch} from "react-router";
import {BrowserRouter} from "react-router-dom";
import MainPage from "./components/MainPage/MainPage";

export default () => {
    return (
        <BrowserRouter>
            <Switch>
                <Route path={'/'} exact={true} component={MainPage}/>
            </Switch>
        </BrowserRouter>
    )
}