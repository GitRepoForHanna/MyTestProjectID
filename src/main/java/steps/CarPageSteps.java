package steps;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import pages.car_rent.CarPage;
import pages.date.DateCalendarPage;
import utils.dependency_injection.ConfigurationModule;


import java.time.LocalDate;

public class CarPageSteps extends BaseSteps {

    public CarPageSteps() {
    }

    @Step("Set the checkIn point for car renting: {0} - destination in short, {1} - full name of destination")
    public void setDestination(String destinationShort, String destination) {
        Logger.getLogger(CarPageSteps.class).info(String.format("Set checkIn point on Car Renting page: %s - destination in short, %s - full name destination", destinationShort, destination));
        CarPage carPage = new CarPage();
        carPage.setDestination(destinationShort);
        carPage.selectDestinationOption(destination);
    }

    @Step("Set {0} as checkIn date for car renting")
    public void setRentingDateFrom(LocalDate dateFrom) throws InterruptedException {
        Logger.getLogger(CarPageSteps.class).info("Set checkIn date on Car Renting page");
        CarPage carPage = new CarPage();
        carPage.clickOnDateFromInput();
        carPage.expandCheckInCalendar();
        new DateCalendarPage().setDateFrom(dateFrom);
    }

    @Step("Set {0} as checkOut date for car renting")
    public void setRentingDateTo(LocalDate dateTo) throws InterruptedException{
        CarPage carPage = new CarPage();
        Logger.getLogger(CarPageSteps.class).info("Set checkOut date on Car Renting page");
        carPage.clickOnDateToInput();
        carPage.expandCheckOutCalendar();
        new DateCalendarPage().setDateTo(dateTo);
    }

    @Step("Click button Search on Car page")
    public void clickSearchButton() {
        Logger.getLogger(CarPageSteps.class).info("Click Search button on Car Renting page");
        new CarPage().clickSearchButton();
    }
}
