package business_objects.car;

import business_objects.ICheckBoxGroup;

public enum FuelPolicy implements ICheckBoxGroup {
    FULL_TO_FULL("Full to Full");

    private String fuelOption;

    FuelPolicy(String fuelOption) {
        this.fuelOption = fuelOption;
    }

    public String getFuelOption() {
        return fuelOption;
    }

    @Override
    public CarOption getOption() {
        return new CarOption(CarConfigurationMenu.FUEL_POLICY.getMenuItem(), fuelOption);
    }
}
