package org.example.service;

import org.example.entity.Factory;
import org.example.entity.Product;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyParseJSON {

    private static final String TEG_PRODUCT = "product";

    public static ParsedFile parse(String filePath) {
        ParsedFile parsedFile = new ParsedFile();
        JSONParser parser = new JSONParser();
        List<Product> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filePath)))) {
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray productJsonArray = (JSONArray) root.get(TEG_PRODUCT);

            for (Object item : productJsonArray) {
                Product product = getProduct((JSONObject) item);
                list.add(product);
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        parsedFile.setParsedProducts(list);
        return parsedFile;
    }

    private static Product getProduct(JSONObject item) {
        String category = (String) item.get("CATEGORY");
        String name = (String) item.get("NAME");
        String factory = (String) item.get("FACTORY");
        Long quantity = (Long) item.get("QUANTITY");
        Boolean isPacked = (Boolean) item.get("ISPACKED");
        Boolean isAdv = (Boolean) item.get("ISADV");
        Double price = (Double) item.get("PRICE");
        Double margin = (Double) item.get("MARGIN");
        Boolean isDept = (Boolean) item.get("ISDEBT");

        String[] arr = category.split("#");
        Integer productId = Integer.parseInt(arr[1]);

        category = category.replaceAll("[#\\d]", "");
        name = name.replaceAll("[#\\d]", "");
        factory = factory.replaceAll("[#\\d]", "");
        Factory resFactory = new Factory(factory);



        return new Product(productId, category, name, resFactory, quantity, isPacked, isAdv, price, margin, isDept);
    }
}
