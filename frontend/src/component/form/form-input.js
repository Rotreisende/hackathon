import './form-input.css';

export const FormInput = ({title, changeHandler, value, type}) => {

    const innerChangeHandler = (e) => {
        const target = e.target;
        changeHandler(target.value);
    }

    return (
        <label className={['form-input', value.length > 0 ? 'form-input_filled' : ''].join(' ')}>
            <span className={'form-input__title'}>{title}</span>
            <input
                type={type}
                className={'form-input__input'}
                onInput={e => innerChangeHandler(e)}
                value={value}
            />
            <fieldset className={'form-input__fieldset'}>
                <legend className={'form-input__fieldset__legend'}>{title}</legend>
            </fieldset>
        </label>
    );
}