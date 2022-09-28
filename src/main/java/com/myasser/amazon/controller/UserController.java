package com.myasser.amazon.controller;

import com.myasser.amazon.model.Cart;
import com.myasser.amazon.model.User;
import com.myasser.amazon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = {"id"})
    public User getUser(@PathVariable("id") String id) {
        return userService.getUser(id);
    }

    @PutMapping(path = {"id"})
    public User putUser(@PathVariable("id") String id, @RequestBody User user) {
        return userService.putUser(id, user);
    }

    @PostMapping
    public User postUser(@RequestBody User user) {
        return userService.postUser(user);
    }

    @GetMapping(path = {"id/cart"})
    public Cart getCart(@PathVariable("id") String id) {
        return userService.getCart(id);
    }

}
