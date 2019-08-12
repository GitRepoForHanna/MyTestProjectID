package pages.homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import utils.Language;
import utils.webdriver.Wait;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id='user_form']//li[@data-id='language_selector']")
    private WebElement languageSelector;

    @FindBy(id = "current_language")
    private WebElement selectLanguagePanel;

    private static String languageTriggerXpath = "//li[@class='%s']//a";

    @FindBy(xpath = "//div[@id='user_form']//li[@data-id='currency_selector']")
    private WebElement currencySelector;

    @FindBy(linkText = "Car rentals")
    private WebElement carRentButton;

    public HomePage() {
        PageFactory.initElements(getDriver(), this);
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
        WebElement languageTrigger = getDriver().findElement(By.xpath(languageTriggerLocator));
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

}
