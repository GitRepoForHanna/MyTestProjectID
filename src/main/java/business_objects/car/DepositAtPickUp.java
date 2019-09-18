package business_objects.car;

import business_objects.ICheckBoxGroup;

public enum DepositAtPickUp implements ICheckBoxGroup {
    CHEAP("0"),
    MIDDLE("1"),
    EXPENSIVE("2"),
    LUX("3");

    private String depositValue;

    DepositAtPickUp(String depositValue) {
        this.depositValue = depositValue;
    }

    public String getDepositValue() {
        return depositValue;
    }

    public CarOption getOption() {
        return new CarOption(CarConfigurationMenu.DEPOSITE_AT_PICKUP.getMenuItem(), depositValue);
    }
}
