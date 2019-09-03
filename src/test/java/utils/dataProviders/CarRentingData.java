package utils.dataProviders;

public class CarRentingData {
    private String shortDestination;
    private String destination;
    private int checkInYear;
    private int checkOutYear;
    private int checkInMonth;
    private int checkOutMonth;
    private int checkInDay;
    private int checkOutDay;

    public CarRentingData(CarRentingDataBuilder builder) {
        this.shortDestination = builder.getShortDestination();
        this.destination = builder.getDestination();
        this.checkInYear = builder.getCheckInYear();
        this.checkInMonth = builder.getCheckInMonth();
        this.checkInDay = builder.getCheckInDay();
        this.checkOutYear = builder.getCheckOutYear();
        this.checkOutMonth = builder.getCheckOutMonth();
        this.checkOutDay = builder.getCheckOutDay();
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
}
