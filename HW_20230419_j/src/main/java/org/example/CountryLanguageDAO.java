package org.example;

import java.util.List;
import java.util.Optional;

public interface CountryLanguageDAO<T> {

    List getAll();

    List<CountryLanguage> get(String countryCode);

    void save(T t);

    void delete(String language);
}
