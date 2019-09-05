package booking.car;

import booking.BaseTest;
import booking.dataprovider.CarRentingDataProvider;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utils.Language;
import utils.dataProviders.CarRentingData;

import java.time.LocalDate;


public class CarRent extends BaseTest {

    @Test(dataProvider = "CarRentingData", dataProviderClass = CarRentingDataProvider.class, groups = "Car")
    @Description("Test car renting opportunity")
    public void RentCarInLondon(CarRentingData data) throws InterruptedException, NoSuchMethodException {
        LOGGER.info("Test car renting opportunity");
        LOGGER.debug("Open Browser");
//        navigateTo(properties.getProperty("booking.com.url"));
        navigateTo(getResourceBundle("config").getString("booking.com.url"));
        LOGGER.info("Select Language");
        homePageSteps.selectLanguage(Language.UK);
        LOGGER.info("Go to renting car page");
        homePageSteps.clickCarRentButton();
        LOGGER.info("Setting car renting parameters");
        carPageSteps.setDestination(data.getShortDestination(), data.getDestination());
        carPageSteps.setRentingDateFrom(LocalDate.of(data.getCheckInYear(), data.getCheckInMonth(), data.getCheckInDay()));
        carPageSteps.setRentingDateTo(LocalDate.of(data.getCheckOutYear(),data.getCheckOutMonth(),data.getCheckOutDay()));
        carPageSteps.clickSearchButton();
        LOGGER.debug("Test completed");
        Thread.sleep(5000);
    }

}
