import React from "react";
import {FormInput} from "../component/form/form-input";
import {FormInputType} from "../enum/form-input-type";
import {FormButton} from "../component/form/form-button";
import './login.css';
import {AuthService} from "../service/AuthService";

export class Login extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            email: '',
            password: ''
        }
    }

    changeEmailHandler(value) {
        this.setState({email: value});
    }

    changePasswordHandler(value) {
        this.setState({password: value});
    }

    submitHandler(e) {
        e.preventDefault();
        AuthService
            .login(this.state.email, this.state.password)
            .then(() => this.props.history.push(''))
    }

    render() {
        return (
            <form className={'login'}>
                <h3 className={'login__title'}>Вход</h3>
                <FormInput type={FormInputType.TEXT} title={'Электронная почта'} value={this.state.email} changeHandler={(value) => this.changeEmailHandler(value)}/>
                <FormInput type={FormInputType.PASSWORD} title={'Пароль'} value={this.state.password} changeHandler={(value) => this.changePasswordHandler(value)}/>
                <FormButton text={'Войти'}/>
            </form>
        )
    }
}