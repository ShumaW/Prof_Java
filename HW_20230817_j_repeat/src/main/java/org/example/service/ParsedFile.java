package org.example.service;

import lombok.Getter;
import org.example.entity.Product;

import java.util.List;
import java.util.Objects;

@Getter
public class ParsedFile {

    private List<Product> parsedProducts;

    public ParsedFile() {
    }

    public void setParsedProducts(List<Product> parsedProducts) {
        this.parsedProducts = parsedProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParsedFile parsedFile = (ParsedFile) o;
        return Objects.equals(parsedProducts, parsedFile.parsedProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parsedProducts);
    }

    @Override
    public String toString() {
        return parsedProducts.toString();
    }
}
