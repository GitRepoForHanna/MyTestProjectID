package business_objects.car;

public enum CarConfigurationMenu {
    SUPPLIERS("supplier-filter-content"),
    SUPPLIER_RATING("rating-filter-content"),
    SUPPLIER_LOCATION("airport_loctype-filter-content"),
    FUEL_POLICY("fuel-filter-content"),
    CAR_SPECIFICATION("aircon-filter-content"),
    PARTY_SIZE("groupsize-filter-content"),
    DAMAGE_EXCESS("damage-excess-filter-content"),
    DEPOSITE_AT_PICKUP("deposit-filter-content"),
    PAYMENT_CARD("card-filter-content"),
    KILOMETRES("mileage-filter-content");

    private String menuItem;

    CarConfigurationMenu(String menuItem) {
        this.menuItem = menuItem;
    }

    public String getMenuItem() {
        return menuItem;
    }
}
