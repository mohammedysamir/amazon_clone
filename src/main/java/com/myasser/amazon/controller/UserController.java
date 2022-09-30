package com.myasser.amazon.controller;

import com.myasser.amazon.model.Cart;
import com.myasser.amazon.model.Product;
import com.myasser.amazon.model.User;
import com.myasser.amazon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    public UserController() {
    }

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    //Get methods
    @GetMapping(path = {"{id}"})
    public User getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @GetMapping(path = {"{id}/cart"})
    public Cart getCart(@PathVariable String id) {
        return userService.getCart(id);
    }

    @GetMapping(path = {"{id}/cart/total"})
    public double getCartTotal(@PathVariable String id) {
        return userService.calculateCartTotal(id);
    }

    @GetMapping(path = {"{id}/cart/products"})
    public List<Product> getCartProducts(@PathVariable String id) {
        return userService.getCartProducts(id);
    }

    @GetMapping(path = {"{id}/cart/products/{productId}"})
    public Product getCartProduct(@PathVariable String id, @PathVariable String productId) {
        return userService.getCartProduct(id, productId);
    }

    //Put methods
    @PutMapping(path = {"{id}"})
    public User putUser(@PathVariable String id, @RequestBody User user) {
        return userService.putUser(id, user);
    }

    //Post methods
    @PostMapping(path = {"{id}/cart"})
    public Cart postProductToCart(@PathVariable String id, @RequestBody Product product) {
        return userService.addProductToCart(id, product);
    }

    //Delete
    @DeleteMapping(path = {"{id}/cart/{productId}"})
    public Cart deleteProductFromCart(@PathVariable String id, @PathVariable String productId) {
        return userService.deleteProductFromCart(id, productId);
    }
}
/*
 * get:
 *   1. user -> /id
 *   2. cart -> /id/cart
 *   3. cart products -> /id/cart/products
 *   4. cart product -> /id/cart/products/{productId}
 *   5. cart total -> /id/cart/total
 * post:
 *   1. product to cart -> /id/cart -> Product()
 * delete:
 *   1. product from cart -> /id/cart/{productId}
 * put:
 *   1. user -> /id -> User()
 * */