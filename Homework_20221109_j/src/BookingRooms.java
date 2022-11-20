import java.util.Arrays;
import java.util.Scanner;

public class BookingRooms implements Booking{
    private int capasity;
    private int size;
    private HotelRooms[] bookingRooms;

    private int countStandart = 20;
    private int countSuperior = 12;
    private int countLuxe = 5;
    private int countPresident = 3;


    public BookingRooms(int capasity) {
        this.capasity = capasity;
        this.size = 0;
        this.bookingRooms = new HotelRooms[capasity];
    }

    public boolean add(HotelRooms room) {
        if (size >= bookingRooms.length) {
            enlarge();
        }
        bookingRooms[size] = room;
        size++;
        return true;
    }

    public void enlarge() {

        bookingRooms = Arrays.copyOf(bookingRooms, bookingRooms.length * 2);
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < bookingRooms.length && i < size; i++) {
            res.append(System.lineSeparator())
                    .append("Number of booking is " + (i + 1))
                    .append(bookingRooms[i])
                    .append(System.lineSeparator())
                    .append("-----------------------------");

        }
        return res.append(System.lineSeparator())
                .append("Total booked: " + this.size + " rooms")
                .toString();
    }

    public void availableRooms() {
        for (int i = 0; i < size; i++) {
            switch (bookingRooms[i].typeRoom) {
                case 1:
                    countStandart--;
                    break;
                case 2:
                    countSuperior--;
                    break;
                case 3:
                    countLuxe--;
                    break;
                case 4:
                    countPresident--;
                    break;
            }
        }
        System.out.println("Available " + (countStandart + countSuperior + countLuxe + countPresident) + " rooms : ");
        System.out.println("1. Standart - " + countStandart);
        System.out.println("2. Superior - " + countSuperior);
        System.out.println("3. De Luxe - " + countLuxe);
        System.out.println("4. President - " + countPresident);
    }

    public void changeTimeOfBooking(int numberOfBooking) {
        for (int i = 0; i < bookingRooms.length; i++) {
            if ((numberOfBooking - 1) == i) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please enter a new day of arrival:");
                bookingRooms[i].myDate.setDayOfArrival(scanner.nextInt());
                System.out.println("Please enter a new month of arrival:");
                bookingRooms[i].myDate.setMonthOfArrival(scanner.nextInt());
                System.out.println("Please enter a new year of arrival:");
                bookingRooms[i].myDate.setYearOfArrival(scanner.nextInt());
                System.out.println("Please enter a new day of departure:");
                bookingRooms[i].myDate.setDayOfDeparture(scanner.nextInt());
                System.out.println("Please enter a new month of departure:");
                bookingRooms[i].myDate.setMonthOfDeparture(scanner.nextInt());
                System.out.println("Please enter a new year of departure:");
                bookingRooms[i].myDate.setYearOfDeparture(scanner.nextInt());
                scanner.close();
            }
        }
    }

    public void deleteBooking(int index) {
        HotelRooms[] temp = bookingRooms;
        for (int i = 0; i < size; i++) {
            if (index == i) {
                bookingRooms[i] = null;
                if (bookingRooms[i] == null) {
                    bookingRooms[i] = bookingRooms[size - 1];
                }
                bookingRooms = Arrays.copyOf(temp, (size - 1));

                this.size = bookingRooms.length;
            }
        }
    }

}