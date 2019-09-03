package booking.dataprovider;

import utils.dataProviders.CarRentingData;
import utils.dataProviders.CarRentingDataBuilder;

public class CarRentingDataProvider {

//    @DataProvider(name = "CarRentingData")
    public static Object[] getData() {
        return new CarRentingData[]{
                new CarRentingDataBuilder()
                        .withShortDestination("London")
                        .withFullDestination("London, Greater London, United Kingdom")
                        .withCheckInYear(2019)
                        .withCheckInMonth(8)
                        .withCheckInDay(28)
                        .withCheckOutYear(2019)
                        .withCheckOutMonth(8)
                        .withCheckOutDay(31)
                        .build(),

                new CarRentingDataBuilder()
                        .withShortDestination("Larnaka")
                        .withFullDestination("Larnaka, Cyprus")
                        .withCheckInYear(2019)
                        .withCheckInMonth(8)
                        .withCheckInDay(28)
                        .withCheckOutYear(2019)
                        .withCheckOutMonth(9)
                        .withCheckOutDay(3)
                        .build()
        };
    }
}
