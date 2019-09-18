package business_objects.car;

import business_objects.ICheckBoxGroup;

public enum SuppliersOptions implements ICheckBoxGroup {

    EUROPCAR("Europcar"),
    FIREFLY("Firefly"),
    INTERRENT("InterRent"),
    SIXT("Sixt");

    private String value;

    SuppliersOptions(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public CarOption getOption() {
        return new CarOption(CarConfigurationMenu.SUPPLIERS.getMenuItem(), value);
    }
}
