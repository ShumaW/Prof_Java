public class Standard extends HotelRooms {
    public Standard(int typeRoom,int price, MyDate myDate) {
        super(typeRoom, price, myDate);
        super.fitnesCentre = false;
        super.name = "Standard";
    }


}
