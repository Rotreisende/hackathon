import './producer-card.css';

export const ProducerCard = ({data}) => {

    return (
        <div className={'producer-card'}>
            <div className={'producer-card__title'}>
                {data.name}
            </div>
            <div className={'producer-card__body'}>
                <div className={'producer-card__body__item'}>
                    <span className={'producer-card__body__item__title'}>ИНН:</span>
                    <span className={'producer-card__body__item__value'}>{data.inn}</span>
                </div>
                <div className={'producer-card__body__item'}>
                    <span className={'producer-card__body__item__title'}>ОГРН:</span>
                    <span className={'producer-card__body__item__value'}>{data.ogrn}</span>
                </div>
                <div className={'producer-card__body__item'}>
                    <span className={'producer-card__body__item__title'}>Регион:</span>
                    <span className={'producer-card__body__item__value'}>{data.region}</span>
                </div>
                <div className={'producer-card__body__item'}>
                    <span className={'producer-card__body__item__title'}>СЕО:</span>
                    <span className={'producer-card__body__item__value'}>{data.ceo_name}</span>
                </div>
                <div className={'producer-card__body__item'}>
                    <span className={'producer-card__body__item__title'}>Адрес:</span>
                    <span className={'producer-card__body__item__value'}>{data.address}</span>
                </div>
                <div className={'producer-card__body__item'}>
                    <span className={'producer-card__body__item__title'}>Оквед (код):</span>
                    <span className={'producer-card__body__item__value'}>{data.main_okved_id}</span>
                </div>
                <div className={'producer-card__body__item'}>
                    <span className={'producer-card__body__item__title'}>Оквед (описание):</span>
                    <span className={'producer-card__body__item__value'}>{data.okved_descr}</span>
                </div>
                <div className={'producer-card__body__item'}>
                    <span className={'producer-card__body__item__title'}>Дата регистрации:</span>
                    <span className={'producer-card__body__item__value'}>{data.reg_date}</span>
                </div>
            </div>
        </div>
    )
}