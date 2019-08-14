package booking;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import steps.CarPageSteps;
import steps.HomePageSteps;
import utils.webdriver.WebDriverInstance;

public class BaseTest {

    protected static final String URL = "https://www.booking.com";
    protected HomePageSteps homePageSteps = new HomePageSteps();   // в baseTest
    protected CarPageSteps carPageSteps = new CarPageSteps();

    protected WebDriverInstance instance;

    public BaseTest() {
        System.out.println("BaseTest Constructor");
        WebDriverInstance.getDriverInstance();
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
