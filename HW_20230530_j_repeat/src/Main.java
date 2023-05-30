import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("-".repeat(25) + " Task 1 " + "-".repeat(25));
        int[] arr1 = {1, 1, 1, 5, 6, 8, 12, 89, 101, 25, 89};
        System.out.println(convertArrayToListAndRemoveDuplicate(arr1));

        System.out.println("-".repeat(25) + " Task 2 " + "-".repeat(25));
        System.out.println(reverseArrayToList(arr1));

        System.out.println("-".repeat(25) + " Task 3 " + "-".repeat(25));
        int[] arr2 = {1, 5, 8, 7, 9, 2, 3};
        System.out.println(unionTwoArrays(arr1,arr2));

        System.out.println("-".repeat(25) + " Task 4 " + "-".repeat(25));
        System.out.println(numberOfUniqueElements(arr1));
    }

    /**
     * Задачи на ArrayList:
     * <p>
     * 1. Удаление дубликатов: Напишите метод, который принимает массив int и возвращает ArrayList, содержащий все
     * уникальные элементы исходного массива, сохраняя их порядок. Уровень сложности: 4.
     */

    public static List<Integer> convertArrayToListAndRemoveDuplicate(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int x : arr) {
            result.add(x);
        }
        return result.stream().distinct().toList();
    }

    /**
     * 2. Обратный порядок: Напишите метод, который принимает массив int и возвращает ArrayList, содержащий элементы
     * исходного массива в обратном порядке. Уровень сложности: 4.
     */
    public static List<Integer> reverseArrayToList(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            result.add(arr[i]);
        }
        return result;
    }

    /**
     * Задачи на Set:
     * <p>
     * 3. Поиск пересечения: Напишите метод, который принимает два массива int и возвращает Set, содержащий элементы,
     * которые присутствуют и в первом, и во втором массивах. Уровень сложности: 5.
     */
    public static Set<Integer> unionTwoArrays(int[] arr1, int[] arr2) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int x : arr1) {
            set.add(x);
        }
        for (int x : arr2) {
            set.add(x);
        }
        return set;
    }

    /** 4. Подсчет уникальных элементов: Напишите метод, который принимает массив int и возвращает количество
     * уникальных элементов в этом массиве, используя Set для хранения уникальных значений. Уровень сложности: 5.
     */

    public static int numberOfUniqueElements(int[] arr){
        Set<Integer> set = new LinkedHashSet<>();
        for (int x : arr) {
            set.add(x);
        }
        return set.size();
    }
}