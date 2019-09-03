package pages.flights;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import utils.webdriver.Wait;
import utils.webdriver.WebDriverSingletoneInstance;

import java.util.List;

public class FlightsPage extends BasePage {

    @FindBy(xpath = "//input[@aria-label='Flight origin input' and @placeholder='From where?']")
    WebElement fromWhereInput;

    @FindBy(xpath = "//input[@aria-label='Flight destination input' and @placeholder='To where?']")
    WebElement toWhereInput;

    @FindBy(xpath = "//button[@title='Search flights']")
    WebElement searchButton;

    @FindBy(xpath = "//div[@role='dialog' and contains(@class,'smartbox-air-regions') and contains(@style,'display: inline')]")
    WebElement locationPanel;

    private String locationOptionXpath = "//li[@data-short-name='%s' and @role='option']";

    public FlightsPage() {
        PageFactory.initElements(WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance(), this);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void setWhereFromPoint(String locationFrom) {
        fromWhereInput.clear();
        fromWhereInput.sendKeys(locationFrom);
    }

    public String getWhereFromPoint() {
        return fromWhereInput.getText();
    }

    private WebElement getLocationOptionElement(String option) {
        String locator = String.format(locationOptionXpath, option);
        return WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance().findElement(By.xpath(locator));
    }

    public void selectLocationOption(String location) {
        Wait.getWebdriverWait().until(ExpectedConditions.visibilityOf(locationPanel));
        try {
            WebElement element = getLocationOptionElement(location);
            Wait.getWebdriverWait().until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }
        catch (Exception ex) {
            throw new RuntimeException("The Location point is not set");
        }
    }

    public void setWhereToPoint(String locationTo) {
        toWhereInput.clear();
        toWhereInput.sendKeys(locationTo);
    }

    private List<WebElement> getLocationOptionElements() {
        return getDriver().findElements(By.xpath(locationOptionXpath));
    }

    public boolean isOptionAvailable(String option, boolean expectedAvailability) {
        if(expectedAvailability) {
            Wait.getWebdriverWait().until(ExpectedConditions.visibilityOf(locationPanel));
       }
        try {
            if (locationPanel.isDisplayed()) {
                WebElement optionElement = getLocationOptionElement(option);
                return getLocationOptionElements().contains(optionElement);
            }
            return false;
        }
        catch (Exception e){
            return false;
        }
    }

}
