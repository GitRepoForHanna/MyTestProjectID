package booking.flights;

import booking.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.FlightsPageSteps;
import steps.HomePageSteps;
import utils.Language;

public class FindFlight extends BaseTest {

    HomePageSteps homePageSteps = new HomePageSteps();
    FlightsPageSteps flightsPageSteps = new FlightsPageSteps();

    @Test(groups = "Flight")
    @Description("Navigate to booking.com page")
    public void navigateToBooking() {
        navigateTo(properties.getProperty("booking.com.url"));
    }

    @Test(groups = "Flight")
    @Description("Change Language")
    public void changeLanguage() {
        navigateTo(properties.getProperty("booking.com.url"));
        homePageSteps.selectLanguage(Language.ITALIA);
    }

    @Test(groups = "Flight")
    @Description("Select the flight for 1 week")
    public void findWeekFlight() throws InterruptedException {
        navigateTo(getResourceBundle("config").getString("booking.com.url"));
        homePageSteps.clickFlightsButton();
        flightsPageSteps.setWhereFromPoint("Izmir", "Chios (JKH)");
        flightsPageSteps.setWhereToPoint("Rhodes", "Rhodes (RHO)");
        Thread.sleep(4000);
    }

    @Test(dataProvider = "NotExistingLocation", groups = "Flight")
    @Description("Selecting not existing location from for flight. Constantly failing scenario.")
    public void findFlightWithNotExistingLocation(String shortLocation, String fullLocation) {
        navigateTo(properties.getProperty("booking.com.url"));
        homePageSteps.clickFlightsButton();
        flightsPageSteps.setWhereFromPoint(shortLocation, fullLocation);
    }

    @DataProvider(name = "NotExistingLocation")
    public Object[][] notExistingLocationDataProvider() {
        return new Object[][]{{"Pechkino", "Pechkino, Mirski district"}};
    }

}
