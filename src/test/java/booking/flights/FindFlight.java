package booking.flights;

import booking.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.*;
import steps.FlightsPageSteps;
import steps.HomePageSteps;
import utils.Language;
import utils.webdriver.WebDriverInstance;

public class FindFlight extends BaseTest {

    HomePageSteps homePageSteps = new HomePageSteps();
    FlightsPageSteps flightsPageSteps = new FlightsPageSteps();

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
    @Description("Navigate to booking.com page")
    public void navigateToBooking() throws NoSuchMethodException {
        System.out.println("navigateToBooking");
        System.out.println(Thread.currentThread().getName());
        navigateTo(URL);
    }

    @Test
    @Description("Change Language")
    public void changeLanguage() throws NoSuchMethodException {
        System.out.println("changeLanguage");
        System.out.println(Thread.currentThread().getName());
        navigateTo(URL);
        homePageSteps.selectLanguage(Language.ITALIA);
    }

    @Test(dataProvider = "NotExistingLocation")
    @Description("Selecting not existing location from for flight. Constanly failing scenario.")
    public void findFlightWithNotExcistingLocation(String shortLocation, String fullLocation) {
        navigateTo(URL);
        flightsPageSteps.setWhereFromPoint(shortLocation, fullLocation);
    }

    @DataProvider(name = "NotExistingLocation")
    public Object[][] notExistingLocationDataProvider() {
        return new Object[][]{{"Pechkino", "Pechkino, Mirski district"}};
    }

}
