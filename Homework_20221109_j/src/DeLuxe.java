public class DeLuxe extends HotelRooms {
    public DeLuxe(int typeRoom, int price, MyDate dateOfArrival, MyDate dateOfDeparture) {
        super(typeRoom, price, dateOfArrival, dateOfDeparture);
        super.fitnesCentre = true;
        super.name = "De Luxe";
    }


}
