package utils.dataProviders;

public class CarRentingDataBuilder {

    private CarRentingData carRentingData;

    public CarRentingDataBuilder() {
        carRentingData = new CarRentingData();
    }

    public CarRentingDataBuilder withShortDestination(String shortDestination) {
        carRentingData.setShortDestination(shortDestination);
        return this;
    }

    public CarRentingDataBuilder withFullDestination(String fullDestination) {
        carRentingData.setDestination(fullDestination);
        return this;
    }

    public CarRentingDataBuilder withCheckInYear(int checkInYear) {
        carRentingData.setCheckInYear(checkInYear);
        return this;
    }

    public CarRentingDataBuilder withCheckOutYear(int checkOutYear) {
        carRentingData.setCheckOutYear(checkOutYear);
        return this;
    }

    public CarRentingDataBuilder withCheckInMonth(int checkInMonth) {
        carRentingData.setCheckInMonth(checkInMonth);
        return this;
    }

    public CarRentingDataBuilder withCheckOutMonth(int checkOutMonth) {
        carRentingData.setCheckOutMonth(checkOutMonth);
        return this;
    }

    public CarRentingDataBuilder withCheckInDay(int checkInDay) {
        carRentingData.setCheckInDay(checkInDay);
        return this;
    }

    public CarRentingDataBuilder withCheckOutDay(int checkOutDay) {
        carRentingData.setCheckOutDay(checkOutDay);
        return this;
    }

    public CarRentingData build() {
        return carRentingData;
    }
}
