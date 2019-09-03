package steps;

import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import pages.*;
import utils.ScreenShot;
import utils.webdriver.WebDriverSingletoneInstance;

public class BaseSteps {
//
//    private WebDriverSingletoneInstance instance;
//    private BasePage previousPage;
//    private BasePage currentPage;
//
//    public BasePage getCurrentPage() {
//        return currentPage;
//    }

    @Rule
    TestRule listener = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            ScreenShot.getScreenShot(WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance(),description.getMethodName());
            super.failed(e, description);
        }
    };

}
