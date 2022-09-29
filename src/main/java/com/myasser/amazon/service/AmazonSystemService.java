package com.myasser.amazon.service;

import com.myasser.amazon.database.MongoProductsRepository;
import com.myasser.amazon.database.MongoSystemRepository;
import com.myasser.amazon.model.AmazonSystem;
import com.myasser.amazon.model.Product;
import com.myasser.amazon.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AmazonSystemService {
    MongoSystemRepository systemRepository;

    @Autowired
    public AmazonSystemService(MongoSystemRepository systemRepository) {
        this.systemRepository = systemRepository;
    }

    public List<User> getUsers() {
        return systemRepository.findAll();
    }

    public Optional<User> getUserById(String id) {
        return systemRepository.findById(id);
    }

    public User putUser(String id, User user) {
        return systemRepository.save(user);
    }

    public User postUser(User user) {
        return systemRepository.insert(user);
    }

    public void deleteUser(String id) {
        User user = null;
        user = getUserById(id).isPresent() ? getUserById(id).get() : null;
        if (user != null) {
            systemRepository.delete(user);
            System.out.println("User deleted with id: " + id);
            return;
        }
        System.out.println("User not found");
    }

    public void deleteAllUsers() {
        systemRepository.deleteAll();
    }

    public List<Product> getProducts() {
        return productService().getAllProducts();
    }

    public List<Product> getProductsByCategory(String category) {
        return productService().getProductsByCategory(category);
    }

    public Product postProduct(Product product) {
        return productService().postProduct(product);
    }

    private ProductService productService() {
        return new ProductService();
    }
}
