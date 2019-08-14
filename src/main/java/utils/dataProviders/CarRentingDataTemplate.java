package utils.dataProviders;

public class CarRentingDataTemplate {
    private String shortDestination;
    private String destination;
    private int checkInYear;
    private int checkOutYear;
    private int checkInMonth;
    private int checkOutMonth;
    private int checkInDay;
    private int checkOutDay;

    public CarRentingDataTemplate(String shortDestination, String destination, int checkInYear, int checkInMonth, int checkInDay, int checkOutYear, int checkOutMonth, int checkOutDay) {
        this.shortDestination = shortDestination;
        this.destination = destination;
        this.checkInYear = checkInYear;
        this.checkInMonth = checkInMonth;
        this.checkInDay = checkInDay;
        this.checkOutYear = checkOutYear;
        this.checkOutMonth = checkOutMonth;
        this.checkOutDay = checkOutDay;
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
