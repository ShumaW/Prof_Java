import java.util.List;

public interface Booking {
    boolean add(HotelRooms room);
    void availableRooms();
    void changeTimeOfBooking(int numberOfBooking);
    void deleteBooking(int index);

    void sortByDateOfArrival();



}