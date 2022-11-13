public class Main {
    public static void main(String[] args) {

        /*
        Необходимо написать программу для сохранения данных о бронирование
        номеров гостиницы. В вашей программе должно быть несколько типов номеров,
        например: standard, superior, de luxe, president. Естественно, номера
        отличаются ценой проживания. Кроме того, номера категории de luxe, president
        предполагают доступ в fitness center, для остальных категорий номеров доступ
        в fitness center оплачивается как отдельная услуга. Ваша программа должна
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

//        DateOfBooking b1 = new DateOfBooking(25,2,2022,12,3,2022);
//        System.out.println(b1);
//        Standard r1 = new Standard(100,new DateOfBooking(12,6,2022,5,7,2022));
//        System.out.println(r1);
//        Superior s1 = new Superior(250,new DateOfBooking(25,12,2022,7,1,2023));
//        System.out.println(s1);
        Booking b1 = new BookingRooms(1);
        b1.add(new Standard(100,new DateOfBooking(12,5,2022,18,5,2022)));

        b1.add(new Superior(250,new DateOfBooking(25,6,2022,12,7,2022)));

        b1.add(new DeLuxe(1000,new DateOfBooking(5,7,2022,15,7,2022)));

        b1.add(new President(2500,new DateOfBooking(1,8,2022,30,8,2022)));
        System.out.println(b1);

       




    }
}