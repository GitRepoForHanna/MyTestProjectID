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
                        .checkInMonth(9)
                        .checkInDay(28)
                        .checkOutYear(2019)
                        .checkOutMonth(10)
                        .getCheckOutDay(31)
                        .build(),

                new CarRentingDataBuilder()
                        .shortDestination("Larnaka")
                        .fullDestination("Larnaka, Cyprus")
                        .checkInYear(2019)
                        .checkInMonth(10)
                        .checkInDay(8)
                        .checkOutYear(2019)
                        .checkOutMonth(10)
                        .getCheckOutDay(16)
                        .build()
        };
    }
}
