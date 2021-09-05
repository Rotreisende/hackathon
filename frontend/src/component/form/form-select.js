import React from "react";
import './form-select.css';
import {FormSelectOption} from "./form-select-option";

export class FormSelect extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            active: false,
            input: '',
            options: []
        }
        this.ref = React.createRef();
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        if (prevProps.options !== this.props.options) {
            this.setState({options: this.props.options});
        }
    }

    documentClickEventListener(e) {
        const target = e.target;
        if (target.closest('.form-select') !== this.ref.current && this.state.active) {
            this.clickSelectHandler();
        }
    }

    componentDidMount() {
        document.addEventListener('click', this.documentClickEventListener.bind(this));
    }

    componentWillUnmount() {
        document.removeEventListener('click', this.documentClickEventListener.bind(this));
    }

    clickOptionHandler(option) {
        this.setState({input: option ? option.title : ''});
        this.props.changeHandler(option);
        this.clickSelectHandler();
    }

    changeInputHandler(e) {
        this.setState({
            input: e.target.value,
            options: this.props.options.filter(option => option.title.toLowerCase().startsWith(e.target.value.toLowerCase()))
        });
    }

    clickSelectHandler() {
        if (!this.props.disabled)
            this.setState({active: !this.state.active}, () => {
                if (!this.state.active)
                    this.ref.current.getElementsByClassName('form-select__form__value')[0].blur();
                else
                    this.ref.current.getElementsByClassName('form-select__form__value')[0].focus();
            });
    }

    render() {
        return (
            <div ref={this.ref} className={['form-select', this.state.active ? 'form-select_active' : '', !!this.state.input ? 'form-select_filled' : ''].join(' ')}>
                <div className={'form-select__form'} onClick={() => this.clickSelectHandler()}>
                    <span className={'form-select__form__title'}>{this.props.title}</span>
                    <input onInput={(e) => this.changeInputHandler(e)} className={'form-select__form__value'} value={this.state.input}/>
                    <fieldset className={'form-select__form__fieldset'}>
                        <legend className={'form-select__form__fieldset__legend'}>{this.props.title}</legend>
                    </fieldset>
                </div>
                {
                    !this.props.disabled && this.state.active
                        ? <div className={'form-select__options'}>
                            <FormSelectOption
                                clickHandler={(option) => this.clickOptionHandler(option)}
                            />
                            {
                                this.state.options.map((option) =>
                                    <FormSelectOption
                                        value={option}
                                        key={option.id}
                                        clickHandler={(option) => this.clickOptionHandler(option)}
                                    />
                                )
                            }
                        </div>
                        : null
                }
            </div>
        );
    }
}