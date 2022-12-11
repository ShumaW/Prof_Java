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

        Map<String, Integer> newMap = new HashMap<>();
        int counter = 1;
        for (int i = 0; i < list.size(); i++) {
            newMap.put(list.get(i), counter);
        }
        for (int i = 0; i < list.size() - 1; i++) {

            for (int j = i + 1; j < list.size(); j++) {

                if (list.get(i).equals(list.get(j))) {
                    newMap.replace(list.get(i),counter,++counter );
                }
            }
        }
        System.out.println(newMap);
    }


}


