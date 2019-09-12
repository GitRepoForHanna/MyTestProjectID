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
    public void RentCarInLondon(CarRentingData data) throws InterruptedException {
//        navigateTo(properties.getProperty("booking.com.url"));
        navigateTo(getResourceBundle("config").getString("booking.com.url"));
        homePageSteps.selectLanguage(Language.UK);
        homePageSteps.clickCarRentButton();
        carPageSteps.setDestination(data.getShortDestination(), data.getDestination());
        carPageSteps.setRentingDateFrom(LocalDate.of(data.getCheckInYear(), data.getCheckInMonth(), data.getCheckInDay()));
        carPageSteps.setRentingDateTo(LocalDate.of(data.getCheckOutYear(),data.getCheckOutMonth(),data.getCheckOutDay()));
        carPageSteps.clickSearchButton();
        Thread.sleep(5000);
    }

    @Test
    public void BookingComExceptionTest() {
        navigateToBookingCom();
    }

}
