package org.example;

import java.util.List;

public class LanguageApp {
    /**
     * В базе данных MYSQL world (дамп базы данных находится в папке resourses репозитория
     * javaProfClasses2022) есть таблица countrylanguage.
     * Создать класс CountryLanguage и CountryLanguageDAO, имплементировав в нем все методы WorldDAO:
     *     List getAll();
     *     Optional get(int id);
     *     void save(T t);
     *     void delete(int id);
     */
    public static void main(String[] args) {

        LanguageDAO languageDAO = new LanguageDAO();

        System.out.println("-".repeat(25) + " Get all records in a table " + "-".repeat(25));

        List<CountryLanguage> languageList = languageDAO.getAll();
        languageList.forEach(System.out::println);

        System.out.println("-".repeat(25) + " Get by countryCode " + "-".repeat(25));

        String countryCode = "USA";
        List<CountryLanguage> countryLanguages = languageDAO.get(countryCode);
        countryLanguages.forEach(System.out::println);

        System.out.println("-".repeat(25) + " Get by countryCode and percent " + "-".repeat(25));

        languageDAO.getLanguageByCodeAndPercent("USA",7.0).forEach(System.out::println);

//        System.out.println("-".repeat(25) + " Save language " + "-".repeat(25));
//
//        languageDAO.save(new CountryLanguage("USA","Maory","F",0.0));

//        System.out.println("-".repeat(25) + " Delete language " + "-".repeat(25));
//
//        languageDAO.delete("Maory");
//
//        languageDAO.getLanguageByCodeAndPercent("USA",0.0).forEach(System.out::println);


    }
}