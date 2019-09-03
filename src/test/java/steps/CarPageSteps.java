package steps;

import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.NoSuchElementException;
import pages.car_rent.CarPage;
import pages.date.DateCalendarPage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class CarPageSteps extends BaseSteps {

    @When("^I set destination \"([^\"]*)\" on Car Renting page$")
    public void setDestination(String destination) {
        CarPage carPage = new CarPage();
        carPage.setDestination(destination);
    }

    @When("^I select destination \"([^\"]*)\" in the dropdown on Car Renting page$")
    public void selectDestination(String destination) {
        CarPage carPage = new CarPage();
        carPage.selectDestinationOption(destination);
    }

    @When("^I set parameters for car renting search on Car Renting page$")
    public void setSearchParameters(DataTable dataTable) {
        CarPage carPage = new CarPage();
        DateCalendarPage dateCalendarPage = new DateCalendarPage();
        List<Map<String, String>> carRenting = dataTable.asMaps(String.class, String.class);
        String destination = carRenting.get(0).get("destination");
        String fullDestination = carRenting.get(0).get("full_destination");
        String checkInDate = carRenting.get(0).get("checkInDate");
        String checkOutDate = carRenting.get(0).get("checkOutDate");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        LocalDate checkIn = LocalDate.parse(checkInDate, formatter);
        LocalDate checkOut = LocalDate.parse(checkOutDate, formatter);
        this.setDestination(destination);
        this.selectDestination(fullDestination);
        try {
            dateCalendarPage.setDateFrom(checkIn);
            dateCalendarPage.setDateTo(checkOut);
        }
        catch (Exception e) {

        }
    }

    @When("^I set check in date \"([^\"]*)\" on Car Renting page$")
    public void setRentingDateFrom(String dateFrom) throws InterruptedException {
        CarPage carPage = new CarPage();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        try {
            if (!carPage.isCheckInDatePickerEnabled()) {
                carPage.clickOnDateFromInput();
            }
        }
        catch (NoSuchElementException e) {
            carPage.clickOnDateFromInput();
        }
        new DateCalendarPage().setDateFrom(LocalDate.parse(dateFrom, formatter));
    }

    @When("^I set check out date \"([^\"]*)\" on Car Renting page$")
    public void setRentingDateTo(String dateTo) throws InterruptedException{
        CarPage carPage = new CarPage();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        try {
            if (!carPage.isCheckOutDatePickerEnabled()) {
                carPage.clickOnDateToInput();
            }
        }
        catch (NoSuchElementException e) {
            carPage.clickOnDateToInput();
        }
        new DateCalendarPage().setDateTo(LocalDate.parse(dateTo, formatter));
    }

    @When("^I click Search button on Car Renting page$")
    public void clickSearchButton() {
        new CarPage().clickSearchButton();
    }
}
