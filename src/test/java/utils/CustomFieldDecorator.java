package utils;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Field;

public class CustomFieldDecorator extends DefaultFieldDecorator {

    public CustomFieldDecorator(SearchContext searchContext) {
        super(new DefaultElementLocatorFactory(searchContext));
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        Class<?> decorableClass = decoratableClass(field);
        if(decorableClass != null) {
            ElementLocator locator = factory.createLocator(field);
            if(locator == null) {
                return null;
            }
            return createElement(loader, locator, decorableClass);
        }
        return super.decorate(loader, field);
    }

    private Class<?> decoratableClass(Field field) {
        if(field != null){
            Class<?> klass = field.getType();
            try {
                klass.getConstructor(WebElement.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                return null;
            }
            return klass;
        }
        return null;
    }

    protected <T> T createElement(ClassLoader loader, ElementLocator locator, Class<T> klass) {
        if(locator != null) {
            WebElement proxy = proxyForLocator(loader, locator);
            return createInstance(klass, proxy);
        }
        return null;
    }

    private <T> T createInstance(Class<T> klass, WebElement element) {
        try {
            return (T)klass.getConstructor(WebElement.class).newInstance(element);
        } catch (Exception e) {
            throw new RuntimeException("WebElement can't be represented as " + klass);
        }
    }

}

