package com.myasser.amazon.controller;

import com.myasser.amazon.model.Cart;
import com.myasser.amazon.model.User;
import com.myasser.amazon.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public User getUser() {
        return userService.getUser();
    }

    @PutMapping
    public void putUser(User user) {
        userService.setUser(user);
    }

    @GetMapping("/cart")
    public Cart getCart() {
        return userService.getCart();
    }

    @PutMapping("/cart")
    public Cart putCart(Cart cart) {
        return userService.putCart(cart);
    }
}
