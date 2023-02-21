package Task1;

import java.util.*;

public class TaskOne {
    public static void main(String[] args) {

        /*
        1. Напишите программу на Java и тест для нее для поиска
        общих элементов между двумя массивами целых чисел
        example input:
        Array1: [1, 2, 5, 5, 8, 9, 7, 10]

        Array2: [1, 0, 6, 15, 6, 4, 7, 0]

        example expected:
        [1,7]
         */
        int[] arr1 = {1, 2, 5, 5, 8, 9, 7, 10};
        int[] arr2 = {1, 0, 6, 15, 6, 4, 7, 0, 5};

        addCommonElements(arr1, arr2);
    }

    public static boolean addCommonElements(int[] arr1, int[] arr2) {
        try {
            if (arr1 == null || arr2 == null) {
                throw new NullPointerException("One from two arrays is NULL!");
            }

            Set set = new LinkedHashSet();

            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr2.length; j++) {

                    if (arr1[i] == arr2[j]) {
                        set.add(arr1[i]);
                    }
                }
            }
            System.out.println(set);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}