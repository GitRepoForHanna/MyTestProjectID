package pages.car_rent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import utils.webdriver.Wait;
import utils.webdriver.WebDriverSingletoneInstance;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CarPage extends BasePage {

    private static final Predicate<WebElement> IS_ELEMENT_DISPLAYED = element -> element.isDisplayed();
    private static final Consumer<WebElement> CLICK_ELEMENT = element -> element.click();

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

    @FindBy(xpath = "//div[@data-calendar2-type='checkin']/following-sibling::div[@class='c2-calendar']")
    private WebElement checkInCalendarPanel;

    @FindBy(xpath = "//div[@data-calendar2-type='checkout']/following-sibling::div[@class='c2-calendar']")
    private WebElement checkOutCalendarPanel;

    public CarPage() {
        PageFactory.initElements(WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance(), this);
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
        } catch (Exception ex) {
            throw new RuntimeException(String.format("Destination option %s was not founded", option));
        }
    }


    public void expandDatePicker(WebElement datePicker, WebElement dateInput) {
        if (!IS_ELEMENT_DISPLAYED.test(datePicker)) {
            CLICK_ELEMENT.accept(dateInput);
        }
    }



    public void expandCheckInCalendar() {
        expandDatePicker(checkInCalendarPanel, dateFromInput);
    }

    public void expandCheckOutCalendar() {
        expandDatePicker(checkOutCalendarPanel, dateToInput);
    }

}
