package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        /*
        Один поток обращается к файлу и записывает в него данные,
        второй поток открывает файл и выводит его содержимое на консоль.
        Реализовать потокобезопасным образом.
         */

        String text = """
                Не говори мне о толпе безумной 
                Она иной раз вдохновение спугнёт
                Избавь меня от этой давки шумной
                Влекущей мощно в свой водоворот
                Нет тишины ищу я многодумный
                Лишь там поэту радость расцветёт
                Там только там божественною властью
                Любовь и дружба нас приводит к счастью""" ;

        addTextToFile(text);
        getTextForFile();

    }

    public synchronized static void addTextToFile(String str) {
        try (FileOutputStream file = new FileOutputStream("./src/homework.txt")){
                file.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public synchronized static void getTextForFile(){
        try (InputStream stream = new FileInputStream("./src/homework.txt")) {
            Reader reader1 = new InputStreamReader(stream);

            int data = reader1.read();

            while (data != -1) {
                System.out.print((char) data);
                data = reader1.read();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}