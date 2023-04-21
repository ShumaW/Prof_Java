package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LanguageDAO implements CountryLanguageDAO<CountryLanguage> {
    private static final String GET_ALL = "SELECT * FROM countrylanguage";
    private static final String GET_BY_CODE = "SELECT * FROM countrylanguage WHERE CountryCode = ?";
    private static final String GET_BY_CODE_MINPER = "SELECT * FROM countrylanguage WHERE CountryCode = ? AND Percentage >= ?";
    private static final String SAVE_LANGUAGE = "INSERT INTO countrylanguage VALUES (?,?,?,?)";
    private static final String DELETE_LANGUAGE = "DELETE FROM countrylanguage where Language = ?";

    @Override
    public List<CountryLanguage> getAll() {
        List<CountryLanguage> cities = new ArrayList<>();
        try (
                Connection connection = ConnectorDB.getConnection();
                Statement statement = connection.createStatement();
        ) {

            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while (resultSet.next()) {
                CountryLanguage city = getLanguage(resultSet);
                cities.add(city);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    private static CountryLanguage getLanguage(ResultSet resultSet) throws SQLException {
        CountryLanguage city = new CountryLanguage(resultSet.getString(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getDouble(4));
        return city;
    }

    @Override
    public List<CountryLanguage> get(String countryCode) {
        List<CountryLanguage> resultList = new ArrayList<>();
        try (
                Connection connection = ConnectorDB.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_CODE);
        ){
            preparedStatement.setString(1, countryCode);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                CountryLanguage language = getLanguage(resultSet);
                resultList.add(language);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }
//
    public List<CountryLanguage> getLanguageByCodeAndPercent(String countryCode, double min) {
        List<CountryLanguage> languageList = new ArrayList<>();
        try (
                Connection connection = ConnectorDB.getConnection();
                PreparedStatement statement = connection.prepareStatement(GET_BY_CODE_MINPER);
        ){
            statement.setString(1, countryCode);
            statement.setDouble(2, min);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                CountryLanguage language = getLanguage(resultSet);
                languageList.add(language);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return languageList;
    }

    @Override
    public void save(CountryLanguage language) {
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(SAVE_LANGUAGE);
        ){
            statement.setString(1, language.getCountryCode());
            statement.setString(2, language.getLanguage());
            statement.setString(3, language.getIsOfficial());
            statement.setDouble(4, language.getPercentage());
            int result = statement.executeUpdate();
            System.out.println("Result: " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(String language) {
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_LANGUAGE);
        ){
            statement.setString(1, language);
            int result = statement.executeUpdate();
            System.out.println("Result: " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
