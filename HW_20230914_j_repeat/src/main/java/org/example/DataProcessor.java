package org.example;

import java.util.List;

public class DataProcessor {
    public <T> void processData(List<T> data) {
        int sum = 0;
        for (T num : data) {
            sum += (int) num;
        }
        System.out.println("Sum: " + sum);

        double average = (double) sum / data.size();
        System.out.println("Average: " + average);
    }
}
