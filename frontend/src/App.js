import React from "react";
import {RequestForm} from "./component/request/request-form";
import {RequestPage} from "./page/request-page";
import {Header} from "./component/header/header";
import {BrowserRouter, Route, Switch} from "react-router-dom";
import {Home} from "./page/home";

class App extends React.Component {

    render() {
        return (
            <BrowserRouter>
                <Header/>
                <Switch>
                    <Route path={'/create-request'} component={RequestForm}/>
                    <Route path={'/requests/:id'} component={RequestPage}/>
                    <Route path={'/'} component={Home}/>
                </Switch>
            </BrowserRouter>
        );
    }
}

export default App;
