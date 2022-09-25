package com.myasser.amazon.controller;

import com.myasser.amazon.model.Cart;
import com.myasser.amazon.model.User;
import com.myasser.amazon.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = {"id"})
    public User getUser(@PathVariable("id") UUID id) {
        return userService.getUser(id);
    }

    @PutMapping
    public void putUser(User user) {
        userService.putUser(user);
    }

    @GetMapping(path = {"id/cart"})
    public Cart getCart(@PathVariable("id") UUID id) {
        return userService.getCart(id);
    }

    @PutMapping("id/cart")
    public Cart putCart(@PathVariable("id") UUID id, Cart cart) {
        return userService.putCart(id, cart);
    }
}
