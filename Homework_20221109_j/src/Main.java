import java.util.*;

public class Main {
    public static void main(String[] args) {

        /*
        Необходимо написать программу для сохранения данных о бронирование
        номеров гостиницы.
        В вашей программе должно быть несколько типов номеров,
        например: standard, superior, de luxe, president.
        Естественно, номера отличаются ценой проживания.
        Кроме того, номера категории de luxe, president предполагают доступ в fitness center, для остальных категорий номеров доступ
        в fitness center оплачивается как отдельная услуга.
        Ваша программа должна
        позволять сотрудникам отеля сохранить и просмотреть данные о бронирование,
        отменить бронирование, посмотреть все бронирования.
        Данные о бронирование если хотите, можно задать в программе константно или
        ввести через Scanner
        Для отражения дат бронирования необходимо использовать написанный ранее класс
        MyDate ( в данной задаче не используем стандартные Java классы для работы с
        датой). В качестве дополнительных задач: в классе MyDate реализовать методы:
        -подсчета количества дней в заданном интервале дат
        -определения пересечения интервалов
         */


//        Booking b1 = new BookingRooms(1);
//        b1.add(new Standard(1,100,new MyDate(12,5,2022),new MyDate(18,5,2022)));
//
//        b1.add(new Superior(2,250,new MyDate(25,6,2022),new MyDate(12,7,2022)));
//
//        b1.add(new DeLuxe(3,1000,new MyDate(5,7,2022),new MyDate(15,7,2022)));
//
//        b1.add(new President(4,2500,new MyDate(1,8,2022),new MyDate(30,8,2022)));
//
//        b1.add(new Standard(1,100,new MyDate(20,2,2022),new MyDate(10,3,2022)));
//        b1.add(new President(4,2500,new MyDate(25,11,2022),new MyDate(10,12,2022)));
//        System.out.println(b1);
//        b1.availableRooms();
//        b1.changeTimeOfBooking(5);
//        System.out.println(b1);
//        b1.deleteBooking(1);
//        System.out.println(b1);

        List<HotelRooms> bookingRooms = new ArrayList<HotelRooms>();
        bookingRooms.add(new Standard(1,100,new MyDate(12,5,2022),new MyDate(18,5,2022)));

        bookingRooms.add(new Superior(2,250,new MyDate(25,6,2022),new MyDate(12,7,2022)));

        bookingRooms.add(new DeLuxe(3,1000,new MyDate(5,7,2022),new MyDate(15,7,2022)));

        bookingRooms.add(new President(4,2500,new MyDate(1,8,2022),new MyDate(30,8,2022)));

        bookingRooms.add(new Standard(1,100,new MyDate(20,2,2022),new MyDate(10,3,2022)));
        bookingRooms.add(new President(4,2500,new MyDate(25,11,2022),new MyDate(10,12,2022)));

        System.out.println(bookingRooms);
        Collections.sort(bookingRooms);
        System.out.println(bookingRooms);
//        bookingRooms.remove(2);
//        System.out.println(bookingRooms);
//        bookingRooms.get(0).changeTimeOfBooking(bookingRooms,3);
//        Collections.sort(bookingRooms);
//        System.out.println(bookingRooms);
//        bookingRooms.get(0).availableRooms(bookingRooms);



    }




}