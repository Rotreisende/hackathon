import React from "react";
import {FormInput} from "../component/form/form-input";
import {FormInputType} from "../enum/form-input-type";
import {FormButton} from "../component/form/form-button";
import './registration.css';
import axios from "axios";
import {RequestService} from "../service/RequestService";
import {AuthService} from "../service/AuthService";

export class Registration extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            email: '',
            name: '',
            phoneNumber: '',
            password: ''
        }
    }

    changeEmailHandler(value) {
        this.setState({email: value});
    }

    changeNameHandler(value) {
        this.setState({name: value});
    }

    changePhoneNumberHandler(value) {
        this.setState({phoneNumber: value});
    }

    changePasswordHandler(value) {
        this.setState({password: value});
    }

    submitHandler(e) {
        e.preventDefault();
        RequestService
            .getInstance()
            .post(
                RequestService.API_URL + '/auth/registration',
                {
                    email: this.state.email,
                    name: this.state.name,
                    phoneNumber: this.state.phoneNumber,
                    password: this.state.password
                }
            )
            .then(response => AuthService.saveAccess(response))
            .catch(error => console.log(error));
    }

    render() {
        return (
            <form className={'registration'} onSubmit={(e) => this.submitHandler(e)}>
                <h3 className={'registration__title'}>Регистрация</h3>
                <FormInput type={FormInputType.TEXT} title={'Название'} value={this.state.name} changeHandler={(value) => this.changeNameHandler(value)}/>
                <FormInput type={FormInputType.EMAIL} title={'Электронная почта'} value={this.state.email} changeHandler={(value) => this.changeEmailHandler(value)}/>
                <FormInput type={FormInputType.PASSWORD} title={'Пароль'} value={this.state.password} changeHandler={(value) => this.changePasswordHandler(value)}/>
                <FormInput type={FormInputType.PHONE} title={'Телефон'} value={this.state.phoneNumber} changeHandler={(value) => this.changePhoneNumberHandler(value)}/>
                <FormButton text={'Зарегистрироваться'} isSubmitButton={true}/>
            </form>
        );
    }
}