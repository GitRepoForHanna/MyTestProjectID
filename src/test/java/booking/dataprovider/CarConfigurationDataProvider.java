package booking.dataprovider;

import business_objects.car.*;
import org.testng.annotations.DataProvider;
import java.util.Arrays;


public class CarConfigurationDataProvider {

    @DataProvider(name = "CarConfigurationData")
    public static Object[] getData() {
        return new CarBuilder.Car[]{
                new CarBuilder().withSuppliers(Arrays.asList(SuppliersOptions.EUROPCAR, SuppliersOptions.FIREFLY))
                        .withSupplierLocations(Arrays.asList(SupplierLocation.CAR_RENTING_CENTER))
                        .withFuelPolicies(Arrays.asList(FuelPolicy.FULL_TO_FULL))
                        .withPartySizes(Arrays.asList(PartySize.SMALL_GROUP))
                        .withSpecifications(Arrays.asList(CarSpecification.WITH_AIR_CONDITIONING))
                        .build(),

                new CarBuilder().withSpecifications(Arrays.asList(CarSpecification.DIESEL))
                        .withSupplierLocations(Arrays.asList(SupplierLocation.TERMINAL))
                        .withPartySizes(Arrays.asList(PartySize.SMALL_GROUP))
                        .withKilometres(Arrays.asList(Kilometres.UNLIMITED))
                        .withPaymentCards(Arrays.asList(PaymentCard.CREDIT_CARD))
                        .build()
        };
    }
}
