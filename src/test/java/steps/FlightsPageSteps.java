package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.flights.FlightsPage;

public class FlightsPageSteps extends BaseSteps {

    @When("^I set Start point \"([^\"]*)\" on the Flight page$")
    public void setWhereFromPoint(String shortNameLocation) {
        FlightsPage flightPage = new FlightsPage();
        flightPage.setWhereFromPoint(shortNameLocation);
    }

    @When("^I select Start point \"([^\"]*)\" on the Flight page$")
    public void selectStartPoint(String fullNameLocation) {
        new FlightsPage().selectLocationOption(fullNameLocation);
    }

    @When("^I set End point \"([^\"]*)\" on the Flight page\"$")
    public void setWhereToPoint(String shortNameLocation) {
        FlightsPage flightPage = new FlightsPage();
        flightPage.setWhereToPoint(shortNameLocation);
    }

    @When("^I select End point \"([^\"]*)\" on the Flight page$")
    public void selectEndPoint(String fullNameLocation) {
        new FlightsPage().selectLocationOption(fullNameLocation);
    }

    @Then("^I assert that Start point \"([^\"]*)\" is available in suggested list on Flight page$")
    public void assertStartPointIsAvailable(String point) {
        Assert.assertTrue(new FlightsPage().isOptionAvailable(point, true));
    }

    @Then("^I assert that Start point \"([^\"]*)\" is not available in suggested list on Flight page$")
    public void assertStartPointIsNotAvailable(String point) {
        Assert.assertFalse(new FlightsPage().isOptionAvailable(point, false));
    }

    @Then("^I assert that Start point is \"([^\"]*)\" on the Flight page$")
    public void assertStartPointValue(String point) {
        Assert.assertEquals(point, new FlightsPage().getWhereFromPoint());
    }

}
