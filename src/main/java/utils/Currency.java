package utils;

public enum Currency {
    RUSSIAN_RUBLES("Russian Rubles"),
    EURO("Euro"),
    AMERICAN_DOLLAR("United States Dollars"),
    POUND_STERLING("Pound Sterling");
    private String currencyName;

    Currency(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyName() {
        return currencyName;
    }
}
