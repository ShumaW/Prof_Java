package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        MyClass.writeFile(MyClass.generateIntArr(20));
        System.out.println(MyClass.readFileAndWriteIntegerList());

        System.out.println(MyClass.getListString());

        System.out.println(MyClass.getLineOfString());

        //Задача 1: Подсчет количества уникальных четных и нечетных чисел
        System.out.println("-".repeat(25) + " Task 1 " + "-".repeat(25));

        List<Integer> numbers = MyClass.readFileAndWriteIntegerList();
        System.out.println(numbers.stream()
                .distinct()
                .collect(Collectors.groupingBy(n -> n % 2, Collectors.counting())));

        //Задача 2: Группировка строк по первым буквам и вывод первых двух из каждой группы
        System.out.println("-".repeat(25) + " Task 2 " + "-".repeat(25));

        List<String> words = MyClass.getListString();
        Map<Character, List<String>> collect = words.stream()
                .collect(Collectors.groupingBy(n -> n.toLowerCase().charAt(0)));
        collect.forEach((key, value) -> {
            System.out.println("Key: " + key + ", value: " + value.stream().limit(2).toList());
        });

        //Задача 4: Фильтрация и умножение числа на 2
        System.out.println("-".repeat(25) + " Task 4 " + "-".repeat(25));

        List<Integer> numbers2 = MyClass.readFileAndWriteIntegerList();
        System.out.println(numbers2.stream()
                .filter(el -> el % 2 == 0)
                .map(n -> n * 2)
                .toList());

        //Задача 5: Разделение чисел на простые и составные
        System.out.println("-".repeat(25) + " Task 5 " + "-".repeat(25));

        List<Integer> numbers3 = MyClass.readFileAndWriteIntegerList();
        System.out.println(numbers3.stream()
                .collect(Collectors.partitioningBy(Main::isPrime)));
        //Задача 6: Получение уникальных символов из списка строк
        System.out.println("-".repeat(25) + " Task 6 " + "-".repeat(25));

        List<String> words2 = MyClass.getListString();
        System.out.println(words2.stream()
                .flatMapToInt(String::chars)
                .mapToObj(ch -> (char) ch)
                .map(Character::toLowerCase)
                .distinct()
                .sorted()
                .toList());

        //Задача 7: Разделение строк на отдельные слова и удаление повторений
        System.out.println("-".repeat(25) + " Task 7 " + "-".repeat(25));

        List<String> sentences = MyClass.getLineOfString();
        System.out.println(sentences.stream()
                .flatMap(str -> Arrays.stream(str.split(" ")))
                .filter(el -> el.matches("[a-zA-Z]+"))
                .distinct()
                .toList());

        //Задача 8: Фильтрация и преобразование строк toUpperCase
        System.out.println("-".repeat(25) + " Task 8 " + "-".repeat(25));

        List<String> words3 = MyClass.getListString();
        System.out.println(words3.stream()
                .filter(str -> str.length() >= 5)
                .map(String::toUpperCase)
                .toList());

        //Задача 9: Получение среднего значения чисел
        System.out.println("-".repeat(25) + " Task 9 " + "-".repeat(25));

        List<Integer> numbers4 = MyClass.readFileAndWriteIntegerList();
        System.out.println(numbers4.stream()
                .mapToInt(Integer::valueOf)
                .average()
                .orElse(0.0));

        //Задача 10: Получение списка квадратов чисел
        System.out.println("-".repeat(25) + " Task 10 " + "-".repeat(25));

        List<Integer> numbers5 = MyClass.readFileAndWriteIntegerList();
        System.out.println(numbers5.stream()
                .map(n -> n * n)
                .toList());

        //Задача 11: Группировка строк по длине
        System.out.println("-".repeat(25) + " Task 11 " + "-".repeat(25));

        List<String> words4 = MyClass.getListString();
        System.out.println(words4.stream()
                .collect(Collectors.groupingBy(String::length)));

        //Задача 13: Поиск первой строки, удовлетворяющей условию
        System.out.println("-".repeat(25) + " Task 13 " + "-".repeat(25));

        List<String> words6 = MyClass.getListString();
        System.out.println(words6.stream()
                .dropWhile(str -> !str.startsWith("b"))
                .limit(1)
                .findAny().orElse(""));
        //Задача 14: Сокращение списка до указанного размера
        System.out.println("-".repeat(25) + " Task 14 " + "-".repeat(25));

        List<Integer> numbers6 = MyClass.readFileAndWriteIntegerList();
        System.out.println(numbers6.stream()
                .takeWhile(el -> el < 15)
                .toList());


    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}