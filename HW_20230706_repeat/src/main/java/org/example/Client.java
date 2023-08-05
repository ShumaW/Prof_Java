package org.example;

import lombok.Getter;

public class Client {
    private final String name;

    @Getter
    private final BankCard bankCard;

    private final Double balance;

    public Client(String name,BankCard bankCard, Double balance) {
        this.name = name;
        this.bankCard = bankCard;
        this.balance = balance;
    }


    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Client: " + name + ", " + bankCard + ", balance: " + balance + "\n";
    }
}
