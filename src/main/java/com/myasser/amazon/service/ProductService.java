package com.myasser.amazon.service;

import com.myasser.amazon.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    List<Product> products;

    //todo: add db instance and wire it

    public ProductService() {
        products = new ArrayList<>();
    }

    public Optional<Product> getProductById(UUID id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product postProduct(Product product) {
        products.add(product);
        return product;
    }

    public Product putProduct(UUID id, Product product) {
        int index = products.indexOf(getProductById(id).get());
        if (index >= 0) {
            products.set(index, product);
            return products.get(index);
        } else
            return postProduct(product);
    }

    public void deleteProduct(UUID id) {
        Product product = getProductById(id).get();
        if (product != null)
            products.remove(product);
        else
            System.out.println("Product with id " + id + " not found");
    }
}
//re-move implementation to database repo
