import './producer-card.css';

export const ProducerCard = ({data}) => {

    return (
        <div className={'producer-card'}>
            <div className={'producer-card__title'}>
                {data.name}
            </div>
            <div className={'producer-card__body'}>
                <div className={'producer-card__body__item'}>
                    <span>ИНН:</span>
                    <span>{data.inn}</span>
                </div>
                <div className={'producer-card__body__item'}>
                    <span>ОГРН:</span>
                    <span>{data.ogrn}</span>
                </div>
                <div className={'producer-card__body__item'}>
                    <span>Регион:</span>
                    <span>{data.region}</span>
                </div>
                <div className={'producer-card__body__item'}>
                    <span>СЕО:</span>
                    <span>{data.ceo_name}</span>
                </div>
                <div className={'producer-card__body__item'}>
                    <span>Адрес:</span>
                    <span>{data.address}</span>
                </div>
                <div className={'producer-card__body__item'}>
                    <span>Оквед (код):</span>
                    <span>{data.main_okved_id}</span>
                </div>
                <div className={'producer-card__body__item'}>
                    <span>Оквед (описание):</span>
                    <span>{data.okved_descr}</span>
                </div>
                <div className={'producer-card__body__item'}>
                    <span>Дата регистрации:</span>
                    <span>{data.reg_date}</span>
                </div>
            </div>
        </div>
    )
}