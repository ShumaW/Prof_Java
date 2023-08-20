package org.example.controlers;

import org.example.entity.Product;
import org.example.service.MyParseJSON;
import org.example.service.ParsedFile;

import java.util.*;
import java.util.stream.Collectors;
/*
   - Написать методы которые находят:
*  ай ди всех компаний
*  самый дорогой СНЭК
*  какого товара больше всего на складе в деньгах
*  какого  ДРИНКС товара меньше всего на складе в деньгах
*  количество видов акционного товара у ФУД
*  сгруппировать по упакованным и нет
*  у какого ДРИНКС самая высокая маржа
*  средняя маржа по категории
*  первые три товара ФУД которые участвуют в акции и у которых самая низкая маржа
*  поместить в три мапу отсортировав в ай ди. #37 - это ай ди.
*  самый дешевый товар которого меньше всего на складе осталось в кг или штуках в зависимости от ISPACKED
    */

public class ProductController {
    public static final ParsedFile parsedFile = MyParseJSON.parse("src/main/resources/report.json");

    public List<Integer> getFactorysId() {
        return parsedFile.getParsedProducts().stream()
                .map(Product::getProductId)
                .toList();
    }

    public List<Product> getMostExpensiveSnack() {
        return parsedFile.getParsedProducts().stream()
                .filter(item -> item.getCategory().equals("SNACKS"))
                .sorted(ProductController::compareToMostExpensive)
                .limit(1).toList();
    }

    public List<Product> getMostInStockInMoney() {
        return parsedFile.getParsedProducts().stream()
                .sorted(ProductController::compareToMostExpensive)
                .limit(1)
                .toList();
    }

    public List<Product> getLeastInStockInMoney() {
        return parsedFile.getParsedProducts().stream()
                .filter(item -> item.getCategory().equals("DRINKS"))
                .sorted(ProductController::compareToCheapest)
                .limit(1)
                .toList();
    }

    public long getCountActionInCategoryFood(){
        return parsedFile.getParsedProducts().stream()
                .filter(item -> item.getCategory().equals("FOOD"))
                .filter(item -> item.getIsAdv().equals(true))
                .count();
    }

    public Map<Boolean, List<Product>> getPackagesAndNoPackagesProduct(){
        return parsedFile.getParsedProducts().stream()
                .collect(Collectors.groupingBy(Product::getIsPacked));
    }

    public List<Product> getHighestMarginInDrinks(){
        return parsedFile.getParsedProducts().stream()
                .filter(item -> item.getCategory().equals("DRINKS"))
                .sorted(ProductController::compareToHighestMargin)
                .limit(1)
                .toList();
    }

    public Map<String, Double> getAdvMarginInCategory(){
        return parsedFile.getParsedProducts().stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.averagingDouble(Product::getMargin)));
    }

    public List<Product> getThreeCheapestFoodIsAdv() {
        return parsedFile.getParsedProducts().stream()
                .filter(item -> item.getCategory().equals("FOOD") && item.getIsAdv())
                .sorted(Comparator.comparing(Product::getPrice))
                .limit(3)
                .toList();
    }

    public Map<Integer, Product> getTreeMapIdProduct() {
        return parsedFile.getParsedProducts().stream()
                .collect(Collectors.toMap(Product::getProductId, item -> item,
                        (oldValue, newValue) -> newValue, TreeMap::new));
    }

    public List<Product> getCheapestProductInStock(){
        return parsedFile.getParsedProducts().stream()
                .sorted(ProductController::compareToCheapest)
                .limit(1)
                .toList();
    }
    private static int compareToMostExpensive(Product o1, Product o2) {
        return  ((int)(o2.getQuantity() * o2.getPrice()) - (int)(o1.getQuantity() * o1.getPrice()));
    }

    private static int compareToCheapest(Product o1, Product o2) {
        return  ((int)(o1.getQuantity() * o1.getPrice()) - (int)(o2.getQuantity() * o2.getPrice()));
    }

    private static int compareToHighestMargin(Product o1, Product o2) {
        return  (int) (o2.getMargin() - o1.getMargin());
    }
}
