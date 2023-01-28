import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /*
        1. Напишите код, который создает Stream из массива чисел,
        фильтрует его по четным числам и выводит результат в консоль.

        2. Напишите код, который создает Stream из списка строк,
        отсортировывает его по длине строк и выводит результат в консоль.

        3.Напишите код, который создает Stream из диапазона чисел,
        отображает каждое число к его квадрату и выводит результат в консоль.

        4.Напишите код, который создает Stream из списка объектов,
        объединяет их в одну строку и выводит результат на консоль.

        5.Напишите код, который создает Stream из списка чисел, используя
        метод reduce() находит наибольшее число в списке.

        6.Напишите код, который создает Stream из Map, используя метод
        filter() и метод forEach() выводит ключ-значение только тех элементов,
        значение которых больше заданного.

        7.Напишите код, который считывает текстовый файл и используя Stream API,
        подсчитывает количество слов в файле.
         */

        System.out.println("-".repeat(25) + " 1. Напишите код, который создает Stream из массива чисел, " + "-".repeat(25) + "\n" + " ".repeat(26) +
                "фильтрует его по четным числам и выводит результат в консоль. ");
        Integer[] arrNum = {1, 8, 56, 14, 21, 23, 22, 1056};

        System.out.println(Arrays.toString(Arrays.stream(arrNum)
                .filter(x -> (x % 2) == 0)
                .toArray(Integer[]::new)));

        System.out.println("-".repeat(25) + " 2. Напишите код, который создает Stream из списка строк, " + "-".repeat(25) + "\n" + " ".repeat(26) +
                "отсортировывает его по длине строк и выводит результат в консоль. ");

        List<String> listStr = Arrays.asList("ufouv", "fgh", "ljhbvkiguy", "luhguiygiygfpyug", "k", "jh");
        System.out.println(listStr.stream()
                .sorted((o1, o2) -> o1.length() - o2.length())
                .collect(Collectors.toList()));

        System.out.println("-".repeat(25) + " 3.Напишите код, который создает Stream из диапазона чисел, " + "-".repeat(25) + "\n" + " ".repeat(26) +
                "отображает каждое число к его квадрату и выводит результат в консоль. ");

        Integer[] rangeNum = {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Arrays.stream(rangeNum)
                .forEach(x -> System.out.printf(x + "->" + (x * x) + "; "));
        System.out.println("");

        System.out.println("-".repeat(25) + " 4.Напишите код, который создает Stream из списка объектов, " + "-".repeat(25) + "\n" + " ".repeat(26) +
                "объединяет их в одну строку и выводит результат на консоль. ");

        List<Person> listOfPerson = Arrays.asList(
                new Person("Jack", "Po", 25),
                new Person("Ann", "Dou", 29),
                new Person("Michael", "Jacson", 45),
                new Person("Vasya", "Pupkin", 33));

        listOfPerson.stream()
                .forEach(x -> System.out.printf(String.valueOf(x)));
        System.out.println();

        System.out.println("-".repeat(25) + " 5.Напишите код, который создает Stream из списка чисел, используя " + "-".repeat(25) + "\n" + " ".repeat(26) +
                "метод reduce() находит наибольшее число в списке. ");

        List<Integer> listInt = Arrays.asList(455, 15, 78, 36, 11, 121, 125, 251, 6554);
        System.out.println(listInt.stream()
                .reduce(0, Integer::max));

        System.out.println("-".repeat(25) + " 6.Напишите код, который создает Stream из Map, используя метод " + "-".repeat(25) + "\n" + " ".repeat(26) +
                "filter() и метод forEach() выводит ключ-значение только тех элементов," + "\n" + " ".repeat(26) +
                "значение которых больше заданного. ");

        Map<Integer, String> stringMap = new HashMap<>();
        stringMap.put(1, "Vasya");
        stringMap.put(2, "Jack");
        stringMap.put(3, "Nick");
        stringMap.put(4, "John");
        stringMap.put(5, "Sem");

        stringMap.entrySet().stream()
                .filter(x -> x.getKey() >= 3)
                .forEach(System.out::println);

        System.out.println("-".repeat(25) + " 7.Напишите код, который считывает текстовый файл и используя Stream API, " + "-".repeat(25) + "\n" + " ".repeat(26) +
                "подсчитывает количество слов в файле. ");

        try {
            InputStream stream = new FileInputStream("data.txt");
            Reader reader1 = new InputStreamReader(stream);

            int data = reader1.read();

            while (data != -1) {
                System.out.print((char) data);
                data = reader1.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

        Stream<String> lines =
                null;
        try {
            lines = Files.lines(Paths.get("data.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        long wordsCount = lines
                .flatMap(s -> Stream.of(s.split("[\s\n\t\r]+")).filter(t -> !t.isEmpty()))
                .count();

        System.out.println("Number of words: " + wordsCount);
    }
}