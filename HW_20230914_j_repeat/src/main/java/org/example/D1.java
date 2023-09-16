package org.example;

import java.util.List;

public class D1 {
    public double calculateAverageValueForGivenList(List<Double> listOfNumbers) {

        return listOfNumbers.stream()
                .mapToDouble(el -> el)
                .average()
                .orElse(0.0);
    }
}
