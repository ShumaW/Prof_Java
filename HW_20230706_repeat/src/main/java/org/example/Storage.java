package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {

    public static final Map<Client, Double> clientDoubleMap(int amount) {
        Map<Client, Double> map = new HashMap<>();
        for (int i = 0; i < amount; i++) {
            map.put(new Client(Generator.addNameOfClient(),
                    new BankCard(Generator.addBankCard(),
                            Generator.getRandomCurrency(),
                            Generator.getStatusBankCard()),
                    Generator.getBalance()),
                    Generator.getBalance());
        }

        return map;
    }


    public static List<Client> getListClientWithActiveCard(Map<Client, Double> map) {
        return map.keySet()
                .stream()
                .filter(k -> k.getBankCard().status().equals(Status.ACTIVE))
                .toList();
    }

    public static List<Client> getListClientWithBlockedCard(Map<Client, Double> map) {
        return map.keySet()
                .stream()
                .filter(k -> k.getBankCard().status().equals(Status.BLOCKED))
                .toList();
    }

    public static List<Client> getListClientWithBiggestBalance(Map<Client, Double> map) {
        return map.keySet()
                .stream()
                .filter(k -> k.getBalance() > 50_000)
                .toList();
    }

    public static List<Client> getListClientWithLessBalance(Map<Client, Double> map) {
        return map.keySet()
                .stream()
                .filter(k -> k.getBalance() < 50_000)
                .toList();
    }

    public static double getAverageBalance(Map<Client, Double> map) {
        return map.keySet()
                .stream()
                .mapToDouble(Client::getBalance)
                .average()
                .orElse(0.0);
    }

}
