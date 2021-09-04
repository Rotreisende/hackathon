import {RequestCard} from "../component/request/request-card";
import React from "react";
import axios from "axios";
import {RequestService} from "../service/RequestService";

export class Home extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            requests: []
        }
    }

    componentDidMount() {
        axios.get(
            RequestService.API_URL + 'requests'
        )
            .then(response => this.setState({requests: response.data}))
            .catch(error => console.log(error));
    }

    render() {
        return (
            <div>
                {
                    this.state.requests.map(request => <RequestCard key={request.id} request={request}/>)
                }
            </div>
        )
    }
}