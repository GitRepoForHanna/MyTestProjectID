package pages.car_rent;

import model.components.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import utils.CustomFieldDecorator;
import utils.webdriver.Wait;
import utils.webdriver.WebDriverSingletoneInstance;

public class CarPage extends BasePage {

    @FindBy(id = "ss_origin")
    private WebElement destinationInput;

    private String destinationOptionXpath = "//li[contains(@class,'sb-autocomplete__item') and @data-value='%s']";

    @FindBy(xpath = "//ul[@role='listbox' and @aria-label='List of suggested destinations ']")
    private WebElement suggestedDestinationsPanel;

    @FindBy(className = "sb-searchbox__button")
    private Button searchButton;

    @FindBy(xpath = "//div[contains(@class,'xp__dates__checkin')]//button[@aria-label=\"Open calendar\"]")
    private WebElement dateFromInput;

    @FindBy(xpath = "//div[contains(@class,'xp__dates__checkout')]//button[@aria-label=\"Open calendar\"]")
    private WebElement dateToInput;

    @FindBy(xpath = "//div[@class='c2-calendar-header' and text()='Check-in']")
    private WebElement checkInDatePickerHeader;

    @FindBy(xpath = "//div[@class='c2-calendar-header' and text()='Check-out']")
    private WebElement checkOutDatePickerHeader;

    public CarPage() {
        PageFactory.initElements(new CustomFieldDecorator(WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance()), this);
    }

//    public boolean isCheckInDatePickerAvailable() {
//        return WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance().
//    }

    public boolean isCheckInDatePickerEnabled() {
        return checkInDatePickerHeader.isEnabled();
    }

//    public boolean isCheckOutDatePickerAvailable() {
//        return checkOutDatePickerHeader.isDisplayed();
//    }

    public boolean isCheckOutDatePickerEnabled() {
        return checkOutDatePickerHeader.isEnabled();
    }

    public void setDestination(String destination) {
        destinationInput.sendKeys(destination);
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
        return WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance().findElement(By.xpath(String.format(destinationOptionXpath, option)));
    }

    public void selectDestinationOption(String option) {
        try {
            Wait.getWebdriverWait().until(ExpectedConditions.visibilityOf(suggestedDestinationsPanel));
            WebElement element = getDestinationOptionElement(option);
            Wait.getWebdriverWait().until(ExpectedConditions.visibilityOf(element));
            element.click();
        }
        catch (Exception ex){
            throw new RuntimeException(String.format("Destination option %s was not founded", option));
        }

    }

}
