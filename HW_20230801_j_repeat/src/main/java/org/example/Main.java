package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        System.out.println("-".repeat(25) + " Task 1 " + "-".repeat(25));
        System.out.println(findUniqueEmail());

        System.out.println("-".repeat(25) + " Task 2 " + "-".repeat(25));
        changeURLs();

        System.out.println("-".repeat(25) + " Task 3 " + "-".repeat(25));
        findProduct();
    }

    /*
    1. Вам дан текстовый файл, содержащий список email-адресов.
        Извлечь все уникальные домены электронной почты и подсчитать,
        сколько раз каждый домен встречается в списке.
        john.doe@example.com
        jane.smith@example.org
        james.bond@example.com
        jane.smith@example.org
        jane.smith@example.net
        vasya@gmail.com
     */
    public static Map<String, Integer> findUniqueEmail() {
        Map<String, Integer> map = new HashMap<>();
        String regex = "(\\w{2,}\\.\\w{2,}@\\w{2,}\\.\\w{2,})|(\\w{2,}@\\w{2,}\\.\\w{2,})";

        try (BufferedReader reader = new BufferedReader(new FileReader("emails.txt"))) {
            StringBuilder str = new StringBuilder();
            while (reader.ready()) {
                str.append(reader.readLine()).append("\n");
            }

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(str.toString());
            while (matcher.find()) {
                map.merge(matcher.group(), 1, Integer::sum);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /*
    2. Вам дан текстовый файл, содержащий список URL-адресов.
        Найти все URL, которые содержат протокол "https://" и заменить их на "http://"
        https://www.example.com
        http://www.example.org
        https://www.example.net
        https://www.example.com/about
     */
    public static void changeURLs() {
        try (BufferedReader reader = new BufferedReader(new FileReader("urls.txt"))) {
            StringBuilder strBuilder = new StringBuilder();
            while (reader.ready()) {
                strBuilder.append(reader.readLine()).append("\n");
            }
            String str = strBuilder.toString();
            str = str.replaceAll("https://", "http://");
            System.out.println(str);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
        3. Вам дан текстовый файл, содержащий список кодов продуктов в формате: <product_code>:<quantity>.
        Найти все продукты с количеством больше 10 и вывести их коды и количество.
        ABC123:5
        XYZ789:12
        DEF456:8
        JKL012:15
        MNO345:6
     */
    public static void findProduct() {
        try (BufferedReader reader = new BufferedReader(new FileReader("products.txt"))) {

            while (reader.ready()) {
                String[] split = reader.readLine().split(":");
                if (Integer.parseInt(split[1]) > 10) {
                    System.out.println(split[0] + ":" + Integer.parseInt(split[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}