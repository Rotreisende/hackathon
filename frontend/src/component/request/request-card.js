import './request-card.css';
import {Link} from "react-router-dom";
import {PaymentMethod} from "../../enum/payment-method";
import {PreLoaderField} from "../pre-loader/pre-loader-field";

export const RequestCard = ({request}) => {

    return (
        <Link to={'/requests/' + (!!request ? request.id : '')} className={'request-card'}>
            <div className={'request-card__info'}>
                <div className={'request-card__info__item'}>
                    <span className={'request-card__info__item__title'}>
                        Способ оплаты
                    </span>
                    <span className={'request-card__info__item__value'}>
                        {!!request ? PaymentMethod.convertToFullView(request.paymentMethod) : <PreLoaderField/>}
                    </span>
                </div>
                <div className={'request-card__info__item'}>
                    <span className={'request-card__info__item__title'}>
                        Наименование товара
                    </span>
                    <span className={'request-card__info__item__value'}>
                        {!!request ? request.name : <PreLoaderField/>}
                    </span>
                </div>
                <div className={'request-card__info__item'}>
                    <span className={'request-card__info__item__title'}>
                        ОКПД2
                    </span>
                    <span className={'request-card__info__item__value'}>
                        {!!request ? request.code : <PreLoaderField/>}
                    </span>
                </div>
                <div className={'request-card__info__item'}>
                    <span className={'request-card__info__item__title'}>
                        Подходящих изготовителей
                    </span>
                    <span className={'request-card__info__item__value'}>
                        {!!request ? request.producersCount : <PreLoaderField/>}
                    </span>
                </div>
            </div>
            <div className={'request-card__data'}>
                <div className={'request-card__data__item'}>
                    <span className={'request-card__data__item__title'}>
                        Сумма
                    </span>
                    <span className={'request-card__data__item__value'}>
                        {!!request ? request.sum : <PreLoaderField/>} руб.
                    </span>
                </div>
                <div className={'request-card__data__item'}>
                    <span className={'request-card__data__item__title'}>
                        Количество
                    </span>
                    <span className={'request-card__data__item__value'}>
                        {
                            !!request
                                ? request.count + ' ' + request.units
                                : <PreLoaderField/>
                        }
                    </span>
                </div>
                <div className={'request-card__data__item'}>
                    <span className={'request-card__data__item__title'}>
                        Дата
                    </span>
                    <span className={'request-card__data__item__value'}>
                        {!!request ? request.date : <PreLoaderField/>}
                    </span>
                </div>
            </div>
        </Link>
    )
}