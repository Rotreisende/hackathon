import './form-textarea.css';

export const FormTextarea = ({title, changeHandler, value}) => {
    
    const innerChangeHandler = (e) => {
        const target = e.target;
        changeHandler(target.value);
    }
    
    return (
        <label className={['form-textarea', value.length > 0 ? 'form-textarea_filled' : ''].join(' ')}>
            <span className={'form-textarea__title'}>{title}</span>
            <textarea
                className={'form-textarea__input'}
                onInput={e => innerChangeHandler(e)}
                value={value}
            />
            <fieldset className={'form-textarea__fieldset'}>
                <legend className={'form-textarea__fieldset__legend'}>{title}</legend>
            </fieldset>
        </label>
    )
}