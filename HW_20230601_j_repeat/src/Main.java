import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("-".repeat(25) + " Task 1 " + "-".repeat(25));
        List<String> permutations = getPermutations("кот");
        for (String permutation : permutations) {
            System.out.println(permutation);
        }

        System.out.println("-".repeat(25) + " Task 2 " + "-".repeat(25));
        System.out.println(isAnagram("южучка", "кажуч"));

        System.out.println("-".repeat(25) + " Task 3 " + "-".repeat(25));
        allSubstrings("мышь");

        System.out.println("-".repeat(25) + " Task 4 " + "-".repeat(25));
        Integer[] arrInt = {52, 4, 6, 8, 9, 32, 125, 52, 62, 23};
        String[] strArr = {"John", "Nike", "Mike", "Ann", "Sem"};
        printArray(arrInt);
        printArray(strArr);

    }

    /**
     * Уровень сложности: 4/10
     * Напишите программу, которая принимает на вход строку и выводит все перестановки символов этой строки.
     */
    public static List<String> getPermutations(String string) {
        List<String> result = new ArrayList<>();
        permute(string.toCharArray(), 0, result);
        return result;
    }

    private static void permute(char[] chars, int index, List<String> permutationList) {
        if (index == chars.length - 1) {
            permutationList.add(String.valueOf(chars));
        } else {
            for (int i = index; i < chars.length; i++) {
                swap(chars, index, i);
                permute(chars, index + 1, permutationList);
                swap(chars, index, i);
            }
        }
    }

    /**
     * Задача 2 (Сложность: 3/10):
     * Реализуйте параметризированный метод "swap", который принимает массив элементов и два индекса внутри массива.
     * Метод должен поменять местами элементы по указанным индексам.
     */
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    /**
     * Уровень сложности: 3/10
     * Напишите программу, которая принимает на вход две строки и проверяет, являются ли они анаграммами
     * (т.е. содержат ли они одинаковые символы в разном порядке).
     */

    public static boolean isAnagram(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int[] temp = new int[chars1.length];
        int index = 0;
        if (chars1.length != chars2.length) {
            return false;
        } else {
            for (char c : chars1) {
                for (char value : chars2) {
                    if (c == value) {
                        temp[index] = 1;
                        index++;
                    }
                }
            }
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Уровень сложности: 4/10
     * Напишите программу, которая принимает на вход строку и выводит все подстроки этой строки.
     */

    public static void allSubstrings(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                System.out.println(str.substring(i, j));
            }
        }
    }
//    /** Уровень сложности: 3/10
//    * Напишите программу, которая принимает на вход две строки и проверяет, является ли одна строка перестановкой
//    * другой строки.
//    */

    /** Уровень сложности: 3/10
     * Напишите программу, которая принимает на вход строку и выводит все возможные комбинации символов этой
     * строки в порядке возрастания их длины.
     */

    /**
     * Задача 4 (Сложность: 3/10):
     * Напишите параметризированный метод "printArray", который принимает массив элементов и выводит их на консоль.
     * Метод должен работать с любыми типами данных.
     */
    public static <T> void printArray(T[] arr) {
//        for (T elem : arr) {
//            System.out.println(elem);
//        }
        Arrays.stream(arr).forEach(System.out::println);
    }

}