package steps;

import io.qameta.allure.Step;
import utils.Language;
import pages.homePage.HomePage;

public class HomePageSteps extends BaseSteps{

    @Step("Select Language {0}")
    public void selectLanguage(Language language) {
        HomePage homePage = new HomePage();
        homePage.clickSelectLanguage();
        homePage.selectLanguage(language);
    }

    @Step("Select currency {0}")
    public void selectCurrency(String currency) {
        HomePage homePage = new HomePage();
        homePage.clickSelectCurrency();
        homePage.selectCurrency(currency);
    }

    @Step("Navigation to Car Renting page")
    public void clickCarRentButton() {
        new HomePage().clickCarRentButton();
    }

    @Step("Navigation to Flights page")
    public void clickFlightsButton() {
        new HomePage().clickFlightsButton();
    }

}
