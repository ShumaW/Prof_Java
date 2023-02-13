import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

                if (line.matches("(FN:)(.+)$")) {
                    Pattern pname = Pattern.compile("(FN:)");
                    Matcher mname = pname.matcher(line);
                    mname.find();
                    name = line.substring(mname.end());

                }
                if (line.matches(".+\\:\\+.+")) {
                    Pattern ptel = Pattern.compile("(.+\\:\\+)");
                    Matcher mtel = ptel.matcher(line);
                    mtel.find();
                    telephone = line.substring(mtel.end());

                }
                if (line.matches(".+\\:.+(STREET:).+")) {
                    Pattern pst = Pattern.compile("(STREET:)");
                    Matcher mst = pst.matcher(line);
                    mst.find();
                    street = line.substring(mst.end());

                }
                if (line.matches(".+\\:.+(CITY)\\:.+")) {
                    Pattern pcity = Pattern.compile("((CITY)\\:)");
                    Matcher mcity = pcity.matcher(line);
                    mcity.find();
                    city = line.substring(mcity.end());

                }
                if (line.matches(".+\\:.+(COUNTRY)\\:.+")) {
                    Pattern pcountry = Pattern.compile("(COUNTRY:)");
                    Matcher mcountry = pcountry.matcher(line);
                    mcountry.find();
                    country = line.substring(mcountry.end());

                }
                if (line.matches("(EMAIL).*")) {
                    Pattern pmail = Pattern.compile(".*(INTERNET:)");
                    Matcher mcountry = pmail.matcher(line);
                    mcountry.find();
                    email = line.substring(mcountry.end());

                }
                if (line.matches("(WEB).*")) {
                    Pattern psite = Pattern.compile("(www.).*");
                    Matcher msite = psite.matcher(line);
                    msite.find();
                    site = line.substring(msite.start());

                }
                if (line.matches("(END:VCARD)")) {

                    contact = new Contact(name, telephone, street ,city, country, email, site);
                    listOfContacts.add(contact);
                    name = "";
                    telephone = "";
                    street = "";
                    city = "";
                    country = "";
                    email = "";
                    site = "";

                }
            }
            listOfContacts.stream().sorted((o1, o2) -> o1.getTelNumber().compareTo(o2.getTelNumber())).forEach(System.out::println);

            System.out.println("-".repeat(50));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("result.ser"))){
            objectOutputStream.writeObject(listOfContacts);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("result.ser"))){
            System.out.println(objectInputStream.readObject());
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

