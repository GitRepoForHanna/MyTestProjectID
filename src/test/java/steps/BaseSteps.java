package steps;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import pages.*;
import utils.ScreenShot;
import utils.webdriver.WebDriverSingletoneInstance;

public class BaseSteps {

    private WebDriverSingletoneInstance instance;
    private BasePage previousPage;
    private BasePage currentPage;

//    public BasePage getCurrentPage() {
//        return currentPage;
//    }


    public BaseSteps() {
        this.instance = WebDriverSingletoneInstance.getWebDriverSingletoneInstance();
    }

    @Before
    public void setUp() {

    }

    @After
    public void closeInstance() {
        System.out.println("After test - close driver");
        instance.closeDriver();
    }
}
