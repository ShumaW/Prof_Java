package org.example;

import java.util.Arrays;
import java.util.List;

public class MathUtils {

    public static int calculateSumOfArrayElements(int[] numbers) {
        return Arrays.stream(numbers)
                .sum();
    }

    public static int calculateSumOfListElements(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
