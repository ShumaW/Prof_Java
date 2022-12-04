public class President extends HotelRooms {
    public President(int typeRoom,int price, MyDate dateOfArrival, MyDate dateOfDeparture) {
        super(typeRoom,price, dateOfArrival, dateOfDeparture);
        super.fitnesCentre = true;
        super.name = "President";
    }


}
