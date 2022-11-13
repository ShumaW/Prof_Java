import java.util.Arrays;

public class BookingRooms implements Booking{
    private int capasity;
    private int size;
    private Rooms[] bookingRooms;

    public BookingRooms(int capasity) {
        this.capasity = capasity;
        this.size = 0;
        this.bookingRooms = new Rooms[capasity];
    }

    public boolean add(Rooms room) {
        if (size >= bookingRooms.length) {
            enlarge();
        }
        bookingRooms[size] = room;
        size++;
        return true;
    }

    @Override
    public void newDateOfBooking(Rooms room, DateOfBooking date) {

    }


    public void enlarge() {
        bookingRooms = Arrays.copyOf(bookingRooms, bookingRooms.length * 2);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < bookingRooms.length && i < size; i++) {
            res.append(bookingRooms[i]);
        }
        return res.append(System.lineSeparator())
                .append("Total booked: " + size + " rooms")
                .toString();
    }

    public void newDateOfBooking(DeLuxe name, DateOfBooking date){}



}
