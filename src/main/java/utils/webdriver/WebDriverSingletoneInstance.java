package utils.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSingletoneInstance {

    private static WebDriverSingletoneInstance instance;
    private WebDriver webDriver;

    private WebDriverSingletoneInstance() {
        initDriver();
    }

    protected WebDriver initDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        webDriver = new ChromeDriver(options);
        System.out.println("[" + Thread.currentThread().getName() + "] - init webdriver: " + webDriver);
        webDriver.manage().window().maximize();
        return webDriver;
    }

    private static ThreadLocal<WebDriverSingletoneInstance> threadLocal = new ThreadLocal<WebDriverSingletoneInstance>(){
        @Override
        protected WebDriverSingletoneInstance initialValue() {
            System.out.println("initialValue for thread: " + Thread.currentThread().getName());
            if (null == instance){
                instance = new WebDriverSingletoneInstance();
            }
            return instance;
        }
    };

    public static WebDriverSingletoneInstance getWebDriverSingletoneInstance() {
        return threadLocal.get();
    }

    public WebDriver getWebDriverInstance() {
        return getWebDriverSingletoneInstance().webDriver;
    }

    public void closeDriver() {
        System.out.println("[" + Thread.currentThread().getName() + "] - closing");
        getWebDriverInstance().close();
        getWebDriverInstance().quit();
    }
}
