package utils.dataProviders;

public class CarRentingDataBuilder {

    private String shortDestination;
    private String destination;
    private int checkInYear;
    private int checkOutYear;
    private int checkInMonth;
    private int checkOutMonth;
    private int checkInDay;
    private int checkOutDay;

    public CarRentingDataBuilder() {
    }

    public String getShortDestination() {
        return shortDestination;
    }

    public String getDestination() {
        return destination;
    }

    public int getCheckInYear() {
        return checkInYear;
    }

    public int getCheckOutYear() {
        return checkOutYear;
    }

    public int getCheckInMonth() {
        return checkInMonth;
    }

    public int getCheckOutMonth() {
        return checkOutMonth;
    }

    public int getCheckInDay() {
        return checkInDay;
    }

    public int getCheckOutDay() {
        return checkOutDay;
    }

    public CarRentingDataBuilder shortDestination(String shortDestination) {
        this.shortDestination = shortDestination;
        return this;
    }

    public CarRentingDataBuilder fullDestination(String fullDestination) {
        this.destination = fullDestination;
        return this;
    }

    public CarRentingDataBuilder checkInYear(int checkInYear) {
        this.checkInYear = checkInYear;
        return this;
    }

    public CarRentingDataBuilder checkOutYear(int checkOutYear) {
        this.checkOutYear = checkOutYear;
        return this;
    }

    public CarRentingDataBuilder checkInMonth(int checkInMonth) {
        this.checkInMonth = checkInMonth;
        return this;
    }

    public CarRentingDataBuilder checkOutMonth(int checkOutMonth) {
        this.checkOutMonth = checkOutMonth;
        return this;
    }

    public CarRentingDataBuilder checkInDay(int checkInDay) {
        this.checkInDay = checkInDay;
        return this;
    }

    public CarRentingDataBuilder getCheckOutDay(int checkOutDay) {
        this.checkOutDay = checkOutDay;
        return this;
    }

    public CarRentingData build() {
        return new CarRentingData(this);
    }
}
