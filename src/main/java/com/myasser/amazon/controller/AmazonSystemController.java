package com.myasser.amazon.controller;

import com.myasser.amazon.model.Product;
import com.myasser.amazon.model.User;
import com.myasser.amazon.service.AmazonSystemService;
import com.myasser.amazon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/system")
public class AmazonSystemController {
    AmazonSystemService amazonSystemService;

    public AmazonSystemController() {
    }

    @Autowired
    AmazonSystemController(AmazonSystemService amazonSystemService) {
        this.amazonSystemService = amazonSystemService;
    }

    @GetMapping(path = "{id}")
    public User getUserById(@PathVariable("id") String id) {
        return amazonSystemService.getUserById(id).orElse(null);
    }

    @GetMapping
    public List<User> getUsers() {
        return amazonSystemService.getUsers();
    }

    @GetMapping(path = "all")
    public List<Product> getAllProducts() {
        return amazonSystemService.getProducts();
    }

    @GetMapping(path = "category/{category}")
    public List<Product> getProductsByCategory(@PathVariable("category") String category) {
        return amazonSystemService.getProductsByCategory(category);
    }

    @GetMapping(path ="product/{id}")
    public Product getProductById(@PathVariable("id") String id) {
        return amazonSystemService.getProductById(id);
    }

    @PostMapping(consumes = {"application/json"})
    public User postUser(@RequestBody User user) {
        user.setUserId(UUID.randomUUID().toString());
        //to initiate user's cart
        if (user.getCart() == null) {
            UserService userService = new UserService();
            user.setCart(userService.initiateUserCart(user.getUserId()));
        }
        return amazonSystemService.postUser(user);
    }

    @PostMapping(path = "/product", consumes = {"application/json"})
    public Product postProduct(@RequestBody Product product) {
        return amazonSystemService.postProduct(product);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable String id) {
        amazonSystemService.deleteUser(id);
    }

    @DeleteMapping
    public void deleteAllUsers() {
        amazonSystemService.deleteAllUsers();
    }

    @DeleteMapping(path = "/product/{id}")
    public void deleteProduct(@PathVariable String id) {
        amazonSystemService.deleteProduct(id);
    }

    @DeleteMapping(path = "/products")
    public void deleteAllProducts() {
        amazonSystemService.deleteAllProducts();
    }

    @PutMapping(path = "{id}")
    public User putUser(@PathVariable String id, @RequestBody User user) {
        return amazonSystemService.putUser(id, user);
    }
    /*
     * Get:
     *   all users: /
     *   user by id: /{id}
     *   all products: /all
     *   products by category: /category/{category}
     *  product by id: /product/{id}
     * Post:
     *   user: /
     *   product: /product
     *
     * Delete:
     *  user: /{id}
     *  all users: /
     *  product: /product/{id}
     *  all products: /products
     *
     * Put:
     *  user: /{id}
     * */
}
