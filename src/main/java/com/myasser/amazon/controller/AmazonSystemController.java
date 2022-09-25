package com.myasser.amazon.controller;

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

    @Autowired
    AmazonSystemController(AmazonSystemService amazonSystemService) {
        this.amazonSystemService = amazonSystemService;
    }

    @GetMapping(path = "{id}")
    public User getUserById(@PathVariable UUID id) {
        return amazonSystemService.getUserById(id).orElse(null);
    }

    @GetMapping
    public List<User> getUsers() {
        return amazonSystemService.getUsers();
    }

    @PostMapping
    public User postUser(@RequestBody User user) {
        user.setUserId(UUID.randomUUID());
        return amazonSystemService.postUser(user);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable UUID id) {
        amazonSystemService.deleteUser(id);
    }

    @PutMapping(path = "{id}")
    public User putUser(@PathVariable UUID id, @RequestBody User user) {
        return amazonSystemService.putUser(id, user);
    }
}
