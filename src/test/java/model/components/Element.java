package model.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Element implements IElement{
    protected WebElement element;

    public Element(WebElement element) {
        this.element = element;
    }

    public Element(By by) {

    }
}
