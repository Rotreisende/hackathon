import {Link} from "react-router-dom";
import './header.css';
import logoImg from '../../image/logo.png';

export const Header = () => {
    return (
        <header className={'header'}>
            <Link to={'/'} className={'header__logo'}>
                <img src={logoImg} alt="logo" className={'header__logo__image'}/>
                <span className={'header__logo__title'}>Атокупки</span>
            </Link>
            <div className={'header__links'}>
                <Link to={'/'} className={'header__link'}>
                    Запросы
                </Link>
                <Link to={'/create-request'} className={'header__link'}>
                    Создать запрос
                </Link>
            </div>
        </header>
    )
}