package business_objects.car;

import business_objects.ICheckBoxGroup;

public enum PartySize implements ICheckBoxGroup {

    UNDER_2_PEOPLE("1 or 2 persons"),
    SMALL_GROUP("Small Group"),
    LARGE_GROUP("Large Group");

    private String partySizeValue;

    PartySize(String partySizeValue) {
        this.partySizeValue = partySizeValue;
    }

    public String getPartySizeValue() {
        return partySizeValue;
    }

    public CarOption getOption() {
        return new CarOption(CarConfigurationMenu.PARTY_SIZE.getMenuItem(), partySizeValue);
    }
}
