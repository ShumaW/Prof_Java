package org.example;

public class Main {
    public static void main(String[] args) {
        GetSumRun task1 = new GetSumRun(0,250);
        GetSumRun task2 = new GetSumRun(251,500);
        GetSumThread thread3 = new GetSumThread(501,750);
        GetSumThread thread4 = new GetSumThread(751,1000);

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(task1.result + task2.result + thread3.getSum() + thread4.getSum());
    }
}

