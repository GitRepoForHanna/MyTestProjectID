package business_objects.car;

import business_objects.ICheckBoxGroup;

public enum PaymentCard implements ICheckBoxGroup {

    DEBIT_CARD("Debit card"),
    CREDIT_CARD("Credit card");

    private String cardValue;

    PaymentCard(String cardValue) {
        this.cardValue = cardValue;
    }

    public String getCardValue() {
        return cardValue;
    }

    public CarOption getOption() {
        return new CarOption(CarConfigurationMenu.PAYMENT_CARD.getMenuItem(), cardValue);
    }
}
