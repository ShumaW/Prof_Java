package org.example.controlers;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductControllerTest {
    ProductController productController = new ProductController("src/test/resources/report.json");

    @Test
    void getFactorysIdTest() {
        List<Integer> expected = List.of(1,2,3,4,5,6);
        assertEquals(expected, productController.getFactorysId() );
    }

    @Test
    void getMostExpensiveSnackTest() {
        Integer expectedId = 6;
        assertEquals(expectedId, productController.getMostExpensiveSnack().get(0).getProductId());
    }

    @Test
    void getMostInStockInMoneyTest() {
        Integer expectedId = 5;
        assertEquals(expectedId, productController.getMostInStockInMoney().get(0).getProductId());
    }

    @Test
    void getLeastDrinksInStockInMoneyTest() {
        String expectedProductName = "Mineral Water";
        assertEquals(expectedProductName, productController.getLeastDrinksInStockInMoney().get(0).getName());
    }

    @Test
    void getCountActionInCategoryFoodTest() {
        Long expected = 1L;
        assertEquals(expected, productController.getCountActionInCategoryFood());
    }

    @Test
    void getPackagesAndNoPackagesProductTest() {
        Integer expected = 3;
        assertEquals(expected,productController.getPackagesAndNoPackagesProduct().get(true).get(2).getProductId());
    }

    @Test
    void getHighestMarginInDrinksTest() {
        String expectedProductName = "Mineral Water";
        assertEquals(expectedProductName, productController.getHighestMarginInDrinks().get(0).getName());
    }

    @Test
    void getAdvMarginInCategoryTest() {
        Double expected = 19.0;
        assertEquals(expected, productController.getAdvMarginInCategory().get("DRINKS").doubleValue());
    }

    @Test
    void getThreeCheapestFoodIsAdvTest() {
        Integer expected = 1;
        assertEquals(expected, productController.getThreeCheapestFoodIsAdv().get(0).getProductId());
    }

    @Test
    void getTreeMapIdProductTest() {
        String expectedProductName = "Potato Chips";
        assertEquals(expectedProductName, productController.getTreeMapIdProduct().get(3).getName());
    }

    @Test
    void getCheapestProductInStockTest() {
        String expectedProductCategory = "FOOD";
        assertEquals(expectedProductCategory, productController.getCheapestProductInStock().get(0).getCategory());
    }
}