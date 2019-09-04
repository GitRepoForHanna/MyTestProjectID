package utils;

import org.apache.log4j.Logger;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import utils.webdriver.WebDriverSingletoneInstance;

public class ScreenShotListener extends RunListener {

    @Override
    public void testFailure(Failure failure) {
        try {
            ScreenShot.getScreenShot(WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance(), failure.getTestHeader());
        }
        catch (Exception e) {
            Logger.getLogger(failure.getDescription().toString()).error(e);
        }
    }
}
