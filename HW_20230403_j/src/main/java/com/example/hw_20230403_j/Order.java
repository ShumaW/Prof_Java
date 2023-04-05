package com.example.hw_20230403_j;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order {
    private String item;
    private double price;

    public Order() {
    }

    public Order(String item, double price) {
        this.item = item;
        this.price = price;
    }

    public void introduce(){
        System.out.println("Action on init step");
    }

    public void finishOperation(){
        System.out.println("Final work with bean");
    }
}
