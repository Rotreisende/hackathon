import './form-button.css';

export const FormButton = ({text, icon, isSubmitButton = false, className}) => {
    const content = <span className={'form-button__text'}>{text}</span>

    if (isSubmitButton)
        return <button className={className ? ['form-button', className].join(' ') : 'form-button'}>{content}</button>;
    else
        return <div className={className ? ['form-button', className].join(' ') : 'form-button'}>{content}</div>;
}