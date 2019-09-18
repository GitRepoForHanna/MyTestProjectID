package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.webdriver.WebDriverSingletoneInstance;

public abstract class BasePage {

    protected String inputValueLocatorPattern = "//input[@value='%s']";
    protected String inputIdLocatorPattern = "//input[@id='%s']";
    protected String inputNameLocatorPattern = "//input[@name='%s']";
    protected String spanTextLocatorPattern = "//span[text()='%s']";
    private By jsCookieBanner = By.id("js-closeCookieBanner");

    protected void closeJSBanner() {
        WebDriver webDriver = WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance();
        if(webDriver.findElements(jsCookieBanner).size() == 1){
            WebElement bannerElement = webDriver.findElement(jsCookieBanner);
            if(bannerElement.isDisplayed()){
                bannerElement.click();
            }
        }
    }

}
