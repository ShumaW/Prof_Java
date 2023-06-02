package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean flag = true;

        while (flag) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a first number: ");

            double num1 = scanner.nextDouble();
            System.out.println("Enter an action (+,-,*,/): ");
            String action = scanner.next();
            System.out.println("Enter a second number: ");
            double num2 = scanner.nextDouble();

            Calculator calculator = new Calculator(num1, num2, action);
            System.out.println("Result: " + calculator.getResult());

            System.out.println("Are we continuing? (y/n) : ");
            String temp = scanner.next();
            if (temp.equals("n")){
                flag = false;
            }
        }

    }
}