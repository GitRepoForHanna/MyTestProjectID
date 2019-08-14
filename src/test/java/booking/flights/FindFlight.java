package booking.flights;

import booking.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.HomePageSteps;
import utils.Language;
import utils.webdriver.WebDriverInstance;

public class FindFlight extends BaseTest {

    HomePageSteps homePageSteps = new HomePageSteps();

//    @BeforeTest
//    protected void setUp() {
//        initWebDriverInstance();
//        instance.getDriver().manage().window().maximize();
//    }

    @AfterTest
    protected void tearDown() {
        System.out.println("instance " + WebDriverInstance.getInstance().toString());
        System.out.println("getDriver " + WebDriverInstance.getInstance().getDriver());
        WebDriverInstance.getInstance().closeDriver();
    }

    @Test
    public void navigateToBooking() throws NoSuchMethodException {
        System.out.println("navigateToBooking");
        System.out.println(Thread.currentThread().getName());
        navigateTo(URL);
    }

    @Test
    public void changeLanguage() throws NoSuchMethodException {
        System.out.println("changeLanguage");
        System.out.println(Thread.currentThread().getName());
        navigateTo(URL);
        homePageSteps.selectLanguage(Language.ITALIA);
    }

}
