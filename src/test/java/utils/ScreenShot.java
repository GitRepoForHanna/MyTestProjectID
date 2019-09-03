package utils;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenShot {

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] getScreenShot(WebDriver webdriver, String methodName) {
        TakesScreenshot screenshotTaker = (TakesScreenshot) webdriver;
        File scrFile = screenshotTaker.getScreenshotAs(OutputType.FILE);

        String pathToScreenShot = String.format("/screenshot/%s_%s.png", methodName, new Date().getTime());
        File resultFile = new File(pathToScreenShot);
        try {
            Logger.getLogger("ScreenShot").info("Screenshot is captures to" + pathToScreenShot);
            FileUtils.copyFile(scrFile, resultFile);
            return FileUtils.readFileToByteArray(resultFile);
        }
        catch (IOException e) {
            Logger.getLogger(ScreenShot.class).error(e);
        }
        return null;
    }
}
