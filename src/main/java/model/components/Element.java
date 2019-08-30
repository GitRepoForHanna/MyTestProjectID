package model.components;

import org.openqa.selenium.WebElement;

public class Element implements IElement{
    protected WebElement element;

    public Element(WebElement element) {
        this.element = element;
    }
}
