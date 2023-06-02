package org.example;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Calculator {
    private double num1;
    private double num2;
    private String action;

    public double getResult() {
        double result = 0;
        if (!action.equals("*") && !action.equals("/") && !action.equals("+") && !action.equals("-")){
            System.out.println("You entered the wrong action!!!");
        } else {
            switch (action) {
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                        break;
                    } else {
                        System.out.println("Error: You can't divide by zero!");
                        System.exit(0);
                    }
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                default:
                    System.exit(0);
            }
        }
        return result;
    }
}

// .\d\+\d.
