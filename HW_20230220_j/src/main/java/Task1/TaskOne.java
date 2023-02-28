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


    }

    public Integer[] addCommonElements(Integer[] arr1, Integer[] arr2) {
        Integer[] result = new Integer[0];

            if (arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0) {
                return new Integer[0];
            }

            Set<Integer> set = new LinkedHashSet();

            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr2.length; j++) {

                    if (arr1[i] == arr2[j]) {
                        set.add(arr1[i]);
                    }
                }
            }
            result = set.stream().toArray(Integer[]::new);
            System.out.println(Arrays.toString(result));


        return result;
    }
    public Integer[] findCommon(Integer[] a,  Integer[] b){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                set.add(a[i]);
            }
        }
        return set.toArray(new Integer[set.size()]);
    }
}