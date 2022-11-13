public class Rooms {
    protected int price;
    protected String name;
    protected MyDate myDate;
    public Rooms(int price , MyDate myDate) {
        this.price = price;
        this.myDate = myDate;
    }

    public String getName() {
        return name;
    }

    public int totalPriceForAllDays (){
        return price * myDate.setDaysOfStay();
    }

    @Override
    public String toString() {
        return System.lineSeparator() + name + " room: " + System.lineSeparator() +
                "Price - " + price + "$ per day," + System.lineSeparator() +
                myDate + System.lineSeparator() +
                "Total price - " + totalPriceForAllDays() + "$"+ System.lineSeparator() +
                "------------------------";
    }
}
