package Task2;

import java.util.LinkedHashSet;
import java.util.Set;

public class TaskTwo {
    public static void main(String[] args) {
        /*
        Напишите программу на Java и тест для нее для удаления
        повторяющихся элементов из массива.
        example input:
        [0,3,-2,4,3,2]

        example expected:
        [0,3,-2,4,2]
         */
        int[] arr = {0, 3, -2, 4, 3, 2, 5, 5, 6, 6, 77, -2};

        deleteRepeatingElements(arr);

    }

    public static boolean deleteRepeatingElements(int[] arr) {
        try {
            if (arr == null) throw new NullPointerException("Array is NULL!");

            Set set = new LinkedHashSet();

            for (int i = 0; i < arr.length; i++) {
                set.add(arr[i]);
            }
            System.out.println(set);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
