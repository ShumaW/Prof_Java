package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {

    /**
     * Строительная фирма:
     * имеет 4 бригады, каждая бригада строит 1 дом;
     * фирма строит поселок из 10 домов;
     * затем принимает отчет от строителей о расходах и вычисляет
     * суммарные расходы за строительство поселка;
     * после чего принимается за следующий поселок из 10 домов.
     * Реализовать логику с помощью ExecutorService
     * Как нужно будет поменять код, если у фирмы:
     * а) Строительство будет вести только одна постоянная бригада?
     * б) Бригады будут создаваться по количеству стоящихся домов, а после распускаться?
     */

    static class House implements Callable<Integer> {

        int countOfOperation = 15;
        Random random = new Random();

        @Override
        public Integer call() {
            System.out.println("House building number ");
            try {
                Thread.sleep(10000 + random.nextInt(10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("House finished");
            Integer sum = 0;
            for (int i = 0; i < countOfOperation; i++) {
                sum += random.nextInt(50000);
            }
            System.out.println("Price for house is: " + sum);
            return sum;
        }
    }

    private static int countBuilding = 10;

    public static void main(String[] args) {
        int totalPrice = 0;

        ExecutorService building = Executors.newFixedThreadPool(4);

        try {
            List<Future<Integer>> futuresList = building.invokeAll(Arrays.asList(new House(), new House(), new House(), new House(), new House(), new House(), new House(), new House(), new House(), new House()));

            for (int i = 0; i < futuresList.size(); i++) {

                totalPrice = totalPrice + futuresList.get(i).get();

            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        building.shutdown();

        System.out.println("The final price of " + countBuilding + " building is: " + totalPrice);
    }
}