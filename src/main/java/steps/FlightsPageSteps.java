package steps;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import pages.flights.FlightsPage;

public class FlightsPageSteps extends BaseSteps {

    @Step("Type location from: {0} - in short, {1} - full location name")
    public void setWhereFromPoint(String shortNameLocation, String fullNameLocation) {
        Logger.getLogger(FlightsPageSteps.class).info(String.format("Set start point location %s on Flight page", fullNameLocation));
        FlightsPage flightPage = new FlightsPage();
        flightPage.setWhereFromPoint(shortNameLocation);
        flightPage.selectLocationOption(fullNameLocation);
    }

    @Step("Type location to: {0} - in short, {1} - full location name")
    public void setWhereToPoint(String shortNameLocation, String fullNameLocation) {
        Logger.getLogger(FlightsPageSteps.class).info(String.format("Set finish point location %s on Flight page", fullNameLocation));
        FlightsPage flightPage = new FlightsPage();
        flightPage.setWhereToPoint(shortNameLocation);
        flightPage.selectLocationOption(fullNameLocation);
    }


}
