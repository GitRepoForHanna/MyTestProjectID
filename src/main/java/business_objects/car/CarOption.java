package business_objects.car;

public class CarOption {

    private String configurationGroup;
    private String configurationOption;

    public CarOption(String configurationGroup, String configurationOption) {
        this.configurationGroup = configurationGroup;
        this.configurationOption = configurationOption;
    }

    public String getConfigurationGroup() {
        return configurationGroup;
    }

    public String getConfigurationOption() {
        return configurationOption;
    }
}
