package steps;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import utils.Language;
import pages.homePage.HomePage;

public class HomePageSteps extends BaseSteps{

    @Step("Select Language {0}")
    public void selectLanguage(Language language) {
        Logger.getLogger(HomePageSteps.class).info(String.format("Set language %s on Home page", language));
        HomePage homePage = new HomePage();
        homePage.clickSelectLanguage();
        homePage.selectLanguage(language);
    }

    @Step("Select currency {0}")
    public void selectCurrency(String currency) {
        Logger.getLogger(HomePageSteps.class).info(String.format("Set currency %s on Home page", currency));
        HomePage homePage = new HomePage();
        homePage.clickSelectCurrency();
        homePage.selectCurrency(currency);
    }

    @Step("Navigation to Car Renting page")
    public void clickCarRentButton() {
        Logger.getLogger(HomePageSteps.class).info("Navigation to Car Renting page");
        new HomePage().clickCarRentButton();
    }

    @Step("Navigation to Flights page")
    public void clickFlightsButton() {
        Logger.getLogger(HomePageSteps.class).info("Navigation to Flights page");
        new HomePage().clickFlightsButton();
    }

}
