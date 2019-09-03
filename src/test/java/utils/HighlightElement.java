package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.webdriver.WebDriverSingletoneInstance;

public class HighlightElement {

    public static void highlightElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance();
        executor.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", element);
        executor.executeScript("arguments[0].style.border=''", element, "");
    }
}
