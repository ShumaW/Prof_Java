package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MyClass {

    public static int[] generateIntArr(int lengthArray) {
        Random random = new Random();
        int[] arr = new int[lengthArray];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(13) + 7;
        }
        return arr;
    }

    public static void writeFile(int[] arr) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("intArray.txt"))) {
            for (int j : arr) {
                writer.write(j + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> readFileAndWriteIntegerList() {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("intArray.txt"))) {
            String i;
            List<String> str = new ArrayList<>();
            while ((i = reader.readLine()) != null) {
                str.addAll(Arrays.stream(i.split("\n")).toList());
            }
            list = str.stream()
                    .map(Integer::parseInt)
                    .toList();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<String> getListString(){
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Text.txt"))) {
            String i;
            while ((i = reader.readLine()) != null) {
                list.addAll(Arrays.stream(i.split("  "))
                        .filter(el -> el.matches("[a-zA-Z]+"))
                        .toList());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<String> getLineOfString(){
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Text.txt"))) {
            String i;
            while ((i = reader.readLine()) != null) {
                list.addAll(Arrays.stream(i.split("\n"))
                        .toList());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
