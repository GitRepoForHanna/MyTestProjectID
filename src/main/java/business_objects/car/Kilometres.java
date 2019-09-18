package business_objects.car;

import business_objects.ICheckBoxGroup;

public enum Kilometres implements ICheckBoxGroup {
    LIMITED("Limited"),
    UNLIMITED("Unlimited");

    private String kilometresValue;

    Kilometres(String kilometresValue) {
        this.kilometresValue = kilometresValue;
    }

    public String getKilometresValue() {
        return kilometresValue;
    }

    public CarOption getOption() {
        return new CarOption(CarConfigurationMenu.KILOMETRES.getMenuItem(), kilometresValue);
    }
}
