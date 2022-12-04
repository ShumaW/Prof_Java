import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HotelRooms implements Comparable<HotelRooms> {
    public int typeRoom;
    protected int price;
    protected String name;

    protected boolean fitnesCentre;
    protected MyDate dateOfArrival;
    protected MyDate dateOfDeparture;
    private int daysOfStay = 0;

    public HotelRooms(int typeRoom, int price, MyDate dateOfArrival, MyDate dateOfDeparture) {
        this.typeRoom = typeRoom;
        this.price = price;
        this.dateOfArrival = dateOfArrival;
        this.dateOfDeparture = dateOfDeparture;
    }


    public String getName() {
        return name;
    }

    public int totalPriceForAllDays() {
        return price * daysOfStay();
    }

    @Override
    public String toString() {
        return String.format("%-10s room: price - (%d)$ per day, fitness centre %-12s, dayOfArrival - %s, dayOfDeparture - %s, total days - %d, total price - %d" + System.lineSeparator(), name, price, includeFitnesCentre(), dateOfArrival, dateOfDeparture, daysOfStay(), totalPriceForAllDays());

//                System.lineSeparator() + name + " room: " + System.lineSeparator() +
//                "Price - " + price + "$ per day," + System.lineSeparator() + "Fitnes centre " + includeFitnesCentre() + "." + System.lineSeparator() +
//                "DateOfBooking: " + System.lineSeparator() +
//                "1. DayOfArrival " + dateOfArrival + System.lineSeparator() +
//                "2. DayOfDeparture " + dateOfDeparture + System.lineSeparator() +
//                "------------------------" + System.lineSeparator() +
//                "Total days - "  + daysOfStay() + System.lineSeparator() +
//                "Total price - " + totalPriceForAllDays() + "$" + System.lineSeparator() +
//                "------------------------";
    }

    private String includeFitnesCentre() {
        if (fitnesCentre == true) {
            return "included";
        } else {
            return "not included";
        }
    }

    public MyDate getDateOfArrival() {
        return dateOfArrival;
    }

    public int daysOfStay() {
        if ((dateOfArrival.getMonth() == 1 || dateOfArrival.getMonth() == 3 || dateOfArrival.getMonth() == 5 || dateOfArrival.getMonth() == 7 || dateOfArrival.getMonth() == 8 || dateOfArrival.getMonth() == 10 || dateOfArrival.getMonth() == 12) && dateOfArrival.getMonth() != dateOfDeparture.getMonth()) {
            return this.daysOfStay = (31 - dateOfArrival.getDay()) + dateOfDeparture.getDay();
        } else if (dateOfArrival.getMonth() == 2 && dateOfArrival.getMonth() != dateOfDeparture.getMonth()) {
            return this.daysOfStay = (28 - dateOfArrival.getDay()) + dateOfDeparture.getDay();
        } else if ((dateOfArrival.getMonth() == 2 || dateOfArrival.getMonth() == 4 || dateOfArrival.getMonth() == 6 || dateOfArrival.getMonth() == 9 || dateOfArrival.getMonth() == 11) && dateOfArrival.getMonth() != dateOfDeparture.getMonth()) {
            return this.daysOfStay = (30 - dateOfArrival.getDay()) + dateOfDeparture.getDay();
        } else {
            return this.daysOfStay = dateOfDeparture.getDay() - dateOfArrival.getDay();
        }

    }

    @Override
    public int compareTo(HotelRooms o) {
        if (this.dateOfArrival.getYear() != o.dateOfArrival.getYear()) {
            return this.dateOfArrival.getYear() - o.dateOfArrival.getYear();
            break;
        }
        if (this.dateOfArrival.getMonth() != o.dateOfArrival.getMonth()) {
            return this.dateOfArrival.getDay() - o.dateOfArrival.getDay();
        }
        if (this.dateOfArrival.getDay() != o.dateOfArrival.getDay()) {
            return this.dateOfArrival.getDay() - o.dateOfArrival.getDay();
        }
        return 0;
    }


    public void availableRooms(List<HotelRooms> bookingRooms) {
        int countStandart = 20;
        int countSuperior = 12;
        int countLuxe = 5;
        int countPresident = 3;
        for (int i = 0; i < bookingRooms.size(); i++) {
            switch (bookingRooms.get(i).typeRoom) {
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

    public static void changeTimeOfBooking(List<HotelRooms> bookingRooms, int numberOfBooking) {
        for (int i = 0; i < bookingRooms.size(); i++) {
            if ((numberOfBooking - 1) == i) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please enter a new day of arrival:");
                bookingRooms.get(i).dateOfArrival.setDay(scanner.nextInt());
                System.out.println("Please enter a new month of arrival:");
                bookingRooms.get(i).dateOfArrival.setMonth(scanner.nextInt());
                System.out.println("Please enter a new year of arrival:");
                bookingRooms.get(i).dateOfArrival.setYear(scanner.nextInt());
                System.out.println("Please enter a new day of departure:");
                bookingRooms.get(i).dateOfDeparture.setDay(scanner.nextInt());
                System.out.println("Please enter a new month of departure:");
                bookingRooms.get(i).dateOfDeparture.setMonth(scanner.nextInt());
                System.out.println("Please enter a new year of departure:");
                bookingRooms.get(i).dateOfDeparture.setYear(scanner.nextInt());
                scanner.close();
            }
        }
    }


}
