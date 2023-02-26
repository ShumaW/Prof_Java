package Task2;

import java.util.Arrays;
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




    }

    public  int[] deleteRepeatingElements(int[] arr) {
        int[] res = {0};
        try {
            if (arr == null) throw new NullPointerException("Array is NULL!");

            res = Arrays.stream(arr).distinct().toArray();
            System.out.println(Arrays.toString(res));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
}
