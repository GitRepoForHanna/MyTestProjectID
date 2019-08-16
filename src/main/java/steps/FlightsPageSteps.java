package steps;

import io.qameta.allure.Link;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import pages.flights.FlightsPage;
import utils.ScreenShot;

public class FlightsPageSteps extends BaseSteps {

    @Step("Type location from: {0} - in short, {1} - full location name")
    public void setWhereFromPoint(String shortNameLocation, String fullNameLocation) {
        FlightsPage flightPage = new FlightsPage();
        flightPage.setWhereFromPoint(shortNameLocation);
        flightPage.selectWhereFromOption(fullNameLocation);
    }


}
