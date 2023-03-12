package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {
    private static AtomicInteger sum = new AtomicInteger(0);

    public void deposit(int amount) {
        boolean result;
        do {
            int neu = sum.get();
            int alt = neu;
            neu += amount;
            result = sum.compareAndSet(alt, neu);
        } while (!result);
    }

    public void withdraw(int amount) {
        int res = sum.get();
        int old = res;
        res -= amount;
        sum.compareAndSet(old, res);
    }

    public int getSum() {
        return sum.get();
    }
}