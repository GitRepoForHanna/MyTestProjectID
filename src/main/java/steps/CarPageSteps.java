package steps;

import io.qameta.allure.Step;
import pages.car_rent.CarPage;
import pages.date.DateCalendarPage;


import java.time.LocalDate;

public class CarPageSteps extends BaseSteps {

    @Step("Set the checkIn point for car renting: {0} - destination in short, {1} - full name of destination")
    public void setDestination(String destinationShort, String destination) throws InterruptedException {
        CarPage carPage = new CarPage();
        carPage.setDestination(destinationShort);
        carPage.selectDestinationOption(destination);
    }

    @Step("Set {0} as checkIn date for car renting")
    public void setRentingDateFrom(LocalDate dateFrom) throws InterruptedException {
        CarPage carPage = new CarPage();
        carPage.clickOnDateFromInput();
        new DateCalendarPage().setDateFrom(dateFrom);
//        carPage.clickOnDateToInput();
//        new Actions(WebDriverSingletoneInstance.getWebDriverInstance()).sendKeys(Keys.ESCAPE).perform();
    }

    @Step("Set {0} as checkOut date for car renting")
    public void setRentingDateTo(LocalDate dateTo) throws InterruptedException{
        new CarPage().clickOnDateToInput();
        new DateCalendarPage().setDateTo(dateTo);
    }

    @Step("Click button Search on Car page")
    public void clickSearchButton() {
        new CarPage().clickSearchButton();
    }
}
