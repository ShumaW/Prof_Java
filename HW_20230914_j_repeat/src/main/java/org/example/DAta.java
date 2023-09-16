package org.example;

import java.util.List;

public class DAta {

    public static double calculateAverage(List<Double> numbers) {
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        double average = sum / numbers.size();

        return average;
    }

    public double calculateStandardDeviation(List<Double> numbers){
        double variance = 0;
        for (double num : numbers) {
            variance += Math.pow(num - calculateAverage(numbers), 2);
        }
        double standardDeviation = Math.sqrt(variance / numbers.size());

        return standardDeviation;
    }
}
