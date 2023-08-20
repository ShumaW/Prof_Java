package org.example;

import org.example.controlers.ProductController;

public class Main {
    public static void main(String[] args) {

        ProductController controller = new ProductController();
        System.out.println("-".repeat(25) + " 1 " + "-".repeat(25));
        System.out.println(controller.getFactorysId());
        System.out.println("-".repeat(25) + " 2 " + "-".repeat(25));

        System.out.println(controller.getMostExpensiveSnack());
        System.out.println("-".repeat(25) + " 3 " + "-".repeat(25));

        System.out.println(controller.getMostInStockInMoney());
        System.out.println("-".repeat(25) + " 4 " + "-".repeat(25));

        System.out.println(controller.getLeastInStockInMoney());
        System.out.println("-".repeat(25) + " 5 " + "-".repeat(25));

        System.out.println(controller.getCountActionInCategoryFood());
        System.out.println("-".repeat(25) + " 6 " + "-".repeat(25));

        System.out.println(controller.getPackagesAndNoPackagesProduct());
        System.out.println("-".repeat(25) + " 7 " + "-".repeat(25));

        System.out.println(controller.getHighestMarginInDrinks());
        System.out.println("-".repeat(25) + " 8 " + "-".repeat(25));

        System.out.println(controller.getAdvMarginInCategory());
        System.out.println("-".repeat(25) + " 9 " + "-".repeat(25));

        System.out.println(controller.getThreeCheapestFoodIsAdv());
        System.out.println("-".repeat(25) + " 10 " + "-".repeat(25));

        System.out.println(controller.getTreeMapIdProduct());
        System.out.println("-".repeat(25) + " 11 " + "-".repeat(25));

        System.out.println(controller.getCheapestProductInStock());

    }
}