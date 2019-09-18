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
                        .withShortDestination("London")
                        .withFullDestination("London, Greater London, United Kingdom")
                        .withCheckInYear(2019)
                        .withCheckInMonth(9)
                        .withCheckInDay(28)
                        .withCheckOutYear(2019)
                        .withCheckOutMonth(10)
                        .withCheckOutDay(31)
                        .build(),

                new CarRentingDataBuilder()
                        .withShortDestination("Larnaka")
                        .withFullDestination("Larnaka, Cyprus")
                        .withCheckInYear(2019)
                        .withCheckInMonth(10)
                        .withCheckInDay(8)
                        .withCheckOutYear(2019)
                        .withCheckOutMonth(10)
                        .withCheckOutDay(16)
                        .build()
        };
    }
}
