package pages.homePage;

import model.components.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import utils.Currency;
import utils.CustomFieldDecorator;
import utils.Language;
import utils.webdriver.Wait;
import utils.webdriver.WebDriverSingletoneInstance;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id='user_form']//li[@data-id='language_selector']")
    private Button languageSelector;

    @FindBy(id = "current_language")
    private WebElement selectLanguagePanel;

    //xpath for currency or language list item
    private static String triggerXpath = "//li[contains(@class,'%s')]//a";

    @FindBy(xpath = "//div[@id='user_form']//li[@data-id='currency_selector']")
    private WebElement currencySelector;

    @FindBy(id="current_currency")
    private WebElement selectCurrencyPanel;

    @FindBy(xpath = "//span[text()='Car Rentals' or text() = 'Car rentals']")
    private Button carRentButton;

    @FindBy(linkText = "Flights")
    private Button flightsButton;

    public HomePage() {
        PageFactory.initElements(new CustomFieldDecorator(WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance()), this);
    }

    private String getLanguageTriggerLocator(Language language) {
        return String.format(triggerXpath, language.getValue());
    }

    private String getCurrencyTriggerLocator(Currency currency) {
        return String.format(triggerXpath, currency.getValue());
    }

    public void clickSelectLanguage() {
        languageSelector.click();
    }

    public void selectLanguage(Language language) {
        Wait.getWebdriverWait().until(ExpectedConditions.visibilityOf(selectLanguagePanel));
        By languageTrigger = By.xpath(getLanguageTriggerLocator(language));
        Wait.getWebdriverWait().until(ExpectedConditions.presenceOfElementLocated(languageTrigger));
        getDriver().findElement(languageTrigger).click();
    }

    public void clickSelectCurrency() {
        currencySelector.click();
    }

    public void selectCurrency(Currency currency) {
        Wait.getWebdriverWait().until(ExpectedConditions.visibilityOf(selectCurrencyPanel));
        By currencyTrigger = By.xpath(getCurrencyTriggerLocator(currency));
        Wait.getWebdriverWait().until(ExpectedConditions.presenceOfElementLocated(currencyTrigger));
        getDriver().findElement(currencyTrigger).click();
    }

    public void clickCarRentButton() {
        carRentButton.click();
    }

    public void clickFlightsButton() {
        flightsButton.click();
    }

}
