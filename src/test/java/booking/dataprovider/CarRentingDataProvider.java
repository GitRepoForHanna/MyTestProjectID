package booking.dataprovider;

import org.testng.annotations.DataProvider;
import utils.dataProviders.CarRentingData;
import utils.dataProviders.CarRentingDataBuilder;

public class CarRentingDataProvider {

    public CarRentingDataProvider() {
    }

    @DataProvider(name = "CarRentingData")
    public static Object[] getData() {
        return new CarRentingData[]{
                new CarRentingDataBuilder()
                        .shortDestination("London")
                        .fullDestination("London, Greater London, United Kingdom")
                        .checkInYear(2019)
                        .checkInMonth(8)
                        .checkInDay(28)
                        .checkOutYear(2019)
                        .checkOutMonth(8)
                        .getCheckOutDay(31)
                        .build(),

                new CarRentingDataBuilder()
                        .shortDestination("Larnaka")
                        .fullDestination("Larnaka, Cyprus")
                        .checkInYear(2019)
                        .checkInMonth(8)
                        .checkInDay(28)
                        .checkOutYear(2019)
                        .checkOutMonth(9)
                        .getCheckOutDay(3)
                        .build()
        };
    }
}
