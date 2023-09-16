package org.example;

public class ProductServiceImpl implements ProductService {

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProduct(Product product) {

    }

    @Override
    public double calculatePrice(Product product) {
        return 0;
    }
}

interface ProductService{
    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Product product);

    double calculatePrice(Product product);

}
