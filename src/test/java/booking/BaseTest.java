package booking;

import org.apache.log4j.Logger;
import org.apache.sling.api.resource.*;
import org.apache.sling.spi.resource.provider.ResourceProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import steps.CarPageSteps;
import steps.HomePageSteps;
import utils.PropertiesUtil;
import utils.webdriver.WebDriverInstance;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class BaseTest {

//    protected static final String URL = "https://www.booking.com";
    protected static final String URL = "https://www.booking.com";
    protected HomePageSteps homePageSteps = new HomePageSteps();   // в baseTest
    protected CarPageSteps carPageSteps = new CarPageSteps();

    protected WebDriverInstance instance;
    private InputStream input;

    protected PropertiesUtil properties = new PropertiesUtil("src//test/resources/config.properties");

    protected ResourceBundle resourceBundle;
//    protected ResourceProvider resourceProvider;
    ResourceResolverFactory resourceResolverFactory;

    public BaseTest() {
        System.out.println("BaseTest Constructor");
        WebDriverInstance.getDriverInstance();
        try {
            ResourceResolver resolver = resourceResolverFactory.getAdministrativeResourceResolver(null);
            Resource resource = resolver.getResource("src//test/resources/configfile");
        }
        catch (LoginException ex) {

        }
    }

    public ResourceBundle getResourceBundle(String resourceBundleName) {
        return  ResourceBundle.getBundle(resourceBundleName);
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
