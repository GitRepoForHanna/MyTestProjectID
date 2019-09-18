package business_objects.car;

public enum CarCategory {
    SMALL("Small cars"),
    MEDIUM("Medium cars"),
    LARGE("Large cars"),
    ESTATE("Estate cars"),
    PREMIUM("Premium cars"),
    PEOPLE_CARRIERS("People carriers"),
    SUV("SUVs");
    // //div[@class='sr-CarCategories-row']//a/div[@class='sr-CarCategories_Title']/span[text()='Small cars']

    private String category;

    CarCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
