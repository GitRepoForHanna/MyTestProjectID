package utils;

public enum Currency {
    RUSSIAN_RUBLES("currency_RUB"),
    EURO("currency_EUR"),
    AMERICAN_DOLLAR("currency_USD"),
    POUND_STERLING("currency_GBP");

    private String value;

    Currency(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
