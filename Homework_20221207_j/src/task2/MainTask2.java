package task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainTask2 {
    /*
    Write a Java method to check if two strings are anagrams of each other or not

    public boolean checkStringsAnagram(String str1, String str2) {
    }
    */
    public static void main(String[] args) {
        String str1 = "abba";
        String str2 = "baba";

        System.out.println(checkStringsAnagram(str1, str2));

    }
    public static boolean checkStringsAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        List<Character> arrLetters1 = new ArrayList<>();
        List<Character> arrLetters2 = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            arrLetters1.add(str1.charAt(i));
            arrLetters2.add(str2.charAt(i));
        }
        Collections.sort(arrLetters1);
        Collections.sort(arrLetters2);
        for (int i = 0; i < arrLetters1.size() || i < arrLetters2.size(); i++) {
            if (arrLetters1.get(i) != arrLetters2.get(i)) {
                return false;
            }
        }
        return true;
    }
}
