package booking;

import org.apache.log4j.Logger;
import org.testng.annotations.*;
import steps.CarPageSteps;
import steps.HomePageSteps;
import utils.PropertiesUtil;
import utils.exceptions.ScenarioException;
import utils.webdriver.WebDriverSingletoneInstance;

import java.util.ResourceBundle;

public class BaseTest {

    protected static final String URL = "https://www.booking.com";
    protected HomePageSteps homePageSteps = new HomePageSteps();
    protected CarPageSteps carPageSteps = new CarPageSteps();
    private WebDriverSingletoneInstance instance;

    protected PropertiesUtil properties = new PropertiesUtil("src//test/resources/config.properties");

    @BeforeTest
    public void beforeTest() {
        instance = WebDriverSingletoneInstance.getWebDriverSingletoneInstance();
    }

    @AfterTest
    public void closeDriver() {
        Logger.getLogger(BaseTest.class).info("Close Driver");
        instance.closeDriver();
    }

    public BaseTest() {

    }

    public ResourceBundle getResourceBundle(String resourceBundleName) {
        return ResourceBundle.getBundle(resourceBundleName);
    }


    public void navigateTo(String url) {
        Logger.getLogger(BaseTest.class).info(String.format("Navigation to %s", url));
        try {
            instance.getWebDriverInstance().get(url);
            if (!url.equalsIgnoreCase("https://www.booking.com")) {
                throw new ScenarioException("You are navigating to the wrong place!");
            }
        } catch (ScenarioException ex) {
            ex.printStackTrace();
        }
    }

    public void navigateToBookingCom() {
        Logger.getLogger(BaseTest.class).info(String.format("Navigation to Booking.com"));
            String url = getResourceBundle("config").getString("wrong.url");
            if (!url.equalsIgnoreCase("https://www.booking.com")) {
                throw new ScenarioException("You are navigating to the wrong place!");
            }
            instance.getWebDriverInstance().get(url);
    }
}
