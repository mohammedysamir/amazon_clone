package com.myasser.amazon.controller;

import com.myasser.amazon.model.Cart;
import com.myasser.amazon.model.User;
import com.myasser.amazon.service.AmazonSystemService;
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

    @PostMapping(consumes = {"application/json"})
    public User postUser(@RequestBody User user) {
        user.setUserId(UUID.randomUUID().toString());
        return amazonSystemService.postUser(user);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable String id) {
        amazonSystemService.deleteUser(id);
    }

    @DeleteMapping
    public void deleteAllUsers() {
        amazonSystemService.deleteAllUsers();
    }

    @PutMapping(path = "{id}")
    public User putUser(@PathVariable String id, @RequestBody User user) {
        return amazonSystemService.putUser(id, user);
    }
}
