package org.example.HardCoreCocaineVersionOfCollectionTasks;

import java.util.*;

public class HardCoreCocaineVersionOfCollectionTasks {
    public static void main(String[] args) {
        Boolean[][] booleans = {{true,true,false},{false,true,false},{false,false,true}};
        Character[][] characters = {{'A', 'B', 'C'},{'D', 'E', 'F'},{'G', 'H', 'I'}};
        Map<Boolean[][], Character[][]> map1 = new HashMap<>();
        map1.put(booleans,characters);
        Integer[][] integers = {{1,2,3},{4,5,6},{7,8,9}};
        String[][] strings = {{"aaa", "bbb", "ccc"},{"ddd", "eee", "fff"},{"ggg", "hhh", "iii"}};
        Map<Integer[][], String[][]> map2 = new HashMap<>();
        map2.put(integers,strings);

        System.out.println("-".repeat(25) + " Task 1 " + "-".repeat(25));
        System.out.println(transformMapsOne(map1, map2));

        System.out.println("-".repeat(25) + " Task 2 " + "-".repeat(25));
        System.out.println(transformMapsTwo(map1,map2));
    }

    /**
     * Создать новую Map<Character, String>,
     * где ключом будет символ из Character[][],
     * а значением будет соответствующая строка из String[][].
     * Необходимо выполнить следующие шаги:
     * <p>
     * 1. Перебрать элементы первой мапы (Map<Boolean[][], Character[][]>).
     * 2. Для каждого элемента преобразовать Boolean[][] в Character[][], заменив значения true на символ 'T' и
     * false на символ 'F'.
     * 3. Перебрать элементы второй мапы (Map<Integer[][], String[][]>).
     * 4. Для каждого элемента преобразовать Integer[][] в String[][], преобразовав каждое число в строку.
     * 5. Объединить соответствующие элементы из шагов 2 и 4 в новой мапе (Map<Character, String>).
     * <p>
     * public static Map<Character, String> transformMaps(Map<Boolean[][], Character[][]> map1, Map<Integer[][],
     * String[][]> map2)
     */

    public static Map<Character, String> transformMapsOne(Map<Boolean[][], Character[][]> map1, Map<Integer[][],
            String[][]> map2) {
        Map<Character, String> result = new HashMap<>();

        if (map1.size() != map2.size()){

            return result;
        }

        List<Character> characters = transformBooleanArray(map1);
        List<String> strings = transformStringArray(map2);

        for (int i = 0; i < characters.size() ; i++) {
            result.put(characters.get(i), strings.get(i));
        }
        return result;
    }

    private static List<String> transformStringArray(Map<Integer[][], String[][]> map2) {
        List<Integer[]> list = new ArrayList<>();
        for (Map.Entry<Integer[][], String[][]> entry : map2.entrySet()) {
            list = Arrays.stream(entry.getKey()).toList();
        }

        List<String> stringList =new ArrayList<>();
        for (Integer[] arr : list) {
            for (Integer integer : arr) {
                stringList.add(integer.toString());
            }
        }
        System.out.println(stringList);
        return stringList;
    }

    private static List<Character> transformBooleanArray(Map<Boolean[][], Character[][]> map1) {
        Boolean[][] key = new Boolean[map1.size()][map1.size()];
        for (Map.Entry<Boolean[][], Character[][]> entry : map1.entrySet()) {
            key = entry.getKey();
        }
        List<Character> charKey = new ArrayList<>();
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[i].length; j++) {
                if (key[i][j]) {
                    charKey.add('T');
                } else {
                    charKey.add('F');
                }
            }
        }
        System.out.println(charKey);
        return charKey;
    }


    /**
     * Создать новую Map<String, Boolean>, где ключом будет строка из String[][], а значением будет
     * соответствующее значение из Boolean[][]. Необходимо выполнить следующие шаги:
     *
     * 1. Перебрать элементы первой мапы (Map<Boolean[][], Character[][]>).
     * 2. Для каждого элемента преобразовать Boolean[][] в Character[][],
     * заменив значения true на символ 'T' и false на символ 'F'.
     * 3. Перебрать элементы второй мапы (Map<Integer[][], String[][]>).
     * 4. Для каждого элемента преобразовать Integer[][] в String[][], преобразовав каждое число в строку.
     * 5. Объединить соответствующие элементы из шагов 2 и 4 в новой мапе (Map<String, Boolean>).
     *
     * public static Map<String, Boolean> transformMaps(Map<Boolean[][], Character[][]> map1, Map<Integer[][],
     * String[][]> map2)
     */
    public static Map<String, Boolean> transformMapsTwo(Map<Boolean[][], Character[][]> map1, Map<Integer[][],
     String[][]> map2){
        Map<String, Boolean> result = new HashMap<>();

        List<Boolean> value = findValue(map1);
        List<String> keys = transformStringArray(map2);
        for (int i = 0; i < keys.size(); i++) {
            result.put(keys.get(i), value.get(i));
        }
        return result;
    }

    private static List<Boolean> findValue(Map<Boolean[][], Character[][]> map1) {
        Boolean[][] value = new Boolean[map1.size()][map1.size()];
        for (Map.Entry<Boolean[][], Character[][]> entry : map1.entrySet()) {
            value = entry.getKey();
        }
        List<Boolean> booleanValue = new ArrayList<>();
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
               booleanValue.add(value[i][j]);
            }
        }
        System.out.println(booleanValue);
        return booleanValue;
    }


}
