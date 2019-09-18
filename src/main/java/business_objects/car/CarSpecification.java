package business_objects.car;

import business_objects.ICheckBoxGroup;

public enum CarSpecification implements ICheckBoxGroup {
    WITH_AIR_CONDITIONING("With Air-conditioning"),
    AUTOMATIC_TRANSMISSION("Automatic Transmission"),
    MANUAL_GEARBOX("Manual gearbox"),
    MORE_THAN_4_DOORS("4+ Doors"),
    DIESEL("Diesel");

    private String specValue;

    CarSpecification(String specValue) {
        this.specValue = specValue;
    }

    public String getSpecValue() {
        return specValue;
    }

    public CarOption getOption() {
        return new CarOption(CarConfigurationMenu.CAR_SPECIFICATION.getMenuItem(), specValue);
    }
}
