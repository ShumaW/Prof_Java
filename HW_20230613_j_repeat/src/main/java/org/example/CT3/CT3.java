package org.example.CT3;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class CT3 {

    public static void main(String[] args) {
        System.out.println("-".repeat(25) + " Task 1 " + "-".repeat(25));
        Employee employee = new Employee();
        employee.addEmployee(1, "Jack");
        employee.addEmployee(2, "Jem");
        employee.addEmployee(3, "Nick");
        employee.addEmployee(4, "Ann");
        employee.addEmployee(5, "Sem");
        employee.addEmployee(6, "Mike");

        printEmployees(employee.getMapEmployee());

        System.out.println("-".repeat(25) + " Task 2 " + "-".repeat(25));

        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct("Pineapple");
        catalog.addProduct("Carrot");
        catalog.addProduct("Apple");
        catalog.addProduct("Watermelon");
        catalog.addProduct("Peach");
        catalog.addProduct("Potatoes");
        System.out.println(catalog);

        sortAndPrintCatalog(catalog);
    }

    /**
     * Создайте метод printEmployees(), который будет перебирать и выводить
     * информацию о сотрудниках, используя цикл for-each и обрабатывая данные внутри метода.
     */
    public static void printEmployees(Map<Integer, String> map) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    /**
     * Реализуйте метод sortAndPrintCatalog(), который будет перебирать и сортировать
     * информацию о продуктах в алфавитном порядке, используя цикл for-each и Comparable,
     * и выводить отсортированный каталог на экран.
     */
    public static void sortAndPrintCatalog(ProductCatalog productCatalog){
        Set<String> set = new TreeSet<>(productCatalog.getProduct());
        for (String str : set) {
            System.out.println(str);
        }
    }
}
