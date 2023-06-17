package org.example;

import java.util.*;

public class CT1 {
    public static void main(String[] args) {
        System.out.println("-".repeat(50));
        List<String> base = new ArrayList<>();
        base.add("Hello");
        base.add("World");
        base.add("World");
        base.add("Hello");
        System.out.println(findDup(base));
        System.out.println("-".repeat(50));
        System.out.println(findString(base, "Hello"));
        System.out.println("-".repeat(50));
        Set<Integer> set = Set.of(12,25,26,89,101);
        System.out.println(sumEvenElem(set));


    }
    //Найти все дубликаты в List<String> и вернуть их в виде нового списка.
    public static List<String> findDup(List<String> list) {
        List<String> result = new ArrayList<>();  // "str", "aba", "abc","str"

        for (int i = 0; i < list.size(); i++) {
            for (int j = 1 + i; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))){
                    result.add(list.get(i));
                }
            }
        }
        return result;
    }


    //Проверить, содержит ли List<String> заданную строку
    // и вернуть ее индекс. Если строка не найдена, вернуть -1.
    public static int findString(List<String> list, String s) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(s)) {
                return i;
            }
        }
        return -1;
    }

    //Найти сумму всех элементов в Set<Integer>, которые являются четными числами.
    public static Integer sumEvenElem(Set<Integer> set){
        Integer result = 0;
        for (Integer x : set) {
            if (x%2 == 0){
                result+= x;
            }
        }
        return result;
    }



    //Проверить, содержит ли List<String> хотя бы
    // одну строку, которая начинается с заданного префикса.
    public static boolean findSubString(List<String> list, String prefix) {
        for (String el : list) {
            if (el.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }


    //Получить все возможные комбинации из List<String> и Set<Integer>,
    //где каждая комбинация представляет собой строку и число, объединенные вместе.
    public static List<String> mergeListAndSet(List<String> list, Set<Integer> set) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (Integer x : set) {
                result.add(list.get(i) + x);
            }
        }
        return result;
    }
}
