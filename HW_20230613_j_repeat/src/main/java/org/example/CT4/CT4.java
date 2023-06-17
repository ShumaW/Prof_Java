package org.example.CT4;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CT4 {

    public static void main(String[] args) {
        System.out.println("-".repeat(25) + " Задача 1 " + "-".repeat(25));
        Map<Integer,String> map = Map.of(1,"aaa",2,"bbb",3,"ccc",4,"ddd",5,"fff");
        printMap(map);
        System.out.println("-".repeat(25) + " Задача 2 " + "-".repeat(25));
        Set<Integer> set = Set.of(12,5,4,8,7,9,23,10);
        printSet(set);
        System.out.println("-".repeat(25) + " Задача 3 " + "-".repeat(25));
        List<Integer> list = List.of(1,2,3,6,5,4,7,8,9);
        printList(list);

    }
    /**
     * Задача 1: Перебрать и вывести все элементы Map<String, Integer> с использованием Iterator.
     */
    public static void printMap(Map<Integer,String> map){
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    /** Задача 2: Перебрать и вывести все элементы Set<String> с использованием Iterator.
     */
    public static void printSet(Set<Integer> set){
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /** Задача 3: Перебрать и вывести все элементы List<String> с использованием ListIterator в обратном порядке.
     */
    public static void printList(List<Integer> list){
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    
}
