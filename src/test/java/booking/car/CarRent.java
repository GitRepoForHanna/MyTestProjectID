package booking.car;

import booking.BaseTest;
import booking.dataprovider.CarRentingDataProvider;
import business_objects.car.*;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Language;
import utils.dataProviders.CarRentingData;
import utils.dataProviders.CarRentingDataBuilder;
import java.time.LocalDate;
import java.util.Arrays;


public class CarRent extends BaseTest {

    @Test(dataProvider = "CarRentingData", dataProviderClass = CarRentingDataProvider.class, groups = "Car")
    @Description("Test car renting opportunity")
    public void rentCarInLondon(CarRentingData data) throws InterruptedException {
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
    public void bookingComExceptionTest() {
        navigateToBookingCom();
    }

    @Test(dataProvider = "RentCarWithSpecialConfiguration", groups = "Car")
    @Description("Test car renting opportunity")
    public void configurationOfCar(CarRentingData data, CarBuilder.Car carSpecification) throws InterruptedException {
        navigateTo(getResourceBundle("config").getString("booking.com.url"));
        homePageSteps.selectLanguage(Language.UK);
        homePageSteps.clickCarRentButton();
        carPageSteps.setDestination(data.getShortDestination(), data.getDestination());
        carPageSteps.setRentingDateFrom(LocalDate.of(data.getCheckInYear(), data.getCheckInMonth(), data.getCheckInDay()));
        carPageSteps.setRentingDateTo(LocalDate.of(data.getCheckOutYear(),data.getCheckOutMonth(),data.getCheckOutDay()));
        carPageSteps.clickSearchButton();
        carRentSearchResultSteps.setCarCategory(CarCategory.PREMIUM.getCategory());
        carRentSearchResultSteps.setCarConfiguration(carSpecification);
        Thread.sleep(15000);
    }

    @DataProvider(name = "RentCarWithSpecialConfiguration")
    public Object[][] getData() {
        return new Object[][]{
                {
                    new CarRentingDataBuilder()
                            .withShortDestination("Paris")
                            .withFullDestination("Paris, Île de France, France")
                            .withCheckOutYear(2019)
                            .withCheckOutMonth(10)
                            .withCheckOutDay(12)
                            .withCheckInYear(2019)
                            .withCheckInMonth(10)
                            .withCheckInDay(20)
                            .build(),
                    new CarBuilder()
                            .withPartySizes(Arrays.asList(PartySize.LARGE_GROUP))
                            .withSpecifications(Arrays.asList(CarSpecification.WITH_AIR_CONDITIONING, CarSpecification.AUTOMATIC_TRANSMISSION))
                            .withPaymentCards(Arrays.asList(PaymentCard.CREDIT_CARD))
                            .withSuppliers(Arrays.asList(SuppliersOptions.EUROPCAR, SuppliersOptions.SIXT))
                            .withFuelPolicies(Arrays.asList(FuelPolicy.FULL_TO_FULL))
                            .withDamageExcesses(Arrays.asList(DamageExcess.EXPENSIVE))
                            .withDepositAtPickUps(Arrays.asList(DepositAtPickUp.LUX))
                            .build()
                }
        };
    }

}
