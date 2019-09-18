package utils.webdriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.webdriver.Wait.TIMEOUT;

public class JSWaiter {
    private static WebDriver jsWaitDriver;
    private static WebDriverWait jsWaiter;
    private static JavascriptExecutor jsExecutor;
    private static final String JS_LOADED_SCRIPT = "return jQuery.active";
    private static final String JS_READY_STATE_SCRIPT = "return document.readyState";
    private static final String JS_COMPLETED_READY_STATE = "complete";

    public JSWaiter(WebDriver driver) {
        this.jsWaitDriver = driver;
        jsWaiter = new WebDriverWait(driver, TIMEOUT);
        jsExecutor = (JavascriptExecutor)jsWaitDriver;
    }

    public void waitUntilJSLoaded() {
        Wait.waitParticularState(() -> ((Long)jsExecutor.executeScript(JS_LOADED_SCRIPT) == 0));
    }

    public void waitUntilJSCompleted() {
        Wait.waitParticularState(() -> jsExecutor.executeScript(JS_READY_STATE_SCRIPT).equals(JS_COMPLETED_READY_STATE));
    }

    public static void waitUntilJSReady(WebDriver webDriver) {
        JSWaiter waiter = new JSWaiter(webDriver);
        waiter.waitUntilJSLoaded();
        waiter.waitUntilJSCompleted();
    }
}
