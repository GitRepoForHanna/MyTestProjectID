package utils.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.PropertiesUtil;

import java.util.Properties;

public class WebDriverInstance {

    private static WebDriverInstance webDriverInstance;
    private WebDriver webDriver;
    private static ThreadLocal<WebDriverInstance> instances = new ThreadLocal<>();
    PropertiesUtil propertiesUtil = new PropertiesUtil("src//test/resources/config.properties");

    private WebDriver initDriver() {
        System.out.println("init driver");
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
        return webDriver;
    }

    public WebDriver getDriver() {
        System.out.println("get driver");
        return webDriver == null ? initDriver() : webDriver;
    }

    public static WebDriver getDriverInstance() {
        return getInstance().getDriver();
    }

    public static WebDriverInstance getInstance() {
        if(webDriverInstance == null) {
            System.out.println(Thread.currentThread().getName() + " thread creating new instance");
            webDriverInstance = new WebDriverInstance();
            instances.set(webDriverInstance);
        }
//        return webDriverInstance;
        return instances.get();
    }

    public void closeDriver() {
        System.out.println("close driver");
        webDriver.close();
        webDriver.quit();
//        instances.remove();
    }

//    private static ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<WebDriver>() {
//        @Override
//        protected WebDriver initialValue() {
//            System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--no-sandbox");
//            if(driver == null) {
//                driver = new ChromeDriver(options);
//            }
//            return driver;
//        }
//    };


    private WebDriverInstance() {

    }

//    synchronized public static WebDriver getWebDriver() {
////        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
////        ChromeOptions options = new ChromeOptions();
////        options.addArguments("--no-sandbox");
////        if(driver == null)
////            driver = new ChromeDriver(options);
////        return driver;
//        return THREAD_LOCAL.get();
//    }
}
