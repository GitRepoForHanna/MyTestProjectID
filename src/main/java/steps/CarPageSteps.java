package steps;

import pages.car_rent.CarPage;
import pages.date.DateCalendarPage;
import java.time.LocalDate;

public class CarPageSteps extends BaseSteps {

    CarPage carPage = new CarPage();
    DateCalendarPage dateCalendarPage = new DateCalendarPage();

    public void setDestination(String destinationShort, String destination) throws InterruptedException {
        carPage.setDestination(destinationShort);
        carPage.selectDestinationOption(destination);
    }

    public void setRentingDataFrom(LocalDate dateFrom) throws InterruptedException {
        carPage.clickOnDateFromInput();
        dateCalendarPage.setDateFrom(dateFrom);
        carPage.clickOnDateToInput();
    }

    public void setRentingDataTo(LocalDate dateTo) throws InterruptedException{
        carPage.clickOnDateToInput();
        dateCalendarPage.setDateTo(dateTo);
    }

    public void clickSearchButton() {
        carPage.clickSearchButton();
    }
}
