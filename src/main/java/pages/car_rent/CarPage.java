package pages.car_rent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import utils.webdriver.Wait;
import utils.webdriver.WebDriverInstance;

public class CarPage extends BasePage {

    @FindBy(id = "ss_origin")
    private WebElement destinationInput;

    private String destinationOptionXpath = "//li[contains(@class,'sb-autocomplete__item') and @data-value='%s']";

    @FindBy(xpath = "//ul[@role='listbox' and @aria-label='List of suggested destinations ']")
    private WebElement suggestedDestinationsPanel;

    @FindBy(className = "sb-searchbox__button")
    private WebElement searchButton;

    @FindBy(xpath = "//div[contains(@class,'xp__dates__checkin')]//button[@aria-label=\"Open calendar\"]")
    private WebElement dateFromInput;

    @FindBy(xpath = "//div[contains(@class,'xp__dates__checkout')]//button[@aria-label=\"Open calendar\"]")
    private WebElement dateToInput;

    public CarPage() {
        PageFactory.initElements(WebDriverInstance.getDriverInstance(), this);
    }

    public void setDestination(String destination) {
        destinationInput.click();
        new Actions(WebDriverInstance.getDriverInstance()).sendKeys(destination).perform();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickOnDateFromInput() {
        dateFromInput.click();
    }

    public void clickOnDateToInput() {
        dateToInput.click();
    }

    private WebElement getDestinationOptionElement(String option) {
        return WebDriverInstance.getDriverInstance().findElement(By.xpath(String.format(destinationOptionXpath, option)));
    }

    public void selectDestinationOption(String option) {
        Wait.getWebdriverWait().until(ExpectedConditions.visibilityOf(suggestedDestinationsPanel));
        WebElement element = getDestinationOptionElement(option);
        Wait.getWebdriverWait().until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

}
