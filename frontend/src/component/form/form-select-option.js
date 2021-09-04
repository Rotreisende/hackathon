import './form-select-option.css';

export const FormSelectOption = ({value, clickHandler}) => {

    return (
        <div className={'form-select-option'} onClick={() => clickHandler(value)}>{value?.title ? value.title : 'не выбрано'}</div>
    );
}