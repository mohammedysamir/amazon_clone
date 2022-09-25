package com.myasser.amazon.service;

import com.myasser.amazon.model.AmazonSystem;
import com.myasser.amazon.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AmazonSystemService {
    //todo: add db instance
    AmazonSystem system;

    @Autowired
    public AmazonSystemService(AmazonSystem system) {
        this.system = system;
    }

    public AmazonSystem getSystem() {
        return system;
    }

    public List<User> getUsers() {
        return system.getUsers();
    }

    public Optional<User> getUserById(UUID id) {
        return system.getUsers().stream().findFirst();
    }

    public User putUser(UUID id, User user) {
        int index = system.getUsers().indexOf(getUserById(id).get());
        system.getUsers().set(index, user);
        return user;
    }

    public User postUser(User user) {
        system.getUsers().add(user);
        return user;
    }

    public void deleteUser(UUID id) {
        int index = system.getUsers().indexOf(getUserById(id).get());
        if (index >= 0)
            system.getUsers().remove(index);
        else
            System.out.println("User with id " + id + " not found");
    }
}
