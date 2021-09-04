import './App.css';
import {FormInput} from "./component/form/form-input";
import {FormTextarea} from "./component/form/form-textarea";
import {FormInputType} from "./enum/form-input-type";
import {FormSelect} from "./component/form/form-select";
import React from "react";

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            product: '',
            code: '',
            sum: '',
            count: '',
            units: '',
            paymentMethod: null
        }
    }

    changeProductHandler(value) {
        this.setState({product: value});
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

    render() {
        return (
            <div className="App">
                <div className={'technical-specification'}>
                    <FormTextarea value={this.state.product} changeHandler={(value) => this.changeProductHandler(value)}
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
                                options={[{id: 0, title: '44 ФЗ'}, {id: 1, title: '223 ФЗ'}]}
                                changeHandler={(option) => this.changePaymentMethodHandler(option)}/>
                </div>
            </div>
        );
    }
}

export default App;
