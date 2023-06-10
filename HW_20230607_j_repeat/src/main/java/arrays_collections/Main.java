package arrays_collections;

import java.util.Arrays;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        // Создайте массив целых чисел с некоторыми значениями и инициализируйте его.
        int[] array = {25, 110, 83, 18, 72, 115};

        //Создайте коллекцию (например, ArrayList или LinkedList) целых чисел и добавьте в
        // нее несколько значений.
        List<Integer> list = List.of(5, 10, 3, 8, 2);

        // Используя цикл for, переберите элементы массива и выведите каждый элемент на экран.
        for (int x : array) {
            System.out.println(x);
        }
        System.out.println("-".repeat(50));

        // Используя цикл for-each, переберите элементы коллекции и выведите каждый элемент на экран.

        list.forEach(System.out::println);
        System.out.println("-".repeat(50));

        // Найдите сумму всех элементов в массиве и выведите ее на экран.
        System.out.println(Arrays.stream(array).sum());
        System.out.println("-".repeat(50));

        // Найдите сумму всех элементов в коллекции и выведите ее на экран.
        System.out.println(list.stream().mapToInt(Integer::intValue).sum());
        System.out.println("-".repeat(50));

        // Найдите наименьшее и наибольшее значение в массиве и выведите их на экран.
        findMinAndMaxInArr(array);
        System.out.println("Minimum in array: " + Arrays.stream(array).min().getAsInt());
        System.out.println("Maximum in array: " + Arrays.stream(array).max().getAsInt());
        System.out.println("-".repeat(50));

        // Найдите наименьшее и наибольшее значение в коллекции и выведите их на экран.
        findMinAndMaxInList(list);
        System.out.println("Minimum in list: " + list.stream().mapToInt(Integer::valueOf).min().getAsInt());
        System.out.println("Maximum in list: " + list.stream().mapToInt(Integer::valueOf).max().getAsInt());
        System.out.println("-".repeat(50));

        // Посчитайте количество элементов в массиве и выведите его на экран.
        System.out.println(Arrays.stream(array).count());
        // Посчитайте количество элементов в коллекции и выведите его на экран.
        System.out.println(list.size());
        System.out.println("-".repeat(50));

        // Подсчитайте среднее арифметическое всех элементов в массиве и выведите его на экран.
        System.out.println("Average in array: " + Arrays.stream(array).average().getAsDouble());
        // Подсчитайте среднее арифметическое всех элементов в коллекции и выведите его на экран.
        System.out.println("Average in list: " + list.stream().mapToInt(Integer::valueOf).average().getAsDouble());
    }

    public static void findMinAndMaxInArr(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("In array min: " + min + ", max: " + max);
    }

    public static void findMinAndMaxInList(List<Integer> list) {
        int min = list.get(0);
        int max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        System.out.println("In list min: " + min + ", max: " + max);
    }
}
