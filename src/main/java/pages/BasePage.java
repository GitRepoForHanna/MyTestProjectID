package pages;

import org.openqa.selenium.WebDriver;
import utils.webdriver.WebDriverInstance;

public abstract class BasePage {

    public BasePage() {
    }

    public WebDriver getDriver() {
        return WebDriverInstance.getWebDriver();
    }

}
