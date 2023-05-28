import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("-".repeat(25) + " Task 1 " + "-".repeat(25));
        int[] arr1 = {22, 56, 13, 4, 9, 87, 11};
        System.out.println(sumElemArr(arr1));

        System.out.println("-".repeat(25) + " Task 2 " + "-".repeat(25));
        System.out.println(Arrays.toString(maxAndMinForArray(arr1)));

        System.out.println("-".repeat(25) + " Task 3 " + "-".repeat(25));
        System.out.println(secondElement(arr1));

        System.out.println("-".repeat(25) + " Task 4 " + "-".repeat(25));
        int[] arr2 = {1, 1, 9, 1, 1, 1, 9, 9, 9, 11, 9, 13, 9};
        mostFrequentElement(arr2);

        System.out.println("-".repeat(25) + " Task 5 " + "-".repeat(25));
        int[] arr3 = {1, 2, 3, 1, 3, 2, 1};
        int[] arr4 = {1, 9, 9, 1, 1, 9, 1, 1};
        System.out.println(isPalindrome(arr3));
        System.out.println(isPalindrome(arr4));

        System.out.println("-".repeat(25) + " Task 6 " + "-".repeat(25));
        int[] arr5 = {1, -2, 3, 10, -3, 2, 1};
        System.out.println(sumOfPositiveElem(arr5));

        System.out.println("-".repeat(25) + " Task 7 " + "-".repeat(25));
        System.out.println(findNumber(arr1, 5));
        System.out.println(findNumber(arr1, 11));

        System.out.println("-".repeat(25) + " Task 8 " + "-".repeat(25));
        ArrayList<Integer> list = new ArrayList<>(List.of(10, 101, 9, 12));
        System.out.println(sumElem(list));

        System.out.println("-".repeat(25) + " Task 9 " + "-".repeat(25));
        System.out.println(bigestElem(list));

        System.out.println("-".repeat(25) + " Task 10 " + "-".repeat(25));
        ArrayList<Integer> list1 = new ArrayList<>(List.of(22, 56, 13, 4, 9, 87, 11));
        System.out.println(list1);
        System.out.println(removeEvenElem(list1));

        System.out.println("-".repeat(25) + " Task 11 " + "-".repeat(25));
        ArrayList<Integer> list2 = new ArrayList<>(List.of(-2, 56, 13, 4, 9, -87, 11));
        System.out.println(list2);
        System.out.println(quantityPositiveElement(list2));

        System.out.println("-".repeat(25) + " Task 12 " + "-".repeat(25));
        System.out.println(findElemnt(list2, 4));

        System.out.println("-".repeat(25) + " Task 13 " + "-".repeat(25));
        System.out.println(list2);
        System.out.println(sortList(list2));

        System.out.println("-".repeat(25) + " Task 14 " + "-".repeat(25));
        System.out.println(secondMinElem(list2));

        System.out.println("-".repeat(25) + " Task 15 " + "-".repeat(25));
        ArrayList<Integer> list3 = new ArrayList<>(List.of(11, 2, 3, 1, 2, 4, 5, 6, 8));
        ArrayList<Integer> list4 = new ArrayList<>(List.of(1, 2, 9, 7, 6, 0));
        System.out.println(makeOneArrayList(list3, list4));

        System.out.println("-".repeat(25) + " Task 16 " + "-".repeat(25));
        ArrayList<Integer> list5 = new ArrayList<>(List.of(25, 26, 27, 28, 1, 2, 3, 4, 5, 9, 10, 11, 12));
        largestAscSequence(list5);

        System.out.println("-".repeat(25) + " Task 17 " + "-".repeat(25));
        ArrayList<Integer> list6 = new ArrayList<>(List.of(28, 27, 26, 25, 5, 4, 3, 2, 1, 0, 9, 10, 11, 12));
        largestDescSequence(list6);

        System.out.println("-".repeat(25) + " Task 18 " + "-".repeat(25));
        ArrayList<Integer> list7 = new ArrayList<>(List.of(1, 1, 9, 1, 1, 1, 9, 9, 9, 11, 9, 13, 9));
        System.out.println(removeDuplicate(list7));

        System.out.println("-".repeat(25) + " Task 19 " + "-".repeat(25));
        ArrayList<Integer> list8 = new ArrayList<>(List.of(13, 24, 1, 1, 9, 1, 1, 1, 9, 9, 9, 11, 9, 13, 9));
        System.out.println(removeAllDuplicateElem(list8));
    }

    /**
     * Задача 1 (Уровень сложности: 4):
     * Напишите программу, которая находит сумму всех элементов в заданном массиве.+
     */
    public static int sumElemArr(int[] arr) {
        int sum = 0;
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
        }
        return sum;
    }

    /**
     * Задача 2 (Уровень сложности: 5):
     * Напишите программу, которая находит наименьшее и наибольшее значение в заданном массиве.
     */
    public static int[] maxAndMinForArray(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        int[] minMax = {min, max};
        return minMax;
    }

    /**
     * Задача 3 (Уровень сложности: 5):
     * Напишите программу, которая находит второй по величине элемент в заданном массиве.
     */
    public static int secondElement(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1 + i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr[1];
    }

    /**
     * Задача 4 (Уровень сложности: 6):
     * Напишите программу, которая находит наиболее часто встречающийся
     * элемент в заданном массиве.
     */
    public static void mostFrequentElement(int[] arr) {
        int result = 0;
        int element = arr[0];
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1 + i; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > result) {
                element = arr[i];
            }
            result = Math.max(result, count);
            count = 1;
        }
        System.out.println("Most frequent element is: " + element + ", it meets " + result + " times");
    }

    /**
     * Задача 5 (Уровень сложности: 6):
     * Напишите программу, которая проверяет, является ли заданный массив палиндромом.
     * Палиндром - это массив, который читается одинаково вперед и назад.
     */
    public static boolean isPalindrome(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        boolean flag = false;
        while (left < right) {
            if (arr[left] == arr[right]) {
                flag = true;
            } else {
                flag = false;
            }
            left++;
            right--;
        }
        return flag;
    }

    /**
     * Задача 6 (Уровень сложности: 3):
     * Напишите программу, которая суммирует только положительные элементы в заданном массиве.
     */

    public static int sumOfPositiveElem(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                sum += arr[i];
            }
        }
        return sum;
    }

    /**
     * Задача 7 (Уровень сложности: 3):
     * Напишите программу, которая определяет, содержит ли заданный массив заданное значение.
     */
    public static boolean findNumber(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * ЛИСТЫ
     * Задача 8. Напишите метод для нахождения суммы всех элементов в ArrayList<Integer>.
     */
    public static int sumElem(ArrayList<Integer> list) {
        return list.stream().mapToInt(Integer::valueOf).sum();
    }

    /**
     * Задача 9. Напишите метод для поиска наибольшего числа в ArrayList<Integer>.
     */
    public static int bigestElem(ArrayList<Integer> list) {
        return list.stream().max(Integer::compare).get();
    }

    /**
     * Задача 10.Напишите метод для удаления всех четных чисел из ArrayList<Integer>.
     */
    public static List<Integer> removeEvenElem(ArrayList<Integer> list) {
        return list.stream().filter(x -> x % 2 != 0).toList();
    }

    /**
     * Задача 11.Напишите метод для определения количества положительных чисел в ArrayList<Integer>.
     */

    public static int quantityPositiveElement(ArrayList<Integer> list) {
        return (int) list.stream().filter(x -> x > 0).count();
    }

    /**
     * Задача 12.Напишите метод, который проверяет, содержит ли ArrayList<Integer> заданное число.
     */

    public static boolean findElemnt(ArrayList<Integer> list, Integer num) {
        return list.stream().anyMatch(num::equals);
    }

    /**
     * Задача 13.Напишите метод для сортировки ArrayList<Integer> в порядке возрастания.
     */

    public static List<Integer> sortList(ArrayList<Integer> list) {
        return list.stream().sorted().toList();
    }

    /**
     * Задача 14.Напишите метод для нахождения второго наименьшего числа в ArrayList<Integer>.
     */

    public static List<Integer> secondMinElem(ArrayList<Integer> list) {
        return list.stream().sorted().limit(2).skip(1).toList();
    }

    /**
     * Задача 15.Напишите метод, который объединяет два ArrayList<Integer> в один, удаляя дубликаты элементов.
     */

    public static ArrayList<Integer> makeOneArrayList(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<>();  //  1,2,3,1,2,4,5,6,8
        result.addAll(list1);
        result.addAll(list2);
        System.out.println(result);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 1 + i; j < result.size(); j++) {
                if (result.get(i) == result.get(j)) {
                    result.remove(j);
                }
            }

        }
        return result;
    }

    /**
     * Задача 16.Напишите метод для нахождения наибольшей возрастающей подпоследовательности в ArrayList<Integer>.----опционально
     */

    public static void largestAscSequence(ArrayList<Integer> list) {
        int count = 1;
        int maxSequence = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == list.get(i - 1) + 1) {
                count++;
                maxSequence = Math.max(maxSequence, count);
            } else {
                count = 1;
            }
        }
        System.out.println(maxSequence);
    }

    /**
     * Задача 17.Напишите метод для нахождения наибольшей убывающей подпоследовательности в ArrayList<Integer>..----опционально
     */

    public static void largestDescSequence(ArrayList<Integer> list) {
        int count = 1;
        int maxSequence = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == list.get(i - 1) - 1) {
                count++;
                maxSequence = Math.max(maxSequence, count);
            } else {
                count = 1;
            }
        }
        System.out.println(maxSequence);
    }

    /**
     * Задача 18.Напишите метод, который возвращает ArrayList<Integer> с уникальными элементами (удаляет дубликаты).
     */

    public static ArrayList<Integer> removeDuplicate(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 1 + i; j < list.size(); j++) {
                if (list.get(i) == list.get(j)) {
                    list.remove(j);
                    j--;
                }
            }
        }
        return list;
    }

    /**
     * Задача 19.Напишите метод, который удаляет все повторяющиеся элементы из ArrayList<Integer>.
     */

    public static ArrayList<Integer> removeAllDuplicateElem(ArrayList<Integer> list) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 1 + i; j < list.size(); j++) {
                if (list.get(i) == list.get(j)) {
                    list.remove(j);
                    j--;
                    count++;
                }
            }
            if (count > 0) {
                list.remove(i);
                count = 0;
                i--;
            }
        }
        return list;
    }
}