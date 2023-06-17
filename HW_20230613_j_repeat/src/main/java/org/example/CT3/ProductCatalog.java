package org.example.CT3;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * 2:
 * Создайте класс ProductCatalog, содержащий информацию о продуктах в виде Set<String>.
 * */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCatalog implements Comparable<ProductCatalog>
{

    private String title;

    private Set<String> product = new HashSet<>();

    public void addProduct(String title){
        product.add(title);
    }


    @Override
    public int compareTo(ProductCatalog o) {
        return this.title.compareTo(o.title);
    }

    @Override
    public String toString() {
        return product.toString();
    }
}


