package model.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.HighlightElement;
import utils.webdriver.Wait;

public class Button extends Element{

    public Button(WebElement element) {
        super(element);
    }

    public void click() {
        Wait.getWebdriverWait().until(ExpectedConditions.elementToBeClickable(element));
        HighlightElement.highlightElement(element);
        element.click();
    }
}
