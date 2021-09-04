export class PaymentMethod {
    static FZ_44 = class {
        static api = 'FZ_44';
        static view = 'ФЗ 44';
        static fullView = 'Федеральный закон №44';
    }

    static FZ_223 = class {
        static api = 'FZ_223';
        static view = 'ФЗ 223';
        static fullView = 'Федеральный закон №223';
    }

    static convert(type) {
        if (type === PaymentMethod.FZ_44.api) return PaymentMethod.FZ_44.view;
        if (type === PaymentMethod.FZ_223.api) return PaymentMethod.FZ_223.view;
    }

    static convertToFullView(type) {
        if (type === PaymentMethod.FZ_44.api) return PaymentMethod.FZ_44.fullView;
        if (type === PaymentMethod.FZ_223.api) return PaymentMethod.FZ_223.fullView;
    }
}