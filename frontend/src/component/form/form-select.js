import React from "react";
import './form-select.css';
import {FormSelectOption} from "./form-select-option";

export class FormSelect extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            active: false
        }
    }

    documentClickEventListener(e) {
        const target = e.target;
        if (!target.closest('.form-select') && this.state.active) {
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
        this.props.changeHandler(option);
        this.clickSelectHandler();
    }

    clickSelectHandler() {
        if (!this.props.disabled)
            this.setState({active: !this.state.active});
    }

    render() {
        return (
            <div className={['form-select', this.state.active ? 'form-select_active' : '', !!this.props.value ? 'form-select_filled' : ''].join(' ')}>
                <div className={'form-select__form'} onClick={() => this.clickSelectHandler()}>
                    <span className={'form-select__form__title'}>{this.props.title}</span>
                    {
                        this.props.value?.title
                            ?   <div className={'form-select__form__value'}>{this.props.value?.title}</div>
                            :   <div className={'form-select__form__value'}></div>
                    }
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
                                this.props.options.map((option) =>
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