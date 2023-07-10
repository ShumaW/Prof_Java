package org.example;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        final Map<Client, Double> clientDoubleMap = Storage.clientDoubleMap();
        System.out.println("-".repeat(50));

        clientDoubleMap.entrySet().forEach(System.out::println);
        System.out.println("-".repeat(50));

        System.out.println(Storage.getListClientWithActiveCard(clientDoubleMap));
        System.out.println("-".repeat(50));

        System.out.println(Storage.getListClientWithBlockedCard(clientDoubleMap));
        System.out.println("-".repeat(50));

        System.out.println(Storage.getListClientWithBiggestBalance(clientDoubleMap));
        System.out.println("-".repeat(50));

        System.out.println(Storage.getListClientWithLessBalance(clientDoubleMap));
        System.out.println("-".repeat(50));

        System.out.println(Storage.getAverageBalance(clientDoubleMap));
        System.out.println("-".repeat(50));




    }
}