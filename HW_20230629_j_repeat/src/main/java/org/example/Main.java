package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {

        // Дан список строк. Необходимо отфильтровать строки, длина которых больше 3 символов, преобразовать их
        // в верхний регистр, удалить повторяющиеся и вывести результат в отсортированном порядке.

        System.out.println("-".repeat(25) + " 1 " + "-".repeat(25));
        List<String> stringList = Arrays.asList("Dima", "Anna", "Sem", "Roman", "Vadim", "Evgeny", "Vladislav", "Andrey");
        System.out.println(stringList.stream()
                .filter(el -> el.length() > 3)
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .toList());

        // Дан список слов. Необходимо найти среднюю длину слов, начинающихся с буквы "A".

        System.out.println("-".repeat(25) + " 2 " + "-".repeat(25));
        System.out.println(stringList.stream()
                .filter(s -> s.startsWith("A"))
                .mapToInt(String::length)
                .average()
                .orElse(0.0));

        // Дан список слов. Необходимо сгруппировать их по длине и вывести результат.

        System.out.println("-".repeat(25) + " 3 " + "-".repeat(25));
        System.out.println(stringList.stream()
                .collect(groupingBy(String::length)));

        // Дан список чисел. Необходимо найти наименьшее число, больше 0.

        System.out.println("-".repeat(25) + " 4 " + "-".repeat(25));
        List<Integer> integerList = List.of(1, -5, -25, 9, 1, 2, 8, 4, 56, 0, 14, -25, 3, 2, 5, 7, 6);
        System.out.println(integerList.stream()
                .filter(n -> n > 0)
                .sorted()
                .limit(1)
                .toList());

        // Дан список чисел. Необходимо найти сумму квадратов всех положительных чисел.

        System.out.println("-".repeat(25) + " 5 " + "-".repeat(25));
        System.out.println(integerList.stream()
                .filter(n -> n > 0)
                .map(n -> n * n)
                .sorted()
                .distinct()
                .toList());

        // Даны два списка чисел. Необходимо объединить их в один список, отсортировать по убыванию и
        // удалить повторяющиеся элементы.

        System.out.println("-".repeat(25) + " 6 " + "-".repeat(25));
        List<Integer> list1 = List.of(1, 2, 3, 4, 5, 6, 7);
        List<Integer> list2 = List.of(5, 6, 7, 8, 9, 1, 10, 11, 11, 12, 13);

        System.out.println(Stream.of(list1, list2)
                .flatMap(Collection::stream)
                .sorted((o1, o2) -> o2 - o1)
                .distinct()
                .collect(toList()));

        // Дан список строк. Необходимо оставить только уникальные символы из всех строк и вывести их в
        // алфавитном порядке.

        System.out.println("-".repeat(25) + " 7 " + "-".repeat(25));
        System.out.println(stringList.stream()
                .map(String::toUpperCase)
                .flatMapToInt(CharSequence::chars)
                .mapToObj(ch -> (char) ch)
                .distinct()
                .sorted()
                .toList());

        // Дан список чисел. Необходимо найти второе максимальное число.

        System.out.println("-".repeat(25) + " 8 " + "-".repeat(25));
        System.out.println(integerList.stream()
                .sorted((o1, o2) -> o2 - o1)
                .limit(2)
                .skip(1)
                .toList());

        // Дан список слов. Необходимо отфильтровать слова, состоящие только из букв, разделить их на гласные
        // и согласные, и вывести результат.

        System.out.println("-".repeat(25) + " 9 " + "-".repeat(25));

        List<String> filteredWords = stringList.stream()
                .filter(word -> word.matches("[a-zA-Z]+"))
                .toList();
        System.out.println(filteredWords);

        List<String> startWithVowel = filteredWords.stream()
                .filter(word -> word.matches("(?i)^[aeiou].*"))
                .toList();
        System.out.println(startWithVowel);

        List<String> startWithConsonant = filteredWords.stream()
                .filter(word -> word.matches("(?i)^[^aeiou].*"))
                .toList();
        System.out.println(startWithConsonant);

        // Дан список строк. Необходимо удалить пустые строки, объединить оставшиеся строки в одну строку,
        // разделенную запятой.

        System.out.println("-".repeat(25) + " 10 " + "-".repeat(25));
        List<String> stringList1 = List.of("Mama", "Oma", "", "Opa", "Muter", "", "Father");
        System.out.println(stringList1.stream()
                .filter(word -> !(word.matches("")))
                .collect(joining(", ")));

        // Дан список слов. Необходимо объединить все символы из всех слов в одну строку.

        System.out.println("-".repeat(25) + " 11 " + "-".repeat(25));
        System.out.println(stringList1.stream()
                .filter(str -> !(str.matches("")))
                .collect(joining()));

        // Дан список слов. Необходимо проверить, содержат ли они одинаковые символы (являются ли анаграммами)
        // и вывести результат.

        System.out.println("-".repeat(25) + " 12 " + "-".repeat(25));
        List<String> listStr = List.of("Mara", "Kazak", "Abba", "Otto", "Rama", "Windows");
        System.out.println(isAnagram(listStr));
        List<String> listStr1 = List.of("Mara", "Rama", "Maar");
        System.out.println(isAnagram(listStr1));


        // Даны два списка чисел. Необходимо найти разность множеств (элементы, присутствующие только в одном
        // из списков) и вывести результат.
        System.out.println("-".repeat(25) + " 13 " + "-".repeat(25));
        List<Integer> integerList1 = List.of(5, 47, 55, 12, 41, 63);
        List<Integer> integerList2 = List.of(15, 44, 5, 28, 98, 101, 10, 41, 55);
        List<Integer> integers1 = integerList1.stream()
                .filter(el -> !integerList2.contains(el))
                .toList();
        List<Integer> integers2 = integerList2.stream()
                .filter(el -> !integerList1.contains(el))
                .toList();
        System.out.println(Stream.concat(integers1.stream(), integers2.stream())
                .sorted()
                .toList());

        // Дан список слов. Необходимо подсчитать количество слов для каждой длины и вывести результат.
        System.out.println("-".repeat(25) + " 14 " + "-".repeat(25));
        System.out.println(Arrays.toString(listStr.stream()
                .mapToInt(String::length)
                .toArray()));
        System.out.println(listStr.size());

        // Дан список строк. Необходимо отфильтровать строки, которые начинаются с префикса "pre" и заканчиваются
        // суффиксом "post".
        System.out.println("-".repeat(25) + " 15 " + "-".repeat(25));
        List<String> listWithPre = List.of("nananan", "pre-to-post", "ajective", "prerorororpost");
        System.out.println(listWithPre.stream()
                .filter(el -> el.startsWith("pre") && el.endsWith("post"))
                .toList());

        // Дан список слов. Необходимо подсчитать количество символов в каждом слове и вывести результат.
        System.out.println("-".repeat(25) + " 16 " + "-".repeat(25));
        System.out.println(Arrays.toString(listWithPre.stream()
                .mapToInt(String::length)
                .toArray()));

        // Дан список чисел. Необходимо найти среднее значение всех уникальных чисел.
        System.out.println("-".repeat(25) + " 17 " + "-".repeat(25));
        List<Integer> numbers = List.of(101, 15, 44, 55, 5, 28, 98, 101, 10, 41, 55, 98);
        System.out.println(numbers.stream()
                .distinct()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0));

        // Дан список слов. Необходимо найти самое длинное слово с четной длиной.
        System.out.println("-".repeat(25) + " 18 " + "-".repeat(25));
        System.out.println(listWithPre.stream()
                .filter(el -> el.length() % 2 == 0)
                .sorted((o1, o2) -> o2.length() - o1.length())
                .limit(1)
                .toList());

        // Дан список строк. Необходимо удалить все пробелы в каждой строке, отсортировать их в лексикографическом
        // порядке и вывести результат.
        System.out.println("-".repeat(25) + " 19 " + "-".repeat(25));
        List<String> strings = List.of("Мама мыла раму", "Ухо горло нос", "Ехал грека через реку");
        System.out.println(strings.stream()
                .map(el -> el.replaceAll(" ", ""))
                .sorted(String::compareTo)
                .toList());

        // Дан список слов. Необходимо проверить, являются ли они палиндромами, и вывести результат.
        System.out.println("-".repeat(25) + " 20 " + "-".repeat(25));
        List<String> reverseStringList = listStr.stream()
                .map(String::toLowerCase)
                .map(StringBuffer::new)
                .map(StringBuffer::reverse)
                .map(StringBuffer::toString)
                .toList();
        System.out.println(listStr.stream()
                .map(String::toLowerCase)
                .filter(reverseStringList::contains)
                .toList());

        // Дан список чисел. Необходимо найти максимальное четное число.
        System.out.println("-".repeat(25) + " 21 " + "-".repeat(25));
        System.out.println(numbers.stream()
                .filter(el -> el % 2 == 0)
                .max(Comparator.naturalOrder())
                .orElse(0));

        // Дан список строк. Необходимо объединить все строки в одну строку, добавив префикс ">>" и
        // суффикс "<<" к каждой строке.
        System.out.println("-".repeat(25) + " 22 " + "-".repeat(25));
        System.out.println(listStr.stream()
                .map(el -> el.replaceAll(el, ">>" + el + "<<"))
                .collect(joining()));

        // Дан список строк.Необходимо объединить все символы из всех строк, удалить дубликаты и отсортировать их
        // в лексикографическом порядке.
        System.out.println("-".repeat(25) + " 23 " + "-".repeat(25));
        String collect = listStr.stream()
                .map(String::toLowerCase)
                .collect(joining());
        char[] charArray = collect.toCharArray();
        List<Character> characterList = IntStream.range(0, charArray.length)
                .mapToObj(el -> charArray[el])
                .toList();
        System.out.println(characterList.stream()
                .distinct()
                .sorted()
                .toList());

        // Дан список объектов Person с полем "возраст".Необходимо отфильтровать объекты, возраст которых находится
        // в диапазоне от 25 до 40 лет, отсортировать по имени и вывести результат.
        System.out.println("-".repeat(25) + " 24 " + "-".repeat(25));
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Jack",22));
        personList.add(new Person("Mike",33));
        personList.add(new Person("Ann",32));
        personList.add(new Person("Sem",56));
        personList.add(new Person("Judith",13));
        personList.add(new Person("Luck",28));
        System.out.println(personList.stream()
                .filter(el -> el.getAge() >= 25 && el.getAge() <= 40)
                .sorted()
                .toList());

        // Дан список чисел.Необходимо найти сумму всех четных чисел, которые являются положительными.
        System.out.println("-".repeat(25) + " 25 " + "-".repeat(25));
        System.out.println(integerList.stream()
                .filter(el -> el > 0)
                .filter(el -> el % 2 == 0)
                .reduce(Integer::sum)
                .get());

        // Дан список чисел.Необходимо найти второе минимальное число среди уникальных чисел.
        System.out.println("-".repeat(25) + " 26 " + "-".repeat(25));
        System.out.println(integerList.stream()
                .distinct()
                .sorted()
                .limit(2)
                .skip(1)
                .toList());

        // Дан список слов.Необходимо разделить их на две группы:одна группа -слова с длиной менее или равной 4
        // символам, другая группа - слова с длиной более 4 символов.После этого подсчитать количество слов в каждой группе
        // и вывести результат.
        System.out.println("-".repeat(25) + " 27 " + "-".repeat(25));
        List<String> stringList2 = listStr.stream()
                .filter(el -> el.length() <= 4)
                .toList();
        List<String> stringList3 = listStr.stream()
                .filter(el -> el.length() > 4)
                .toList();
        System.out.println(stringList2.size());
        System.out.println(stringList3.size());

        // Дан список строк.Необходимо пропустить первые три символа в каждой строке и объединить
        // оставшиеся символы в одну строку.
        System.out.println("-".repeat(25) + " 28 " + "-".repeat(25));
        System.out.println(listStr.stream()
                .map(el -> el.substring(3))
                .collect(joining()));

        // Дан список чисел.Необходимо найти три наименьших числа и вывести результат.
        System.out.println("-".repeat(25) + " 29 " + "-".repeat(25));
        System.out.println(numbers.stream()
                .distinct()
                .sorted()
                .limit(3)
                .toList());

        // Дан список строк.Необходимо проверить, содержит ли хотя бы одна строка подстроку "an" и вывести результат.
        System.out.println("-".repeat(25) + " 30 " + "-".repeat(25));
        System.out.println(listWithPre.stream()
                .filter(el -> el.contains("an"))
                .toList());
    }

    public static boolean isAnagram(List<String> list) {
        if (list.isEmpty()) {
            return false;
        }
        Map<Character, Integer> firstMap = stringToMap(list.get(0));
        return list.stream()
                .map(Main::stringToMap)
                .allMatch(el -> el.equals(firstMap));
    }

    public static Map<Character, Integer> stringToMap(String str) {
        return str.chars()
                .mapToObj(i -> (char) i)
                .map(Character::toLowerCase)
                .collect(toMap(elem -> elem, elem -> 1, Integer::sum));
    }


}