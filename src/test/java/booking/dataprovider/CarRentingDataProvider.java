package booking.dataprovider;

import org.testng.annotations.DataProvider;
import utils.dataProviders.CarRentingDataTemplate;

public class CarRentingDataProvider {

    public CarRentingDataProvider() {
    }

    @DataProvider(name = "CarRentingData")
    public static Object[] getData() {
        return new CarRentingDataTemplate[] {
           new CarRentingDataTemplate("London", "London, Greater London, United Kingdom", 2019, 8, 21,2019,8,27),
                new CarRentingDataTemplate("Larnaka", "Larnaka, Cyprus", 2019, 8, 21, 2019, 9, 3)
        };
    }
}
