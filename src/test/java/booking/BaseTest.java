package booking;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import steps.CarPageSteps;
import steps.HomePageSteps;
import utils.webdriver.WebDriverInstance;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {

//    protected static final String URL = "https://www.booking.com";
    protected static final String URL = "https://www.booking.com";
    protected HomePageSteps homePageSteps = new HomePageSteps();   // в baseTest
    protected CarPageSteps carPageSteps = new CarPageSteps();

    protected WebDriverInstance instance;
    private InputStream input;

    private Properties properties = new Properties();

    protected Properties getProperties() {
        return properties;
    }

    public BaseTest() {
        System.out.println("BaseTest Constructor");
        try {
            input = new FileInputStream("src//test/resources/config.properties");
            properties.load(input);
        }
        catch(Exception ex) {
            Logger.getLogger(this.getClass().getName()).error("Properties are not loaded");
        }

        WebDriverInstance.getDriverInstance();
        System.out.println("Root path -> " + Thread.currentThread().getContextClassLoader().getResource("").getPath());
    }




//    protected void setUp() {
//        getWebDriverInstance().manage().window().maximize();
//    }
//
//    protected void tearDown() {
//        WebDriverInstance.getInstance().closeDriver();
//    }
//
//    @BeforeTest
//    public void beforeTest() {
//        getWebDriverInstance().manage().window().maximize();
//    }
//
//    @AfterTest
//    public void closeDriver() {
//        WebDriverInstance.getInstance().closeDriver();
//    }

    protected void initWebDriverInstance() {
        System.out.println(Thread.currentThread().getName() + "CREATING WEBDRIVER INSTANCE");
        instance = WebDriverInstance.getInstance(); // instance=null
    }

    public void navigateTo(String url) {
        initWebDriverInstance();
        WebDriverInstance.getDriverInstance().get(url);
    }
}
