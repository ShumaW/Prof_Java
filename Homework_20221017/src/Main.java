public class Main {
    public static void main(String[] args) {
        /*
        Level 1.
            Представьте, вы пишите программу для автопарка или, например, для авиакомпании.
            Вам необходимо  создать класс Ticket ,  который должен содержать следующие поля Route route,
            MyDateTime time, double price. Как вы догадываетесь, Route и MyDateTime тоже  классы:
            Route{String number, String  from, String destination, long distance}  MyDateTime (day,month,year,hour,min).
            Далее вам необходимо:
            a)      создать несколько разных билетов, положить их в массив.
            b)      Реализовать метод, который выводит информацию обо всех билетах
            c)      Реализовать метод, который считает суммарную стоимость билетов.
            d)      Необходимо посчитать суммарную дистанцию всех маршрутов (предположим, что у вас нет
                    билетов с одним и тем же маршрутом, т.е. задача сводится к простому суммированию всех distance)
            e)      Реализовать в билете метод изменения времени отправления.

         */

        Ticket t1 = new Ticket(new Route("4ab", "Днепр", "Вена", 1800), new MyDateTime(7, 11, 2022, 21, 30), 367);

        Ticket[] tic = {
                t1,
                new Ticket(new Route("1ab", "Днепр", "Берлин", 2000), new MyDateTime(15, 10, 2022, 14, 23), 256),
                new Ticket(new Route("2ac", "Берлин", "Вена", 504), new MyDateTime(22, 8, 2022, 18, 46), 56),
                new Ticket(new Route("3db", "Вена", "Париж", 1003), new MyDateTime(31, 3, 2023, 05, 46), 68)
        };


        System.out.println("------------------ Level 1 -------------------------");

        System.out.println("-------------- b ---------------");
        print(tic);

        System.out.println("-------------- c ---------------");
        System.out.println(sumAllPrices(tic));
        System.out.println("-------------- d ---------------");
        System.out.println(sumDistance(tic));
        System.out.println("-------------- e ---------------");
        t1.setNewHours(22);
        t1.setNewMin(45);
        System.out.println(t1);
        System.out.println("-------------- 24.10.2022 ---------------");
        Tickets ticketsStorage = new Tickets(100);
        ticketsStorage.add(new Ticket(new Route("1ab", "Днепр", "Берлин", 2000), new MyDateTime(15, 10, 2022, 14, 23), 256));
        ticketsStorage.add(new Ticket(new Route("2ac", "Берлин", "Вена", 504), new MyDateTime(22, 8, 2022, 18, 46), 56));
        System.out.println(ticketsStorage);
    }

    private static void print(Ticket[] tic) {
        for (Ticket t : tic) {
            System.out.println(t);
        }
    }

    public static double sumAllPrices(Ticket[] arr) {
        double sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i].getPrice();
        }
        return sum;
    }


    public static int sumDistance(Ticket[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i].getDistance1();
        }
        return sum;
    }

}