package business_objects.car;

import business_objects.ICheckBoxGroup;

public enum SupplierRating implements ICheckBoxGroup {
    EXCELLENT("Excellent: 8+"),
    VERY_GOOD("Very good: 7+"),
    GOOD("Good: 6+");

    private String ratingValue;

    SupplierRating(String ratingValue) {
        this.ratingValue = ratingValue;
    }

    public String getRatingValue() {
        return ratingValue;
    }

    public CarOption getOption() {
        return new CarOption(CarConfigurationMenu.SUPPLIER_RATING.getMenuItem(), ratingValue);
    }
}
