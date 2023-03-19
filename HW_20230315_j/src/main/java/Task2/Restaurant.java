package Task2;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

public class Restaurant {
    /**
     * Реализовать логику работы небольшого ресторана, который может принять только 5
     * человек одновременно.
     * Люди прибывают и выстраиваются в очередь на входе, ожидая освобождения столиков.
     * Все заказывают комплексный обед из 3-х блюд (суп, салат и второе).
     * В ресторане один официант и три повара, каждый из которых готовит только одно
     * блюдо на одного человека.
     * Один повар готовит только супы, второй только салаты, третий только второе.
     * Официант собирает обед на поднос и относит посетителям.
     * Посетили едят и покидают ресторан, освобождая столы для новых посетителей.
     */

    public static Semaphore semaphore1 = new Semaphore(5);

    public static ArrayBlockingQueue<String> queueWaitersVisitorsOrder = new ArrayBlockingQueue<>(5, true);
    public static ArrayBlockingQueue<String> queueWaiterChefs = new ArrayBlockingQueue<>(3, true);
    public static ArrayBlockingQueue<String> queueChefsWaiter = new ArrayBlockingQueue<>(1, true);
    public static ArrayBlockingQueue<String> queueWaiterVisitorDishes = new ArrayBlockingQueue<>(1, true);

    public static List<String> menu;
    public static int count;


    public static void main(String[] args) {
        menu = new ArrayList<>();
        menu.add("Salad");
        menu.add("Soup");
        menu.add("Main dish");

//        Faker faker = new Faker();
//        for (int i = 0; i < 10; i++) {
//            String name = faker.name().firstName();
//        }
        new Thread(new Visitor(), "Pit").start();
        new Thread(new Visitor(), "Ann").start();
        new Thread(new Visitor(), "Sem").start();
        new Thread(new Visitor(), "Kat").start();
        new Thread(new Visitor(), "John").start();

        new Thread(new Waiter(), "Waiter").start();
        new Thread(new Chef(), "Chef1").start();
        new Thread(new Chef(), "Chef2").start();
        new Thread(new Chef(), "Chef3").start();


    }

    public static class Visitor implements Runnable {

        @Override
        public void run() {
            try {

                System.out.println(Thread.currentThread().getName() + " waiting to enter the restaurant. ");
                semaphore1.acquire();
                System.out.println(Thread.currentThread().getName() + " entered the restaurant.");
                Thread.sleep(2000);

                System.out.println(Thread.currentThread().getName() + " making an order for " + menu.get(count));
                queueWaitersVisitorsOrder.add(menu.get(count));
                queueWaiterVisitorDishes.take();
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + " eat ");
                count++;


                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " visitor payed and living the restaurant.");
                semaphore1.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }
        }
    }

    public static class Waiter implements Runnable {

        @Override
        public void run() {
            try {

                Thread.sleep(1000);
                queueWaitersVisitorsOrder.take();
                System.out.println(Thread.currentThread().getName() + " accepts an order " + menu.get(count));
                Thread.sleep(2000);
                queueWaiterChefs.add(menu.get(count));
                System.out.println(Thread.currentThread().getName() + " submits an order for execution " + menu.get(count));
                queueChefsWaiter.take();
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " brings " + menu.get(count) + " to the visitor");
                queueWaiterVisitorDishes.add(menu.get(count));

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class Chef implements Runnable {

        @Override
        public void run() {

            try {
                queueWaiterChefs.take();
                System.out.println(Thread.currentThread().getName() + " accepts an order for execution");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " cooking " + menu.get(count));
                Thread.sleep(5000);
                queueChefsWaiter.add(menu.get(count));
                System.out.println(Thread.currentThread().getName() + " gives the finished dish");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

//    enum DISHES {
//        SOUP,
//        SALAD,
//        MAIN
//    }



