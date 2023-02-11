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
            String line;
            Contact contact = null;
            String name = "";
            String telephone = "";
            String street = "";
            String city = "";
            String country = "";
            String email = "";
            String site = "";

            while ((line = bufferedReader.readLine()) != null) {
                if (line.matches("BEGIN:VCARD")) {

                    contact = new Contact(name, telephone, street ,city, country, email, site);
                    listOfContacts.add(contact);
                }
                if (line.matches("(FN:)(.+)$")) {
                    name = line.substring(3);
                    contact.setNameAndLastName(name);
                }
                if (line.matches(".+\\:\\+.+")) {
                    telephone = line.substring(21);
                    contact.setTelNumber(telephone);
                }
                if (line.matches(".+\\:.+(STREET)\\:.+")) {
                    street = line.substring(26);
                    contact.setStreetAndNum(street);
                }
                if (line.matches(".+\\:.+(CITY)\\:.+")) {
                    city = line.substring(24);
                    contact.setCity(city);
                }
                if (line.matches(".+\\:.+(COUNTRY)\\:.+")) {
                    country = line.substring(27);
                    contact.setCountry(country);
                }
                if (line.matches(".*\\w\\@.+")) {
                    email = line.substring(25);
                    contact.setEmail(email);
                }
                if (line.matches(".*(www.).*")) {
                    site = line.substring(23);
                    contact.setWebSite(site);
                }
            }
            listOfContacts.stream().sorted((o1, o2) -> o1.getTelNumber().compareTo(o2.getTelNumber())).forEach(System.out::println);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

