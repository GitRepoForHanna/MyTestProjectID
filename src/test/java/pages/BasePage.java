package pages;

import org.openqa.selenium.WebDriver;
import utils.webdriver.WebDriverSingletoneInstance;

public abstract class BasePage {

    public BasePage() {
        //PageFactory.initElements(WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance(), this);
    }

    private WebDriverSingletoneInstance instance;

//    @BeforeTest  testNG
    public void beforeTest(){
        instance = WebDriverSingletoneInstance.getWebDriverSingletoneInstance();
    }

//    @AfterTest
    public void closeDriver(){
        instance.closeDriver();
    }

    public WebDriver getDriver() {
        return WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance();
    }
}
