package pages.date;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import utils.UIAttributes;
import utils.webdriver.WebDriverSingletoneInstance;

import java.time.LocalDate;

public class DateCalendarPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'xp__dates__checkin')]//div[contains(@class,'c2-button-further')]")
    private WebElement furtherButton;

    @FindBy(xpath = "//div[contains(@class,'xp__dates__checkin')]//div[contains(@class,'c2-button-earlier')]")
    private WebElement earlierButton;

//    @FindBy(xpath = "//div[contains(@class,'xp__dates__checkin')]//div[contains(@class,'c2-button-earlier')]")
//    private WebElement dateFromDay;

    private static String dateTableHeaderXpath = "//div[contains(@class,'%1s')]//table//th[text()='%2s %d']";

    private static String dateTableCellXpath = "//div[contains(@class,'%s')]//th[contains(text(),'%s %d')]//ancestor::table[1]//td/span[contains(text(),'%d')]";

    public DateCalendarPage() {
        PageFactory.initElements(WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance(), this);
    }

    public LocalDate getCurrentData() {
        return LocalDate.now();
    }

    public String getStartDatePickerLocator(LocalDate date) {
        String monthName = date.getMonth().name();
        int yearFrom = date.getYear();
        return String.format(dateTableHeaderXpath, UIAttributes.DATE_FROM_CLASS, StringUtils.capitalize(monthName.toLowerCase()), yearFrom);
    }

    public WebElement getDateTableElement(String locator) {
        return WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance().findElement(By.xpath(locator));
    }

    public String getDateTableToLocator(LocalDate date) {
        String monthName = date.getMonth().name();
        int yearFrom = date.getYear();
        return String.format(dateTableHeaderXpath,UIAttributes.DATE_TO_CLASS, StringUtils.capitalize(monthName.toLowerCase()), yearFrom);
    }

    public String getDateTableFromCellLocator(LocalDate date) {
        String monthName = date.getMonth().name();
        int day = date.getDayOfMonth();
        int yearFrom = date.getYear();
        return String.format(dateTableCellXpath, UIAttributes.DATE_FROM_CLASS, StringUtils.capitalize(monthName.toLowerCase()), yearFrom, day);
    }

    public String getDateTableToCellLocator(LocalDate date) {
        String monthName = date.getMonth().name();
        int day = date.getDayOfMonth();
        int yearFrom = date.getYear();
        return String.format(dateTableCellXpath, UIAttributes.DATE_TO_CLASS, StringUtils.capitalize(monthName.toLowerCase()), yearFrom, day);
    }

    public WebElement getDateTableCell(String locator) {
        return WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance().findElement(By.xpath(locator));
    }

    public void setDateFrom(LocalDate date) throws InterruptedException {
        if (date.isAfter(LocalDate.now())) {
            String pickerLocator = getStartDatePickerLocator(date);
            if(WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance().findElements(By.xpath(pickerLocator)).size() == 1) {
                while (!getDateTableElement(pickerLocator).isEnabled()) {
                    furtherButton.click();
                }
            }
            else {
                Logger.getLogger(this.getClass().getName()).error("The calendar isn't visible");
            }
        }
        getDateTableCell(getDateTableFromCellLocator(date)).click();
    }

    public void setDateTo(LocalDate date) throws InterruptedException {
        if (date.isAfter(LocalDate.now())) {
            String tableLocator = getDateTableToLocator(date);
            if(WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance().findElements(By.xpath(getDateTableToLocator(date))).size() == 1) {
                while (!getDateTableElement(tableLocator).isEnabled()) {
                    furtherButton.click();
                }
            }
        }
        getDateTableCell(getDateTableToCellLocator(date)).click();
        Thread.sleep(4000);
    }

}
