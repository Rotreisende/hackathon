import axios from "axios";
import {AuthService} from "./AuthService";

export class RequestService {

    static axi = axios.create();

    static API_URL = 'http://localhost:8080/api/';

    static init() {
        RequestService.axi.interceptors.request.use((config) => {
            if (AuthService.isAuthenticated()) {
                const cb = () => {
                    config.headers.Authorization = `Bearer ${AuthService.getAccessToken()}`;
                    return Promise.resolve(config);
                };
                return AuthService.updateToken(cb);
            }
            return config;
        });
    }

    static getInstance() {
        return RequestService.axi;
    }
}