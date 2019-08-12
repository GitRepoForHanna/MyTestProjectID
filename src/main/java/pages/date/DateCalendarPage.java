package pages.date;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import utils.UIAttributes;

import java.time.LocalDate;

public class DateCalendarPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'xp__dates__checkin')]//div[contains(@class,'c2-button-further')]")
    private WebElement dateFromFurtherButton;

    @FindBy(xpath = "//div[contains(@class,'xp__dates__checkin')]//div[contains(@class,'c2-button-earlier')]")
    private WebElement dateFromEarlierButton;

    @FindBy(xpath = "//div[contains(@class,'xp__dates__checkin')]//div[contains(@class,'c2-button-earlier')]")
    private WebElement dateFromDay;

    private static String dateTableHeaderXpath = "//div[contains(@class,'%1s')]//table//th[text()='%2s %d']";

    private static String dateTableCellXpath = "//div[contains(@class,'%1s')]//th[contains(text(),'%2s %1d')]//ancestor::table[1]//td/span[contains(text(),'%2d')]";

    public DateCalendarPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public LocalDate getCurrentData() {
        return LocalDate.now();
    }

    public String getDateFromTableLocator(LocalDate date) {
        String monthName = date.getMonth().name();
        int yearFrom = date.getYear();
        return String.format(dateTableHeaderXpath, UIAttributes.DATE_FROM_CLASS, StringUtils.capitalize(monthName.toLowerCase()), yearFrom);
    }

    public WebElement getDateTableElement(String locator) {
        return getDriver().findElement(By.xpath(locator));
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
        return getDriver().findElement(By.xpath(locator));
    }

    public void setDateFrom(LocalDate date) throws InterruptedException {
        if (date.isAfter(LocalDate.now())) {
            String tableLocator = getDateFromTableLocator(date);
            if(getDriver().findElements(By.xpath(tableLocator)).size() == 1) {
                while (!getDateTableElement(tableLocator).isEnabled()) {
                    dateFromFurtherButton.click();
                }
            }
        }
        getDateTableCell(getDateTableFromCellLocator(date)).click();
        Thread.sleep(4000);
    }

    public void setDateTo(LocalDate date) throws InterruptedException {
        if (date.isAfter(LocalDate.now())) {
            String tableLocator = getDateTableToLocator(date);
            if(getDriver().findElements(By.xpath(getDateTableToLocator(date))).size() == 1) {
                while (!getDateTableElement(tableLocator).isEnabled()) {
                    dateFromFurtherButton.click();
                }
            }
        }
        getDateTableCell(getDateTableToCellLocator(date)).click();
        Thread.sleep(4000);
    }

}
