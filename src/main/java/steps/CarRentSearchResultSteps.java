package steps;

import business_objects.ICheckBoxGroup;
import business_objects.car.*;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.car_rent.CarRentSearchResultPage;
import utils.webdriver.JSWaiter;
import utils.webdriver.WebDriverSingletoneInstance;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class CarRentSearchResultSteps {

    @Step("Set Car Category {0}")
    public void setCarCategory(String category) {
        Logger.getLogger(CarRentSearchResultSteps.class).info(String.format("Set Car Category %s", category));
        new CarRentSearchResultPage().selectCarCategory(category);
    }

    @Step("Set Suppliers {0}")
    public void setSuppliers(List<SuppliersOptions> suppliers) {
        Logger.getLogger(CarRentSearchResultSteps.class).info(String.format("Set Car Suppliers %s", suppliers));
        setOptions(suppliers);
    }

    @Step("Set Party Size {0}")
    public void setPartySize(List<PartySize> partySizes) {
        Logger.getLogger(CarRentSearchResultSteps.class).info(String.format("Set Car Party Size %s", partySizes));
        setOptions(partySizes);
    }

    @Step("Set Payment Cards {0}")
    public void setPaymentCard(List<PaymentCard> cards) {
        Logger.getLogger(CarRentSearchResultSteps.class).info(String.format("Set Payment Cards %s", cards));
        setOptions(cards);
     }

    @Step("Set Supplier Raitings {0}")
    public void setSuppliersRaititng(List<SupplierRating> raitings) {
        Logger.getLogger(CarRentSearchResultSteps.class).info(String.format("Set Supplier Raitings %s", raitings));
        setOptions(raitings);
        }

    @Step("Set Supplier Location {0}")
    public void setSuppliersLocation(List<SupplierLocation> locations) {
        Logger.getLogger(CarRentSearchResultSteps.class).info(String.format("Set Suppliers Locations %s", locations));
        setOptions(locations);
    }

    @Step("Set Car Specification {0}")
    public void setCarSpecifications(List<CarSpecification> specifications) {
        Logger.getLogger(CarRentSearchResultSteps.class).info(String.format("Set Car Specifications %s", specifications));
        setOptions(specifications);
    }

    @Step("Set Car Kilometres {0}")
    public void setCarKilometres(List<Kilometres> kilometres) {
        Logger.getLogger(CarRentSearchResultSteps.class).info(String.format("Set Car Kilometres %s", kilometres));
        setOptions(kilometres);
    }

    @Step("Set Fuel Options {0}")
    public void setFuelOptions(List<FuelPolicy> fuelPolicies) {
        Logger.getLogger(CarRentSearchResultSteps.class).info(String.format("Set Fuel Options %s", fuelPolicies));
        setOptions(fuelPolicies);
    }

    @Step("Set Damage Excess {0}")
    public void setDamageExcess(List<DamageExcess> damageExcess) {
        Logger.getLogger(CarRentSearchResultSteps.class).info(String.format("Set Damage Excess  %s", damageExcess));
        setOptionsByIndex(damageExcess);
    }

    @Step("Set Deposit At Pick Up {0}")
    public void setDepositAtPickUp(List<DepositAtPickUp> deposits) {
        Logger.getLogger(CarRentSearchResultSteps.class).info(String.format("Set Deposit At Pick Up  %s", deposits));
        setOptionsByIndex(deposits);
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

    public void setCarConfiguration(CarBuilder.Car carConfiguration) {
        if(carConfiguration.getSuppliers() != null) {
            setOptions(carConfiguration.getSuppliers());
        }

        if(carConfiguration.getSpecifications() != null) {
            setOptions(carConfiguration.getSpecifications());
        }

        if(carConfiguration.getSupplierLocations() != null) {
            setOptions(carConfiguration.getSupplierLocations());
        }

        if(carConfiguration.getSupplierRatings() != null) {
            setOptions(carConfiguration.getSupplierRatings());
        }

        if(carConfiguration.getPartySizes() != null) {
            setOptions(carConfiguration.getPartySizes());
        }

        if(carConfiguration.getFuelPolicies() != null) {
            setOptions(carConfiguration.getFuelPolicies());
        }

        if(carConfiguration.getKilometres() != null) {
            setOptions(carConfiguration.getKilometres());
        }

        if(carConfiguration.getPaymentCards() != null) {
            setOptions(carConfiguration.getPaymentCards());
        }

        if(carConfiguration.getDepositAtPickUps() != null) {
            setOptionsByIndex(carConfiguration.getDepositAtPickUps());
        }

        if(carConfiguration.getDamageExcesses() != null) {
            setOptionsByIndex(carConfiguration.getDamageExcesses());
        }
    }

}
