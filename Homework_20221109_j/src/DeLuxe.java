public class DeLuxe extends HotelRooms {
    public DeLuxe(int typeRoom, int price, MyDate myDate) {
        super(typeRoom, price, myDate);
        super.fitnesCentre = true;
        super.name = "De Luxe";
    }


}
