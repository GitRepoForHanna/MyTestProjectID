package utils.webdriver;
import com.google.common.collect.ImmutableMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.exceptions.ScenarioException;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;

public class Wait {

    public static final long TIMEOUT = 15;
    public static final long POLLING_TIME = 100;

    public Wait() {

    }

    public static WebDriverWait getWebdriverWait() {
        return new WebDriverWait(WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance(), 10);
    }


    public static void waitParticularState(Callable<Boolean> state) {
        waitParticularState(state, TIMEOUT, POLLING_TIME);
    }

    public static void waitParticularState(Callable<Boolean> state, long timeout) {
        waitParticularState(state, timeout, POLLING_TIME);
    }

    public static void waitParticularState(Callable<Boolean>state, long timeout, long pollingTime) {
            Logger logger = Logger.getLogger("Waiting for some condition");
            new WebDriverWait(WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance(), timeout, pollingTime)
                      .until((ExpectedCondition<Boolean>) webDriver -> {
                        try {
                            return state.call();
                        }catch (NoSuchElementException e){
                            throw new ScenarioException("Element does not exists: ");
                        }catch (WebDriverException e) {
                            logger.error(e.getLocalizedMessage());
                        }catch (Exception e) {
                            logger.error(e.getLocalizedMessage());
                        }
                        return false;
                    });
    }

    public static void fluentWaitParticularState(Callable<Boolean> state, long timeout, long pollingTime) {
        Logger logger = Logger.getLogger("Waiting for some condition");
        new FluentWait<>(WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance())
                .pollingEvery(Duration.ofMillis(pollingTime))
                .withTimeout(Duration.ofSeconds(timeout))
                .until((ExpectedCondition<Boolean>) webDriver -> {
                   try {
                        return state.call();
                   }catch (NoSuchElementException e){
                        throw new ScenarioException("\nElement does not exists" +
                               e.getLocalizedMessage());
                   }catch (StaleElementReferenceException e){
                       throw new ScenarioException("Stale Element Referenced Exception " +
                               "\n" + e.getLocalizedMessage());
                   }catch(WebDriverException e) {
                       logger.info(e.getLocalizedMessage());
                   }catch (Exception e) {
                        logger.info(e.getLocalizedMessage());
                   }
                    return false;
                });
    }

//    public static void main(String[] args) {
//        fluentWaitParticularState(() -> WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance().findElement(By.xpath("dfgdfg")).isDisplayed(), TIMEOUT, POLLING_TIME);
//    }

    @Test
    public void asdasd() {
        String elementXPath = "dfgdfg";
            fluentWaitParticularState(() -> WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance().findElement(By.xpath(elementXPath)).isDisplayed(), 5, 500);
    }

}
