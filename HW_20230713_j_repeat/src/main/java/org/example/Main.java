package org.example;

import org.example.handler.Handler;

public class Main {
    public static void main(String[] args) {

        System.out.println(Handler.getListMansWithSportCar());
        System.out.println("-".repeat(50));

        System.out.println(Handler.groupingByGender());

        System.out.println("-".repeat(50));

        System.out.println(Handler.getMapOfDevelopers());
        Handler.writeToFile();
    }
}