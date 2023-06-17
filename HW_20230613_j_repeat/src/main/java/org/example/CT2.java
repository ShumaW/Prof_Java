package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CT2 {
    public static void main(String[] args) {
        System.out.println("-".repeat(50));

        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 1);
        map.put("e", 2);
        map.put("f", 1);
        System.out.println(findKeys(map,2));
        System.out.println("-".repeat(50));
        Map<Integer, Boolean> map2 = Map.of(1, true, 2, true, 3, true, 4, true);
        System.out.println();
        System.out.println("-".repeat(50));
        String[] str = {"a","c","e"};
        System.out.println(calculateSum(map,str));
        System.out.println("-".repeat(50));
        Map<Integer, Boolean> map3 = Map.of(1, true, 2, false, 3, false, 4, true);
        System.out.println(findTrueKeys(map3));
    }

    /**
     * 1. Найти все ключи в Map<String, Integer>, соответствующие заданному значению, и вернуть их в виде списка.
     */
    public static List<String> findKeys(Map<String, Integer> inputMap, int targetValue) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> i : inputMap.entrySet()) {
            if (i.getValue().equals(targetValue)) {
                result.add(i.getKey());
            }
        }
        return result;
    }
    /**
     * 2. Проверить, содержит ли Map<String, Integer> хотя бы одну запись, у которой значение больше заданного порога.
     * public static boolean hasValueAboveThreshold(Map<String, Integer> inputMap, int threshold)
     */
    public static boolean hasValueAboveThreshold(Map<String, Integer> inputMap, int threshold) {
        for (Map.Entry <String, Integer> entry : inputMap.entrySet()) {
            if(entry.getValue() > threshold){
                return true;
            }
        }

        return false;
    }
    /** 3.Проверить, все ли значения в Map<Integer, Boolean> равны true.
     */
    public static boolean allValuesTrue(Map<Integer, Boolean> inputMap){
        for (Map.Entry <Integer, Boolean> entry : inputMap.entrySet()) {
            if(entry.getValue()){
                return true;
            }
        }
        return false;
    }
    /**
     * 4. Найти сумму всех значений(int) в Map<String, Integer>, которые соответствуют заданному ключевому набору.
     */
    public static int calculateSum(Map<String, Integer> inputMap, String[] keys){
        int sum = 0;
        for (Map.Entry<String, Integer> entry : inputMap.entrySet()) {
            for (String key : keys) {
                if (entry.getKey().equals(key)) {
                    sum += entry.getValue();
                }
            }
        }

        return sum;
    }
    /**
     * 5.Получить все ключи Map<Integer, Boolean>, у которых значение равно true, и вернуть их в виде списка.
     */
    public static List<Integer> findTrueKeys(Map<Integer, Boolean> inputMap){
        List<Integer> listResult = new ArrayList<>();

        for (Map.Entry <Integer, Boolean> entry : inputMap.entrySet()) {
            if(entry.getValue()){
                listResult.add(entry.getKey());
            }
        }

        return listResult;
    }

}
