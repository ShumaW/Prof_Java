public class Superior extends HotelRooms {
    public Superior(int typeRoom, int price, MyDate dateOfArrival, MyDate dateOfDeparture) {
        super(typeRoom, price, dateOfArrival, dateOfDeparture);
        super.fitnesCentre = false;
        super.name = "Superior";
    }


}
