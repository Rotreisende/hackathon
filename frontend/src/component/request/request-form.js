import React from "react";
import {FormTextarea} from "../form/form-textarea";
import {FormInput} from "../form/form-input";
import {FormInputType} from "../../enum/form-input-type";
import {FormSelect} from "../form/form-select";
import './request-form.css';
import {FormButton} from "../form/form-button";
import axios from "axios";
import {RequestService} from "../../service/RequestService";
import {PaymentMethod} from "../../enum/payment-method";

export class RequestForm extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            name: '',
            code: '',
            sum: '',
            count: '',
            units: '',
            paymentMethod: null,
            regions: [],
            region: null
        }
    }

    componentDidMount() {
        axios.get(RequestService.API_URL + 'regions')
            .then(response => this.setState({regions: response.data}))
            .catch(error => console.log(error));
    }

    changeNameHandler(value) {
        this.setState({name: value});
    }

    changeCodeHandler(value) {
        this.setState({code: value});
    }

    changeSumHandler(value) {
        this.setState({sum: value});
    }

    changeCountHandler(value) {
        this.setState({count: value});
    }

    changeUnitsHandler(value) {
        this.setState({units: value});
    }

    changePaymentMethodHandler(value) {
        this.setState({paymentMethod: value});
    }

    changeRegionHandler(value) {
        this.setState({region: value});
    }

    submitHandler(e) {
        e.preventDefault();
        axios.post(
            RequestService.API_URL + 'requests',
            {
                name: this.state.name,
                code: this.state.code,
                sum: this.state.sum,
                count: this.state.count,
                units: this.state.units,
                paymentMethod: this.state.paymentMethod.id,
                region: this.state.region.code
            }
        )
            .then(response => this.props.history.push('/requests/' + response.data))
            .catch(error => console.log(error));
    }

    render() {
        return (
            <form className="request-form" onSubmit={(e) => this.submitHandler(e)}>
                <h3 className={'request-form__title'}>Техническое задание</h3>
                <FormTextarea value={this.state.name} changeHandler={(value) => this.changeNameHandler(value)}
                              title={'Товар'}/>
                <FormInput title={'ОКПД2'} type={FormInputType.TEXT}
                           changeHandler={(value) => this.changeCodeHandler(value)} value={this.state.code}/>
                <FormInput title={'Сумма'} type={FormInputType.TEXT}
                           changeHandler={(value) => this.changeSumHandler(value)} value={this.state.sum}/>
                <FormInput title={'Количество'} type={FormInputType.TEXT}
                           changeHandler={(value) => this.changeCountHandler(value)} value={this.state.count}/>
                <FormInput title={'Единицы измерения'} type={FormInputType.TEXT}
                           changeHandler={(value) => this.changeUnitsHandler(value)} value={this.state.units}/>
                <FormSelect title={'Способ оплаты'} value={this.state.paymentMethod}
                            options={[{id: PaymentMethod.FZ_44.api, title: PaymentMethod.FZ_44.view}, {id: PaymentMethod.FZ_223.api, title: PaymentMethod.FZ_223.view}]}
                            changeHandler={(option) => this.changePaymentMethodHandler(option)}/>
                <FormSelect title={'Регион'} value={this.state.region}
                            options={this.state.regions}
                            changeHandler={(option) => this.changeRegionHandler(option)}/>
                <FormButton text={'Найти изготовителей'} isSubmitButton={true}/>
            </form>
        )
    }
}