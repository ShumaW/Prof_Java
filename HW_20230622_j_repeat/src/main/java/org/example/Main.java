package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("cat", "lemon", "dog", "god", "man", "nam", "tac");
        System.out.println(findPaarWord(words));
        System.out.println("-".repeat(50));

        String[] strings = {"hi", "hi", "Alina", "Nika", "Sara", "Alina"};
        System.out.println(Arrays.toString(findUnique(strings)));
        System.out.println("-".repeat(50));

        System.out.println(Arrays.toString(reversArray(strings)));
        System.out.println("-".repeat(50));

        Set<String> set = Set.of("hi", "Alina", "Nike", "Sara", "mike", "nika", "Ann");
        System.out.println(newSet(set));
        System.out.println("-".repeat(50));

        Set<String> set2 = Set.of("hi", "Malina", "Nike", "Saba", "Mika", "nika");
        System.out.println(setOfUniqueElement(set, set2));
        System.out.println("-".repeat(50));

        Set<String> stringSet = new HashSet<>();
        stringSet.add("Apple");
        stringSet.add("banana");
        stringSet.add("apple");
        stringSet.add("Banana");
        System.out.println(setUnique(stringSet));

    }

    //- У вас есть Map<String, Boolean>, представляющая студентов и их оценки
    //  (true - сдал экзамен, false - не сдал).
    //  Напишите функцию, которая находит и возвращает имена студентов, не сдавших экзамен.
    public static Set<String> findStudentsWithFalseValue(Map<String, Boolean> stringBooleanMap) {
        Set<String> result = new HashSet<>();

        for (Map.Entry<String, Boolean> entry : stringBooleanMap.entrySet()) {
            if (entry.getValue().equals(false)) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    //- У вас есть Map<String, Boolean>, представляющая список продуктов в магазине и
    //  информацию о их наличии (true - продукт в наличии, false - продукта нет).
    //  Напишите функцию, которая подсчитывает количество продуктов, которых нет в наличии.
    public static int amountOfProducts(Map<String, Boolean> productsMap) {
        int amount = 0;
        for (Map.Entry<String, Boolean> item : productsMap.entrySet()) {
            if (item.getValue().equals(false)) {
                amount++;
            }
        }
        return amount;
    }

    //- У вас есть список List<String>, содержащий имена людей.
    //  Напишите программу, которая выводит все имена, начинающиеся на определенную букву.
    //  List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Frank");
    //  char targetLetter = 'C';
    public static List<String> findNames(List<String> list, char x) {
        List<String> result = new ArrayList<>();
        for (String s : list) {
            if (s.startsWith(String.valueOf(x))) {
                result.add(s);
            }
        }
        return result;
    }

    //- У вас есть список List<String>, содержащий слова.
    //  Напишите программу, которая находит все пары слов, в которых первое слово является обратным написанию второго слова.
    //  List<String> words = Arrays.asList("lemon", "cat", "tac", "dog", "god", "man", "nam");
    public static Map<String, String> findPaarWord(List<String> words) {
        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder(words.get(i));
            String reverse = stringBuilder.reverse().toString();
            for (int j = i + 1; j < words.size(); j++) {
                if (reverse.equals(words.get(j))) {
                    result.put(words.get(i), words.get(j));
                }
            }
        }
        return result;
    }

    //-Напишите программу, которая находит сумму всех элементов в заданном массиве arr и выводит ее значение.
    public static int sumElements(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum;
    }

    //-Напишите программу, которая находит среднее арифметическое значение элементов в заданном массиве arr и выводит его.
    public static int countAvg(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum / arr.length;
    }

    /**
     * -Напишите программу, которая принимает на вход двумерный
     * массив int[][] и возвращает сумму всех элементов в массиве.
     */
    public static int getSum(int[][] arr) {
        int sum = 0;
        for (int[] ints : arr) {
            for (int i : ints) {
                sum += i;
            }
        }
        return sum;
    }

    /**
     * -Напишите программу, которая принимает на вход двумерный массив
     * int[][] и возвращает максимальное значение среди всех элементов в массиве.
     */
    public static int findMax(int[][] arr) {
        int max = arr[0][0];
        for (int[] ints : arr) {
            for (int x : ints) {
                if (x > max) {
                    max = x;
                }
            }
        }
        return max;
    }

    /**
     * -Напишите программу, которая принимает массив строк String[] и
     * возвращает новый массив, содержащий только уникальные строки из исходного массива
     */
    public static String[] findUnique(String[] strings) {

        Set<String> stringSet = new HashSet<>();
        Collections.addAll(stringSet, strings);
        for (int i = 0; i < strings.length; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if (strings[i].equals(strings[j])) {
                    stringSet.remove(strings[i]);
                }
            }
        }

        return stringSet.toArray(new String[0]);
    }

    /**
     * -Напишите программу, которая принимает массив строк String[]
     * и возвращает новый массив строк, в котором все строки перевернуты задом наперёд.
     */
    public static String[] reversArray(String[] array) {
        String[] result = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            StringBuilder stringBuilder = new StringBuilder(array[i]);
            String string = stringBuilder.reverse().toString();
            result[i] = string;
        }
        return result;
    }

    /**
     * -Напишите функцию, которая принимает на вход Set<String>
     * и возвращает новый Set<String>, содержащий только те строки, которые начинаются с заглавной буквы.
     */
    public static Set<String> newSet(Set<String> set) {
        Set<String> result = new HashSet<>();
        for (String s : set) {
            if (!(s.charAt(0) == s.toLowerCase().charAt(0))) {
                result.add(s);
            }
        }
        return result;
    }

    /**
     * -Напишите функцию, которая принимает на вход два Set<String> и
     * возвращает новый Set<String>, содержащий только те строки, которые присутствуют в обоих наборах.
     */
    public static Set<String> setOfUniqueElement(Set<String> set1, Set<String> set2) {
        Set<String> result = new HashSet<>();
        for (String s1 : set1) {
            for (String s2 : set2) {
                if (s1.equals(s2)) {
                    result.add(s1);
                }
            }
        }
        return result;
    }

    /**
     * - Напишите функцию, которая принимает на вход Set<String> и возвращает
     * новый Set<String>, содержащий только уникальные строки, игнорируя регистр символов
     * Set<String> stringSet = new HashSet<>();
     * stringSet.add("Apple");
     * stringSet.add("banana");
     * stringSet.add("apple");
     * stringSet.add("Banana");
     */
    public static Set<String> setUnique(Set<String> set) {
        Set<String> result = new HashSet<>();
        for (String s : set) {
            result.add(s.toLowerCase());
        }
        return result;
    }
}

