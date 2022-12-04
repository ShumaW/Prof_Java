public class Standard extends HotelRooms {
    public Standard(int typeRoom,int price, MyDate dateOfArrival, MyDate dateOfDeparture) {
        super(typeRoom, price, dateOfArrival, dateOfDeparture);
        super.fitnesCentre = false;
        super.name = "Standard";
    }


}
