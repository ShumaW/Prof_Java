package Crossbow;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class Crossbow {
    /*
       Арбалет. См. класс Crossbow в репозитории.
       Стрелок robinHood в одном потоке стреляет из арбалета,
       его помощник servant в другом потоке приносит ему колчан,
       когда стрелы закончатся.
       Заготовка логики в классе Crossbow. Доработать логику, чтобы:
       - стрельба продолжалась бесконечно
       - количество приносимых стрел каждый раз определял бы
       пользователь, вводя число arrows через консоль
        */
    private int arrows;
    static ReentrantLock lock = new ReentrantLock();

    // When the arrows end, the wait() method is called and releases.
    synchronized public void fire() {
        lock.lock();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of arrows: ");
        arrows = scanner.nextInt();
        for (int idx = arrows; idx >= 0; idx--) {

            if (idx != 0) {
                System.out.println("The arrow is " + (arrows - idx + 1) + " right on the target!");
            } else {
                System.out.println("The arrows are over");
                arrows = 0;
                System.out.println("Count arrows " + arrows);
                System.out.println("Carry a new quiver with arrows!!");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock.unlock();
    }

    // reload() brings new arrows, calls the notify() method, which awakens the thread
    synchronized public void reload() {
        System.out.println("New arrows on the way!");
        System.out.println("Count arrows = " + arrows);
        notify();
    }

    public static void main(String[] args) {

        while (true) {
            Crossbow crossbow = new Crossbow();

            Thread robinHood = new Thread(crossbow::fire);
            Thread servant = new Thread(crossbow::reload);

            robinHood.start();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            servant.start();
        }
    }
}