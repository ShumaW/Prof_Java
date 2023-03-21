package Task2;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Restarant2 {
    static Semaphore semaphore = new Semaphore(5);
    static BlockingQueue<Exchanger<Tray>> order = new LinkedBlockingQueue<>();

    static class Visitor implements Runnable {
        private Tray tray = new Tray();
        private Exchanger<Tray> visitorOrder = new Exchanger<>();

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting to enter the restaurant");
                Thread.sleep(2000);
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " entered the restaurant");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " making an order");
                order.add(visitorOrder);
                tray = visitorOrder.exchange(tray);
                System.out.println(Thread.currentThread().getName() + " eats " + tray.list);
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " visitor payed and living the restaurant.");
                semaphore.release();


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    static class Waiter implements Runnable {
        private BlockingQueue<Dishes> dish1;
        private BlockingQueue<Dishes> dish2;
        private BlockingQueue<Dishes> dish3;

        private Tray tray = new Tray();

        public Waiter(BlockingQueue<Dishes> dish1, BlockingQueue<Dishes> dish2, BlockingQueue<Dishes> dish3) {
            this.dish1 = dish1;
            this.dish2 = dish2;
            this.dish3 = dish3;
        }

        @Override
        public void run() {
            try {
                tray.list.add(dish1.take());
                tray.list.add(dish2.take());
                tray.list.add(dish3.take());
                System.out.println("Waiter filled the tray");
                tray = order.take().exchange(tray);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }

    private static class Chef implements Runnable {
        // блюдо
        private Dishes dish;
        // очередь готовых блюд
        private BlockingQueue<Dishes> plates;

        public Chef(Dishes dish, BlockingQueue<Dishes> plates) {
            this.dish = dish;
            this.plates = plates;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("Cooking " + dish);
                try {
                    Thread.sleep(5000);
                    System.out.println(dish + " is cooked. Take it");
                    plates.put(dish);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    enum Dishes {
        SALAD,
        SOUP,
        MAIN
    }

    static class Tray {
        List<Dishes> list = new ArrayList<>(3);

    }

    public static void main(String[] args) {
        BlockingQueue salad = new ArrayBlockingQueue(5);
        BlockingQueue soup = new ArrayBlockingQueue(5);
        BlockingQueue mainDish = new ArrayBlockingQueue(5);

        new Thread(new Chef(Dishes.SALAD, salad), "Chef1").start();
        new Thread(new Chef(Dishes.SOUP, soup), "Chef2").start();
        new Thread(new Chef(Dishes.MAIN, mainDish), "Chef3").start();
        new Thread(new Waiter(salad, soup, mainDish), "Waiter").start();


        while (true) {
            Faker faker = new Faker();

            String name = faker.name().firstName();
            new Thread(new Visitor(), name).start();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
