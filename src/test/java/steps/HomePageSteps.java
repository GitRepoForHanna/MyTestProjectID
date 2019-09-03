package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import utils.Currency;
import utils.Language;
import pages.homePage.HomePage;
import utils.webdriver.WebDriverSingletoneInstance;

public class HomePageSteps extends BaseSteps{

    @Given("^I navigate to \"([^\"]*)\"$")
    public void navigateTo(String url) {
        WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance().get(url);
    }

    @When("^I select language \"([^\"]*)\" on Home page$")
    public void selectLanguage(Language language) {
        HomePage homePage = new HomePage();
        homePage.clickSelectLanguage();
        homePage.selectLanguage(language);
    }

    @When("^I select currency \"([^\"]*)\" on Home page$")
    public void selectCurrency(Currency currency) {
        HomePage homePage = new HomePage();
        homePage.clickSelectCurrency();
        homePage.selectCurrency(currency);
    }

    @When("^I navigate to Car Renting page$")
    public void clickCarRentButton() {
        new HomePage().clickCarRentButton();
    }

    @When("^I navigate to Flights page$")
    public void clickFlightsButton() {
        new HomePage().clickFlightsButton();
    }

    @When("^I close driver$")
    public void closeDriver() {
        WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance().close();
    }

}
