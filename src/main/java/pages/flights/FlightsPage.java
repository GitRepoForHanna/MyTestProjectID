package pages.flights;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import utils.webdriver.Wait;
import utils.webdriver.WebDriverInstance;

public class FlightsPage extends BasePage {

    @FindBy(xpath = "//input[@aria-label='Flight origin input' and @placeholder='From where?']")
    WebElement fromWhereInput;

    @FindBy(xpath = "//input[@aria-label='Flight origin input' and @placeholder='To where?']")
    WebElement toWhereInput;

    @FindBy(xpath = "//button[@title='Search flights']")
    WebElement searchButton;

    @FindBy(xpath = "//div[@role='dialog' and contains(@class,'smartbox-air-regions') and contains(@style,'display: inline')]")
    WebElement locationPanel;

    private String locationOptionXpath = "//li[@data-short-name='%s' and @role='option']";

    public FlightsPage() {
        PageFactory.initElements(WebDriverInstance.getDriverInstance(), this);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void setWhereFromPoint(String locationFrom) {
        new Actions(WebDriverInstance.getDriverInstance()).sendKeys(locationFrom).perform();
    }

    private WebElement getLocationOptionElement(String option) {
        String locator = String.format(locationOptionXpath, option);
        return WebDriverInstance.getDriverInstance().findElement(By.xpath(locator));
    }

    public void selectWhereFromOption(String location) {
        Wait.getWebdriverWait().until(ExpectedConditions.visibilityOf(locationPanel));
        try {
            WebElement element = getLocationOptionElement(location);
            Wait.getWebdriverWait().until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }
        catch (Exception ex) {
            throw new RuntimeException("The Where From location point is not set");
        }
    }
}
