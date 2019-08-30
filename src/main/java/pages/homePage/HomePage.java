package pages.homePage;

import model.components.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import utils.CustomFieldDecorator;
import utils.HighlightElement;
import utils.Language;
import utils.webdriver.Wait;
import utils.webdriver.WebDriverSingletoneInstance;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id='user_form']//li[@data-id='language_selector']")
    private Button languageSelector;

    @FindBy(id = "current_language")
    private WebElement selectLanguagePanel;

    private static String languageTriggerXpath = "//li[contains(@class,'%s')]//a";

    @FindBy(xpath = "//div[@id='user_form']//li[@data-id='currency_selector']")
    private WebElement currencySelector;

    @FindBy(linkText = "Car rentals")
    private Button carRentButton;

    @FindBy(linkText = "Flights")
    private Button flightsButton;

    public HomePage() {
        PageFactory.initElements(new CustomFieldDecorator(WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance()), this);
    }

    private String getLanguageTriggerLocator(Language language) {
        String locator = String.format(languageTriggerXpath, language.getValue());
        return locator;
    }

    public void clickSelectLanguage() {
        languageSelector.click();
    }

    public void selectLanguage(Language language) {
        Wait.getWebdriverWait().until(ExpectedConditions.visibilityOf(selectLanguagePanel));
        String languageTriggerLocator = getLanguageTriggerLocator(language);
        WebElement languageTrigger = WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance().findElement(By.xpath(languageTriggerLocator));
        Wait.getWebdriverWait().until(ExpectedConditions.elementToBeClickable(languageTrigger));
        languageTrigger.click();
    }

    public void clickSelectCurrency() {

    }

    public void selectCurrency(String currency) {

    }

    public void clickCarRentButton() {
        carRentButton.click();
    }

    public void clickFlightsButton() {
        flightsButton.click();
    }

}
