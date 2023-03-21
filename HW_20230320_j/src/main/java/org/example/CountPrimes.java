package org.example;

import java.util.concurrent.*;

public class CountPrimes {
    /**
     * Переписать алгоритм подсчета простых чисел
     * (См. класс lesson20230227.multithreading.CountPrimes
     * в репозитории) так,чтобы расчеты передавались на выполнение
     * пулу потоков ExecutorService с использованием Callable (вместо Runnable).
     */
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        countPrimesSequentially();
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        countPrimesParallel();
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - start));
    }

    private static void countPrimesParallel() {

        ExecutorService result = Executors.newFixedThreadPool(3);
        Future<Integer> future1 = result.submit(new Task(2, 250_000));
        Future<Integer> future2 = result.submit(new Task(250_000, 400_000));
        Future<Integer> future3 = result.submit(new Task(400_000, 500_000));

        try {
            System.out.println("Total numbers of primes: " + (future1.get() + future2.get() + future3.get()));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        result.shutdown();
    }

    static class Task implements Callable<Integer> {
        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int start;
        int end;
        Integer count = 0;


        @Override
        public Integer call() throws Exception {
            for (int i = start; i < end; i++) {
                boolean isPrime = true;

                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) count++;
            }

            System.out.println("Numbers of primes: " + count);
            return count;
        }
    }


    private static void countPrimesSequentially() {
        int count = 0;

        for (int i = 2; i < 500_000; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime)
                count++;
        }

        System.out.println("Total numbers of primes: " + count);
    }

}
