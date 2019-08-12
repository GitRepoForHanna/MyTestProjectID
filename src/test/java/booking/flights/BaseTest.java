package booking.flights;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import steps.CarPageSteps;
import steps.HomePageSteps;
import utils.webdriver.WebDriverInstance;

public class BaseTest {

    protected static final String URL = "https://www.booking.com";
    protected HomePageSteps homePageSteps = new HomePageSteps();   // в baseTest
    protected CarPageSteps carPageSteps = new CarPageSteps();

    @BeforeTest
    public void beforeTest() {
        getWebDriverInstance().manage().window().maximize();
    }

    @AfterTest
    public void closeDriver() {
        getWebDriverInstance().quit();
    }

    private WebDriver getWebDriverInstance() {
        return WebDriverInstance.getWebDriver();
    }

    public void navigateTo(String url) {
        getWebDriverInstance().get(url);
    }
}
