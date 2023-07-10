package org.example;

public class Client {
    private final String name;

    private final BankCard bankCard;

    private final Double balance;

    public Client(BankCard bankCard) {
        this.name = Generator.addNameOfClient();
        this.bankCard = bankCard;
        this.balance = Generator.getBalance();
    }

    public String getName() {
        return name;
    }

    public BankCard getBankCard() {
        return bankCard;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Client: " + name + ", " + bankCard + ", balance: " + balance + "\n";
    }
}
