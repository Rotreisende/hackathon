import {Link} from "react-router-dom";
import './header.css';

export const Header = () => {
    return (
        <header className={'header'}>
            <Link to={'/'} className={'header__logo'}>
                Атокупки
            </Link>
            <Link to={'/create-request'} className={'header__link'}>
                Создать запрос
            </Link>
        </header>
    )
}