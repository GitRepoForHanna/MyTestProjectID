package business_objects.car;

import business_objects.ICheckBoxGroup;

public enum DamageExcess implements ICheckBoxGroup {

    CHEAP("0"),
    MIDDLE("1"),
    EXPENSIVE("2"),
    LUX("3");

    private String excessValue;

    DamageExcess(String excessValue) {
        this.excessValue = excessValue;
    }

    public String getExcessValue() {
        return excessValue;
    }

    public CarOption getOption() {
        return new CarOption(CarConfigurationMenu.DAMAGE_EXCESS.getMenuItem(), excessValue);
    }
}
