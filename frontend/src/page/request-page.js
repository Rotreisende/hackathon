import './request-page.css';
import {ProducerCard} from "../component/producer/producer-card";
import {RequestCard} from "../component/request/request-card";
import React from "react";
import axios from "axios";
import {RequestService} from "../service/RequestService";

export class RequestPage extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            request: null
        }
    }

    componentDidMount() {
        axios.get(
            RequestService.API_URL + 'requests/' + this.props.match.params.id
        )
            .then(response => this.setState({request: response.data}))
            .catch(error => console.log(error));
    }

    render() {
        return (
            <div className={'request-page'}>
                <div className={'request-page__header'}>
                    <RequestCard request={this.state.request}/>
                </div>
                <div className={'request-page__manufacturers'}>
                    {
                        !!this.state.request
                            ?   this.state.request.producers.map(producer => <ProducerCard key={producer.id} data={producer}/>)
                            :   null
                    }
                </div>
            </div>
        )
    }
}