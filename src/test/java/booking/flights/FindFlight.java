package booking.flights;

import booking.BaseTest;
import io.qameta.allure.Description;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Language;

public class FindFlight extends BaseTest {

    @Test(groups = "Flight")
    @Description("Navigate to booking.com page")
    public void navigateToBooking() {
        Logger.getLogger(FindFlight.class).info("Navigate to booking.com page");
        navigateTo(properties.getProperty("booking.com.url"));
    }

    @Test(groups = "Flight")
    @Description("Change Language")
    public void changeLanguage() {
        Logger.getLogger(FindFlight.class).info("Change Language");
        navigateTo(properties.getProperty("booking.com.url"));
        homePageSteps.selectLanguage(Language.ITALIA);
    }

    @Test(groups = "Flight")
    @Description("Select the flight for 1 week")
    public void findWeekFlight() throws InterruptedException {
        Logger.getLogger(FindFlight.class).info("Select the flight for 1 week");
        navigateTo(getResourceBundle("config").getString("booking.com.url"));
        homePageSteps.clickFlightsButton();
        flightsPageSteps.setWhereFromPoint("Izmir", "Chios (JKH)");
        flightsPageSteps.setWhereToPoint("Rhodes", "Rhodes (RHO)");
        Thread.sleep(4000);
    }

    @Test(dataProvider = "NotExistingLocation", groups = "Flight")
    @Description("Selecting not existing location from for flight. Constantly failing scenario.")
    public void findFlightWithNotExistingLocation(String shortLocation, String fullLocation) {
        Logger.getLogger(FindFlight.class).info("Selecting not existing location from for flight. Constantly failing scenario.");
        navigateTo(properties.getProperty("booking.com.url"));
        homePageSteps.clickFlightsButton();
        flightsPageSteps.setWhereFromPoint(shortLocation, fullLocation);
    }

    @DataProvider(name = "NotExistingLocation")
    public Object[][] notExistingLocationDataProvider() {
        return new Object[][]{{"Pechkino", "Pechkino, Mirski district"}};
    }

}
