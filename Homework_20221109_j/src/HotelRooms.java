public class HotelRooms {
    public int typeRoom;
    protected int price;
    protected String name;

    protected boolean fitnesCentre;
    protected MyDate myDate;

    public HotelRooms(int typeRoom, int price, MyDate myDate) {
        this.typeRoom = typeRoom;
        this.price = price;
        this.myDate = myDate;
    }


    public String getName() {
        return name;
    }

    public int totalPriceForAllDays() {
        return price * myDate.setDaysOfStay();
    }

    @Override
    public String toString() {
        return System.lineSeparator() + name + " room: " + System.lineSeparator() +
                "Price - " + price + "$ per day," + System.lineSeparator() + "Fitnes centre " + includeFitnesCentre() + "." + System.lineSeparator() +
                myDate + System.lineSeparator() +
                "Total price - " + totalPriceForAllDays() + "$" + System.lineSeparator() +
                "------------------------";
    }

    private String includeFitnesCentre() {
        if (fitnesCentre == true) {
            return "included in the price";
        } else {
            return "not included in the price." + System.lineSeparator() + "You can pay for it separately. It cost 25$ for one visit";
        }
    }




}
