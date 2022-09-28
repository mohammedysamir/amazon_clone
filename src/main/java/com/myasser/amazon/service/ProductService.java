package com.myasser.amazon.service;

import com.myasser.amazon.database.MongoProductsRepository;
import com.myasser.amazon.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    MongoProductsRepository productsRepository;
    List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
    }

    @Autowired
    public ProductService(MongoProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
        products = productsRepository.findAll();
    }

    public Product getProductById(String id) {
        return productsRepository.getProductById(id).orElse(null);
    }

    public List<Product> getAllProducts() {
        return productsRepository.findAll();
    }

    public Product postProduct(Product product) {
        productsRepository.insert(product);
        return product;
    }

    public Product putProduct(String id, Product product) {
        int index = products.indexOf(getProductById(id));
        if (index >= 0) {
            products.set(index, product);
            productsRepository.save(product);
            return products.get(index);
        } else
            return postProduct(product);
    }

    public void deleteProduct(String id) {
        Product product = getProductById(id);
        if (product != null) {
            products.remove(product);
            productsRepository.delete(product);
        } else
            System.out.println("Product with id " + id + " not found");
    }

    public List<Product> getProductsByCategory(String category) {
        return productsRepository.getProductByCategory(category).orElse(new ArrayList<Product>());
    }
}