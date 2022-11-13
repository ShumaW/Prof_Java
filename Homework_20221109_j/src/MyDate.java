public class MyDate {
    private int dayOfArrival;
    private int monthOfArrival;
    private int yearOfArrival;
    private int dayOfDeparture;
    private int monthOfDeparture;
    private int yearOfDeparture;
    private int daysOfStay = 0;

    @Override
    public String toString() {
        return "DateOfBooking: " + System.lineSeparator() +
                "1. DayOfArrival " + dayOfArrival + "." + monthOfArrival + "." + yearOfArrival + System.lineSeparator() +
                "2. DayOfDeparture " + dayOfDeparture + "." + monthOfDeparture + "." + yearOfDeparture + System.lineSeparator() + "------------------------" + System.lineSeparator() +
                "Total days - " + setDaysOfStay();
    }

    public MyDate(int dayOfArrival, int monthOfArrival, int yearOfArrival, int dayOfDeparture, int monthOfDeparture, int yearOfDeparture) {
        this.dayOfArrival = dayOfArrival;
        this.monthOfArrival = monthOfArrival;
        this.yearOfArrival = yearOfArrival;
        this.dayOfDeparture = dayOfDeparture;
        this.monthOfDeparture = monthOfDeparture;
        this.yearOfDeparture = yearOfDeparture;
    }

    public int setDaysOfStay() {
        if ((monthOfArrival == 1 || monthOfArrival == 3 || monthOfArrival == 5 || monthOfArrival == 7 || monthOfArrival == 8 || monthOfArrival == 10 || monthOfArrival == 12) && monthOfArrival != monthOfDeparture) {
            return this.daysOfStay = (31 - dayOfArrival) + dayOfDeparture ;
        } else if (monthOfArrival == 2 && monthOfArrival != monthOfDeparture) {
            return this.daysOfStay = (28 - dayOfArrival) + dayOfDeparture;
        } else if ((monthOfArrival == 2 || monthOfArrival == 4 || monthOfArrival == 6 || monthOfArrival == 9 || monthOfArrival == 11) && monthOfArrival != monthOfDeparture ){
            return this.daysOfStay = (30 - dayOfArrival) + dayOfDeparture;
        } else {
            return this.daysOfStay = dayOfDeparture - dayOfArrival;
        }
    }
}
