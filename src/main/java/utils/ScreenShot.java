package utils;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.io.File;
import java.io.IOException;

public class ScreenShot {

    public static void getScreenShot(WebDriver webdriver, String pathToFile) {
        TakesScreenshot screenshotTaker = (TakesScreenshot) webdriver;
        File scrFile = screenshotTaker.getScreenshotAs(OutputType.FILE);
        File resultFile = new File(pathToFile);
        try {
            FileUtils.copyFile(scrFile, resultFile);
        } catch (IOException e) {
            Logger.getLogger(ScreenShot.class).error(e);
        }
    }
}
