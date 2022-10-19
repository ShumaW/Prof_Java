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
        //a)      создать несколько разных билетов, положить их в массив.

        Ticket t1 = new Ticket(new Route("4ab", "Днепр", "Вена", 1800), new MyDateTime(7, 11, 2022, 21, 30), 367);

        Ticket[] tic = {
                t1,
                new Ticket(new Route("1ab", "Днепр", "Берлин", 2000), new MyDateTime(15, 10, 2022, 14, 23), 256),
                new Ticket(new Route("2ac", "Берлин", "Вена", 504), new MyDateTime(22, 8, 2022, 18, 46), 56),
                new Ticket(new Route("3db", "Вена", "Париж", 1003), new MyDateTime(31, 3, 2023, 05, 46), 68)
        };
        // b)      Реализовать метод, который выводит информацию обо всех билетах

        for (Ticket t : tic) {
            System.out.println(t);
        }

        System.out.println("-----------------------------");
        System.out.println(sumAllPrice(tic) );
        System.out.println("-----------------------------");
//        System.out.println(sumDistance(tic));



    }

    // c)      Реализовать метод, который считает суммарную стоимость билетов.

    public static double  sumAllPrice (Ticket[] arr){
        double sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i].getPrice();
        }
        return sum;
    }
    //d)      Необходимо посчитать суммарную дистанцию всех маршрутов (предположим, что у вас нет
    //билетов с одним и тем же маршрутом, т.е. задача сводится к простому суммированию всех distance)

    public static int sumDistance(Route [] arr){
        int sum = 0;
        for (int i = 0; i < arr.length ; i++) {
            sum+=arr[i].getDistance();
        }
        return sum;
    }



}