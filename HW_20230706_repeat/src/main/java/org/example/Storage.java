package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {

    static Client c1 = new Client(new BankCard(Currency.EURO, Status.ACTIVE));
    static Client c2 = new Client(new BankCard(Currency.GBP, Status.ACTIVE));
    static Client c3 = new Client(new BankCard(Currency.USD, Status.ACTIVE));
    static Client c4 = new Client(new BankCard(Currency.UAH, Status.ACTIVE));
    static Client c5 = new Client(new BankCard(Currency.CAD, Status.ACTIVE));
    static Client c6 = new Client(new BankCard(Currency.CAD, Status.BLOCKED));
    static Client c7 = new Client(new BankCard(Currency.UAH, Status.BLOCKED));
    static Client c8 = new Client(new BankCard(Currency.EURO, Status.BLOCKED));
    static Client c9 = new Client(new BankCard(Currency.GBP, Status.BLOCKED));
    static Client c10 = new Client(new BankCard(Currency.EURO, Status.ACTIVE));
    static Client c11 = new Client(new BankCard(Currency.EURO, Status.ACTIVE));
    static Client c12 = new Client(new BankCard(Currency.GBP, Status.ACTIVE));
    static Client c13 = new Client(new BankCard(Currency.GBP, Status.ACTIVE));
    static Client c14 = new Client(new BankCard(Currency.GBP, Status.BLOCKED));

    static Map<Client, Double> map = new HashMap<>();

    public static final Map<Client, Double> clientDoubleMap() {
        map.put(c1, c1.getBalance());
        map.put(c2, c2.getBalance());
        map.put(c3, c3.getBalance());
        map.put(c4, c4.getBalance());
        map.put(c5, c5.getBalance());
        map.put(c6, c6.getBalance());
        map.put(c7, c7.getBalance());
        map.put(c8, c8.getBalance());
        map.put(c9, c9.getBalance());
        map.put(c10, c10.getBalance());
        map.put(c11, c11.getBalance());
        map.put(c12, c12.getBalance());
        map.put(c13, c13.getBalance());
        map.put(c14, c14.getBalance());

        return map;
    }

    public Storage() {
    }

    public static List<Client> getListClientWithActiveCard(Map<Client, Double> map){
        return map.keySet()
                .stream()
                .filter(k -> k.getBankCard().getStatus().equals(Status.ACTIVE))
                .toList();
    }

    public static List<Client> getListClientWithBlockedCard(Map<Client, Double> map){
        return map.keySet()
                .stream()
                .filter(k -> k.getBankCard().getStatus().equals(Status.BLOCKED))
                .toList();
    }

    public static List<Client> getListClientWithBiggestBalance(Map<Client, Double> map){
        return map.keySet()
                .stream()
                .filter(k -> k.getBalance() > 50_000)
                .toList();
    }

    public static List<Client> getListClientWithLessBalance(Map<Client, Double> map){
        return map.keySet()
                .stream()
                .filter(k -> k.getBalance() < 50_000)
                .toList();
    }

    public static double getAverageBalance(Map<Client, Double> map){
        return map.keySet()
                .stream()
                .mapToDouble(Client::getBalance)
                .average()
                .orElse(0.0);
    }

}
