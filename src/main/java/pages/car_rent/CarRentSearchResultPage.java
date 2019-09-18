package pages.car_rent;

import business_objects.car.CarOption;
import business_objects.car.SuppliersOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import business_objects.car.CarConfigurationMenu;
import utils.webdriver.JSWaiter;
import utils.webdriver.Wait;
import utils.webdriver.WebDriverSingletoneInstance;

import java.util.List;

public class CarRentSearchResultPage extends BasePage {

    private String carCategoryOption = "//span[text()='%s']//ancestor::a[1]";
    private String checkBoxLocatorPattern = "//ul[@id='%s']//li";

    @FindBy(className = "sr-CarCategories-row")
    WebElement carCategoriesPanel;

    @FindBy(className = "carResultDiv")
    WebElement resultDiv;

    @FindBy(className = "carResultRow_CarDetails")
    WebElement carDetails;

    @FindBy(id = "supplier-filter-content")
    WebElement suppliersPanel;

    @FindBy(id = "rating-filter-content")
    WebElement supplierRatingPanel;

    @FindBy(id = "airport_loctype-filter-content")
    WebElement supplierLocationPanel;

    @FindBy(id = "fuel-filter-content")
    WebElement fuelOptionsPanel;

    @FindBy(id = "aircon-filter-content")
    WebElement carSpecificationsPanel;

    @FindBy(id = "groupsize-filter-content")
    WebElement groupSizePanel;

    @FindBy(id = "damage-excess-filter-content")
    WebElement damageExcessPanel;

    @FindBy(id = "deposit-filter-content")
    WebElement depositAtPickUpPanel;

    @FindBy(id = "card-filter-content")
    WebElement paymentCardsPanel;

    @FindBy(id = "mileage-filter-content")
    WebElement kilometersPanel;

    public CarRentSearchResultPage() {
        WebDriver webDriver = WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance();
        PageFactory.initElements(webDriver, this);
        JSWaiter.waitUntilJSReady(webDriver);
        closeJSBanner();
    }

    public void selectCarCategory(String category) {
        Wait.waitParticularState(() -> carCategoriesPanel.isDisplayed(), 25, 100);
        String categoryLocator = String.format(carCategoryOption, category);
        WebElement categoryElement = carCategoriesPanel.findElement(By.xpath(categoryLocator));
        Wait.waitParticularState(categoryElement::isDisplayed);
        categoryElement.click();
    }

    public List<WebElement> getCheckBoxes(CarConfigurationMenu menu) {
        return WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance().findElements(By.xpath(String.format(checkBoxLocatorPattern, menu.getMenuItem())));
    }

    public List<WebElement> getCheckBoxes(String attributeValue) {
        return WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance().findElements(By.xpath(String.format(checkBoxLocatorPattern, attributeValue)));
    }

    public WebElement getCheckBoxElement(CarOption option) {
        return getCheckBoxes(option.getConfigurationGroup()).stream()
                .filter(e -> e.getText().trim().equals(option.getConfigurationOption()))
                .findFirst()
                .get();
    }

    public WebElement getCheckBoxElementByIndex(CarOption option) {
        return getCheckBoxes(option.getConfigurationGroup()).get(Integer.parseInt(option.getConfigurationOption()));
    }

    public String isOptionChecked(CarOption option) {
        return getCheckBoxElement(option).findElement(By.tagName("div")).getAttribute("checked");
    }

    public String isOptionEnabled(CarOption option) {
        return getCheckBoxElement(option).findElement(By.tagName("div")).getAttribute("disabled");
    }

    public String isOptionChecked(WebElement element) {
        return element.getAttribute("checked");
    }

    public String isOptionEnabled(WebElement element) {
        return element.getAttribute("disabled");
    }

    public void checkOption(CarOption group) {
        WebDriver webDriver = WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance();
        WebElement element = getCheckBoxElement(group);
        Wait.waitParticularState(element::isEnabled, 15, 100);
        if(isOptionChecked(element) == null && isOptionEnabled(element) == null) {
            new Actions(webDriver).moveToElement(element.findElement(By.tagName("label"))).click().perform();
            JSWaiter.waitUntilJSReady(webDriver);
        }
    }

    public void checkOptionByIndex(CarOption group) {
        WebElement element = getCheckBoxElementByIndex(group);
        Wait.waitParticularState(element::isEnabled, 15, 100);
        if(isOptionChecked(element) == null && isOptionEnabled(element) == null) {
            new Actions(WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance()).moveToElement(element.findElement(By.tagName("label"))).click().perform();
            JSWaiter.waitUntilJSReady(WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance());
        }
    }

}
