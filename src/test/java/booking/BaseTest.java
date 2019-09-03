package booking;

import steps.CarPageSteps;
import steps.HomePageSteps;
import utils.PropertiesUtil;
import utils.webdriver.WebDriverSingletoneInstance;
import java.util.ResourceBundle;

public class BaseTest {

    protected static final String URL = "https://www.booking.com";
    protected HomePageSteps homePageSteps = new HomePageSteps();
    protected CarPageSteps carPageSteps = new CarPageSteps();
    private WebDriverSingletoneInstance instance;

    protected PropertiesUtil properties = new PropertiesUtil("src//test/resources/config.properties");

    public BaseTest() {

    }

    public ResourceBundle getResourceBundle(String resourceBundleName) {
        return  ResourceBundle.getBundle(resourceBundleName);
    }



}
