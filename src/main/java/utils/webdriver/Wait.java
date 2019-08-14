package utils.webdriver;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    public Wait() {

    }

    public static WebDriverWait getWebdriverWait() {
        return new WebDriverWait(WebDriverInstance.getInstance().getDriver(), 10);
    }
}
