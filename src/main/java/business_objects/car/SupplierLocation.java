package business_objects.car;

import business_objects.ICheckBoxGroup;

public enum SupplierLocation implements ICheckBoxGroup {
    TERMINAL("In Terminal"),
    CAR_RENTING_CENTER("Outside of Terminal");

    private String locationValue;

    SupplierLocation(String locationValue) {
        this.locationValue = locationValue;
    }

    public String getLocationValue() {
        return locationValue;
    }

    public CarOption getOption() {
        return new CarOption(CarConfigurationMenu.SUPPLIER_LOCATION.getMenuItem(), locationValue);
    }
}
