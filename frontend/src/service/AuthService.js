import axios from "axios";
import {AuthType} from "../enum/auth-type";
import {RequestService} from "./RequestService";

export class AuthService {
    static accessToken;
    static accessTokenExpires;
    static refreshToken;
    static refreshTokenExpires;

    static authenticated = false;

    static parsedAccessToken;

    static Constants = class {
        static ACCESS_TOKEN = 'accessToken';
        static REFRESH_TOKEN = 'refreshToken';
    }

    static init(callback) {
        const cookie = AuthService.parseCookie();
        if (!!cookie.accessToken) {
            AuthService
                .verifyAccessToken(cookie.accessToken)
                .then(() => AuthService.saveAccessByCookie(cookie))
                .catch(() => {
                    if (!!cookie.refreshToken) {
                        return AuthService
                            .loginByRefreshToken(cookie.refreshToken)
                            .catch(() => AuthService.clearCookie());
                    }
                    return Promise.reject();
                })
                .finally(() => callback());
        } else if (!!cookie.refreshToken) {
            AuthService
                .loginByRefreshToken(cookie.refreshToken)
                .catch(() => AuthService.clearCookie())
                .finally(() => callback());
        } else {
            callback();
        }
    }

    static verifyAccessToken(accessToken) {
        return axios.get(
            RequestService.API_URL + 'auth/verify',
            {
                headers: {
                    Authorization: accessToken
                }
            }
        );
    }

    static login(username, password) {
        return axios.post(
            RequestService.API_URL + 'auth/token',
            {
                username: username,
                password: password,
                type: AuthType.PASSWORD
            }
        )
            .then(response => AuthService.saveAccess(response.data));
    }

    static saveAccess(tokenResponse) {
        AuthService.accessToken = tokenResponse.accessToken;
        AuthService.accessTokenExpires = tokenResponse.accessTokenExpires;
        AuthService.refreshToken = tokenResponse.refreshToken;
        AuthService.refreshTokenExpires = tokenResponse.refreshTokenExpires;

        AuthService.authenticated = true;

        AuthService.parsedAccessToken = AuthService.parseAccessToken(AuthService.accessToken);

        AuthService.saveCookie();
    }

    static saveAccessByCookie(cookieToken) {
        AuthService.accessToken = cookieToken.accessToken;
        AuthService.refreshToken = cookieToken.refreshToken;

        AuthService.authenticated = true;

        AuthService.parsedAccessToken = AuthService.parseAccessToken(AuthService.accessToken);
    }

    static parseAccessToken(accessToken) {
        return JSON.parse(decodeURIComponent(escape(atob(accessToken.split('.')[1]))));
    }

    static isAuthenticated() {
        return AuthService.authenticated;
    }

    static saveCookie() {
        document.cookie = `${AuthService.Constants.ACCESS_TOKEN}=${AuthService.accessToken}; path=/; max-age=${AuthService.accessTokenExpires}`;
        document.cookie = `${AuthService.Constants.REFRESH_TOKEN}=${AuthService.refreshToken}; path=/; max-age=${AuthService.refreshTokenExpires}`;
    }

    static clearCookie() {
        document.cookie = `${AuthService.Constants.ACCESS_TOKEN}=; path=/; max-age=-1`;
        document.cookie = `${AuthService.Constants.REFRESH_TOKEN}=; path=/; max-age=-1`;

        AuthService.authenticated = false;
    }

    static parseCookie() {
        const cookies = document.cookie.split('; ');

        const dirtyAccessToken = cookies.find(row => row.startsWith(`${AuthService.Constants.ACCESS_TOKEN}=`));
        const accessToken = dirtyAccessToken !== undefined ? dirtyAccessToken.split('=')[1] : null;

        const dirtyRefreshToken = cookies.find(row => row.startsWith(`${AuthService.Constants.REFRESH_TOKEN}=`));
        const refreshToken = dirtyRefreshToken !== undefined ? dirtyRefreshToken.split('=')[1] : null;

        return {accessToken: accessToken, refreshToken: refreshToken};
    }

    static updateToken(callback) {
        if (!!AuthService.refreshToken && AuthService.isTokenExpired()) {
            return AuthService
                .loginByRefreshToken(null)
                .then(() => callback());
        }
        return Promise
            .resolve()
            .then(() => callback());
    }

    static isTokenExpired() {
        return !!AuthService.accessTokenExpires && (AuthService.accessTokenExpires - Math.ceil(new Date().getTime() / 1000) - 5) < 0;
    }

    static loginByRefreshToken(refreshToken) {
        let token = null;

        if (!!refreshToken) token = refreshToken;
        else if (!!AuthService.refreshToken) token = AuthService.refreshToken;
        else Promise.reject();

        return axios.post(
            RequestService.API_URL + 'auth/token',
            {
                refreshToken: token,
                type: AuthType.REFRESH_TOKEN
            }
        )
            .then(response => AuthService.saveAccess(response.data))
    }

    static getAccessToken() {
        return AuthService.accessToken;
    }

    static getUsername() {
        return AuthService.authenticated ? AuthService.parsedAccessToken.username : null;
    }
}