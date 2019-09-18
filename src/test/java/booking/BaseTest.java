package booking;

import com.google.inject.Inject;
import org.apache.log4j.Logger;
import org.testng.annotations.*;
import steps.CarPageSteps;
import steps.CarRentSearchResultSteps;
import steps.FlightsPageSteps;
import steps.HomePageSteps;
import utils.PropertiesUtil;
import utils.dependency_injection.ConfigurationModule;
import utils.exceptions.ScenarioException;
import utils.webdriver.WebDriverSingletoneInstance;

import java.util.ResourceBundle;

@Guice(modules = {ConfigurationModule.class})
public class BaseTest {

    protected static final String URL = "https://www.booking.com";

    @Inject
    protected HomePageSteps homePageSteps;
    @Inject
    protected CarPageSteps carPageSteps;
    @Inject
    protected FlightsPageSteps flightsPageSteps;
    @Inject
    protected CarRentSearchResultSteps carRentSearchResultSteps;

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
        instance.getWebDriverInstance().get(url);
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
