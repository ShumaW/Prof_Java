public class Rooms {

    protected int price;

    protected String name;

    protected DateOfBooking dateOfBooking;

    public Rooms(int price , DateOfBooking dateOfBooking) {
        this.price = price;
        this.dateOfBooking = dateOfBooking;

    }

    public String getName() {
        return name;
    }

    public int totalPriceForAllDays (){
        return price * dateOfBooking.setDaysOfStay();
    }

    @Override
    public String toString() {
        return System.lineSeparator() + name + " room: " + System.lineSeparator() +
                "Price - " + price + "$ per day," + System.lineSeparator() +
                dateOfBooking + System.lineSeparator() +
                "Total price - " + totalPriceForAllDays() + "$"+ System.lineSeparator() +
                "------------------------";
    }






}
