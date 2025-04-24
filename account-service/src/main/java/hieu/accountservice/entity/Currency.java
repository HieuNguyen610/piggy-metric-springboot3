package hieu.accountservice.entity;

public enum Currency {

    USD, EUR, RUB;

    public static Currency getDefault() {
        return USD;
    }
}
