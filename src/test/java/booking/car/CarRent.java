package booking.car;

import booking.BaseTest;
import io.qameta.allure.Description;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ITest;
import utils.Language;
import booking.dataprovider.CarRentingDataProvider;
import utils.ScreenShot;
import utils.dataProviders.CarRentingDataTemplate;
import utils.webdriver.WebDriverInstance;

import java.time.LocalDate;


public class CarRent extends BaseTest {

//    @BeforeTest
//    protected void setUp() {
//        initWebDriverInstance();
//        instance.getDriver().manage().window().maximize();
//    }

    @AfterTest
    protected void tearDown() {
//        if(ITestResult.FAILURE == Reporter.getCurrentTestResult().getStatus()){
//            try{
//                ScreenShot.getScreenShot(instance.getDriver(), "/target/".concat(LocalDate.now().toString().replace(":","-")));
//            }
//            catch (Exception ex){
//                Logger.getLogger(this.getClass().getName()).error(ex);
//            }
//        }
        instance.closeDriver();
    }

    @Test(dataProvider = "CarRentingData",dataProviderClass = CarRentingDataProvider.class, groups = "Car")
    @Description("Test car renting opportunity")
    public void RentCarInLondon(CarRentingDataTemplate data) throws InterruptedException, NoSuchMethodException {
        System.out.println("RentCarInLondon");
        System.out.println(Thread.currentThread().getName());
        Logger log = Logger.getLogger(this.getClass().getName());
        log.debug("Open Browser");
        navigateTo(getProperties().getProperty("booking.com.url"));
        log.info("Select Language");
        homePageSteps.selectLanguage(Language.UK);
        log.info("Gp to renting car page");
        homePageSteps.clickCarRentButton();
        log.info("Setting car renting parameters");
        carPageSteps.setDestination(data.getShortDestination(), data.getDestination());
        carPageSteps.setRentingDateFrom(LocalDate.of(data.getCheckInYear(), data.getCheckInMonth(), data.getCheckInDay()));
        carPageSteps.setRentingDateTo(LocalDate.of(data.getCheckOutYear(),data.getCheckOutMonth(),data.getCheckOutDay()));
        carPageSteps.clickSearchButton();
        log.debug("Test completed");
        ScreenShot.getScreenShot(instance.getDriver(), "target/test.png");
        Thread.sleep(5000);
    }

}
