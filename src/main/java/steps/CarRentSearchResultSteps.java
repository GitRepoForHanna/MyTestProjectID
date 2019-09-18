package steps;

import business_objects.ICheckBoxGroup;
import business_objects.car.*;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.car_rent.CarRentSearchResultPage;
import utils.webdriver.JSWaiter;
import utils.webdriver.WebDriverSingletoneInstance;
import java.util.List;

public class CarRentSearchResultSteps {

    @Step("Set Car Category {0}")
    public void setCarCategory(String category) {
        Logger.getLogger(CarRentSearchResultSteps.class).info(String.format("Set Car Category %s", category));
        new CarRentSearchResultPage().selectCarCategory(category);
    }

    public void setOptions(List<? extends ICheckBoxGroup> options) {
        CarRentSearchResultPage searchResultPage = new CarRentSearchResultPage();
        WebDriver webDriver = WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance();
        JSWaiter.waitUntilJSReady(webDriver);
        options.stream()
                .map(e -> ((ICheckBoxGroup) e).getOption())
                .forEach(searchResultPage::checkOption);
    }

    public void setOptionsByIndex(List<? extends ICheckBoxGroup> options) {
        CarRentSearchResultPage searchResultPage = new CarRentSearchResultPage();
        WebDriver webDriver = WebDriverSingletoneInstance.getWebDriverSingletoneInstance().getWebDriverInstance();
        JSWaiter.waitUntilJSReady(webDriver);
        options.stream()
                .map(e -> ((ICheckBoxGroup) e).getOption())
                .forEach(searchResultPage::checkOptionByIndex);
    }

    @Step("Set Car Configuration {0}")
    public void setCarConfiguration(CarBuilder.Car carConfiguration) {
        if(carConfiguration.getSuppliers() != null) {
            List<SuppliersOptions> suppliers = carConfiguration.getSuppliers();
            Logger.getLogger(CarRentSearchResultSteps.class).info(String.format("Set Car Suppliers %s", suppliers));
            setOptions(suppliers);
        }

        if(carConfiguration.getSpecifications() != null) {
            List<CarSpecification> specifications = carConfiguration.getSpecifications();
            Logger.getLogger(CarRentSearchResultSteps.class).info(String.format("Set Car Specifications %s", specifications));
            setOptions(specifications);
        }

        if(carConfiguration.getSupplierLocations() != null) {
            List<SupplierLocation> locations = carConfiguration.getSupplierLocations();
            Logger.getLogger(CarRentSearchResultSteps.class).info(String.format("Set Supplier Location %s", locations));
            setOptions(locations);
        }

        if(carConfiguration.getSupplierRatings() != null) {
            List<SupplierRating> ratings = carConfiguration.getSupplierRatings();
            Logger.getLogger(CarRentSearchResultSteps.class).info(String.format("Set Supplier Raiting %s", ratings));
            setOptions(ratings);
        }

        if(carConfiguration.getPartySizes() != null) {
            List<PartySize> partySizes = carConfiguration.getPartySizes();
            Logger.getLogger(CarRentSearchResultSteps.class).info(String.format("Set Party Size %s", partySizes));
            setOptions(partySizes);
        }

        if(carConfiguration.getFuelPolicies() != null) {
            List<FuelPolicy> policies = carConfiguration.getFuelPolicies();
            Logger.getLogger(CarRentSearchResultSteps.class).info(String.format("Set Fuel Policies %s", policies));
            setOptions(policies);
        }

        if(carConfiguration.getKilometres() != null) {
            List<Kilometres> kilometres = carConfiguration.getKilometres();
            Logger.getLogger(CarRentSearchResultSteps.class).info(String.format("Set Kilometres %s", kilometres));
            setOptions(kilometres);
        }

        if(carConfiguration.getPaymentCards() != null) {
            List<PaymentCard> paymentCards = carConfiguration.getPaymentCards();
            Logger.getLogger(CarRentSearchResultSteps.class).info(String.format("Set Payment Cards %s", paymentCards));
            setOptions(paymentCards);
        }

        if(carConfiguration.getDepositAtPickUps() != null) {
            List<DepositAtPickUp> deposits = carConfiguration.getDepositAtPickUps();
            Logger.getLogger(CarRentSearchResultSteps.class).info(String.format("Set Deposits At Pick Up %s", deposits));
            setOptionsByIndex(deposits);
        }

        if(carConfiguration.getDamageExcesses() != null) {
            List<DamageExcess> excesses = carConfiguration.getDamageExcesses();
            Logger.getLogger(CarRentSearchResultSteps.class).info(String.format("Set Damage Excesses %s", excesses));
            setOptionsByIndex(excesses);
        }
    }

}
