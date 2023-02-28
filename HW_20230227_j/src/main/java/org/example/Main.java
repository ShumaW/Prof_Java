package org.example;

public class Main {
    public static void main(String[] args) {

        /*
        Проверка целых чисел на делимость
        Задача: найти все целые числа в диапазоне от Integer.MIN_VALUE
        до Integer.MAX_VALUE, которые делятся на заданное целое число без остатка

        очевидное решение:
        …
        int number = 5;
        int count = 0;
        for (int i=Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            if (i % number == 0)
                count++;
        }
        System.out.println(“Total divisible by “ + number + “: “ + count);

         */
        long start = System.currentTimeMillis();
        divisionByAGivenNumber(7);
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        divisionByAGivenNumberParallel(7);
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void divisionByAGivenNumber(int number){
        int count = 0;
        for (int i=Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            if (i % number == 0)
                count++;
        }
        System.out.println("Total divisible by " + number + ": " + count);
    }

    public static void divisionByAGivenNumberParallel (int number){
        Task task1 = new Task(number,Integer.MIN_VALUE,0);
        Thread thread1 = new Thread(task1);
        thread1.start();
        Task task2 = new Task(number,0, Integer.MAX_VALUE);
        Thread thread2 = new Thread(task2);
        thread2.start();

        try {
            thread1.join();
            thread2.join();

            System.out.println("Total divisible by " + (task1.count + task2.count ));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Task implements Runnable {
        public Task(int number, int start, int end) {
            this.number = number;
            this.start = start;
            this.end = end;
        }

        int number;
        int start;
        int end;
        int count = 0;

        @Override
        public void run() {

            for (int i=start; i < end; i++) {
                if (i % number == 0)
                    count++;
            }
            System.out.println("Total divisible by " + number + " in " + Thread.currentThread() + ": " + count);
        }
    }


}