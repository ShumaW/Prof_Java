import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.CASE_INSENSITIVE_ORDER;


public class Main {
    public static void main(String[] args) {

        /*
        Описание занятия: распарсить файл input_business_card.txt
        создать класс типа Contact и сопутствующие классы при необходимости
        заполнить обьекты типа Contact данными из файла(
        Имя \ Фамилия
        Телефон
        Адрес
        Емэйл
        Вебсайт
        )
        вывести в консоль список контактов отсортированных по № телефона

        факультативно:

        используя интерфейс Serializable сохранить обьекты типа  Contact в файл

        реализовать считывание и выдачу в консоль сохраненых обьектов

         */

        List<Contact> listOfContacts = new ArrayList<>();
        try (
                BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("input_business_card.txt"));
        ) {
            String lines;

            while ((lines = bufferedReader.readLine()) != null) {
                if (lines.matches("")) {
                    String names= String.valueOf(Arrays.stream(lines.lines().filter(s -> s.matches("(FN:)(.+)$")).toArray())).substring(3);
                    String telephones = String.valueOf(Arrays.stream(lines.lines().filter(s -> s.matches(".+\\:\\+.+")).toArray())).substring(21);
                    String streets = String.valueOf(Arrays.stream(lines.lines().filter(s -> s.matches(".+\\:.+(STREET)\\:.+")).toArray())).substring(26);
                    String city = String.valueOf(Arrays.stream(lines.lines().filter(s -> s.matches(".+\\:.+(CITY)\\:.+")).toArray())).substring(24);
                    String country = String.valueOf(Arrays.stream(lines.lines().filter(s -> s.matches(".+\\:.+(COUNTRY)\\:.+")).toArray())).substring(27);
                    String email = String.valueOf(Arrays.stream(lines.lines().filter(s -> s.matches(".*\\w\\@.+")).toArray())).substring(25);
                    String site = String.valueOf(Arrays.stream(lines.lines().filter(s -> s.matches(".*(www.).*")).toArray())).substring(23);

                    listOfContacts.add(new Contact(names, telephones, new Address(streets, city, country), email, site));
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        listOfContacts.stream().forEach(System.out::println);

    }
}

