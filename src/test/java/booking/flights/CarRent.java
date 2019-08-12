package booking.flights;

import org.testng.annotations.Test;
import utils.Language;

import java.time.LocalDate;

public class CarRent extends BaseTest {
    private String rentDestination = "London, Greater London, United Kingdom";
    private String rentDestinationShort = "London";

    @Test
    public void RentCarInLondon() throws InterruptedException {
        navigateTo(URL);
        homePageSteps.selectLanguage(Language.UK);
        homePageSteps.clickCarRentButton();
        carPageSteps.setDestination(rentDestinationShort, rentDestination);
        carPageSteps.setRentingDataFrom(LocalDate.of(2019, 8, 17));
        carPageSteps.setRentingDataTo(LocalDate.of(2019,8,25));
        carPageSteps.clickSearchButton();
        Thread.sleep(5000);
    }
}
