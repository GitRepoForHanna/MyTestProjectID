package utils.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverInstance {
    private static WebDriver driver;

    private WebDriverInstance() {

    }

    public static WebDriver getWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        if(driver == null)
            driver = new ChromeDriver(options);
        return driver;
    }
}
