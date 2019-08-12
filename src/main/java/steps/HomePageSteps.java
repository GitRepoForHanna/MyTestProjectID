package steps;

import utils.Language;
import pages.homePage.HomePage;

public class HomePageSteps extends BaseSteps{

    HomePage homePage = new HomePage();

    public void selectLanguage(Language language) {
        homePage.clickSelectLanguage();
        homePage.selectLanguage(language);
    }

    public void selectCurrency(String currency) {
        homePage.clickSelectCurrency();
        homePage.selectCurrency(currency);
    }

    public void clickCarRentButton() {
        homePage.clickCarRentButton();
    }

}
