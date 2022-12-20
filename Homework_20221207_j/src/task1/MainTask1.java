package task1;

import java.util.*;

public class MainTask1 {
    /*
    First level: 1. Write a Java method to count the number of words in a string
    Example: "as soon as possible" should return "as: 2, soon: 1, possible: 1"

    public void getWordsWithCount(String sentence) {
    }
    */
    public static void main(String[] args) {
        String sentence = "as soon as possible";
        getWordsWithCount(sentence);
    }

    public static void getWordsWithCount(String sentence) {
        String[] words = sentence.split(" ");
        List<String> list = new ArrayList<>();

        for (String w : words) {
            list.add(w);
        }
        Collections.sort(list);
        System.out.println(list);

        Map<String, Integer> newMap = new LinkedHashMap<>();
        int counter = 1;
        for (int i = 0; i < list.size(); i++) {
            newMap.put(list.get(i), counter);
        }
        System.out.println(newMap);

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i) == list.get(j)) {
                    newMap.replace(list.get(i), counter, counter+=1);
                    list.remove(j);
                }
            }
        }
        newMap.forEach((k, v) -> System.out.print(k + ": " + v + " "));
    }
}


