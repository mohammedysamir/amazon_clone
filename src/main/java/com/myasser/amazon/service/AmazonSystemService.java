package com.myasser.amazon.service;

import com.myasser.amazon.database.MongoSystemRepository;
import com.myasser.amazon.model.AmazonSystem;
import com.myasser.amazon.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AmazonSystemService {
    //todo: add db instance
    MongoSystemRepository systemRepository;

    @Autowired
    public AmazonSystemService(MongoSystemRepository systemRepository) {
        this.systemRepository = systemRepository;
    }

    public List<User> getUsers() {
        return systemRepository.findAll();
    }

    public Optional<User> getUserById(String id) {
        return systemRepository.getUserById(id);
    }

    public User putUser(String id, User user) {
        return systemRepository.save(user);
    }

    public User postUser(User user) {
        return systemRepository.insert(user);
    }

    public void deleteUser(String id) {
        //User user = systemRepository.deleteUserById(id);
        systemRepository.delete(getUserById(id).get());
        System.out.println("User deleted with id: " + id);
    }

    public void deleteAllUsers() {
        systemRepository.deleteAll();
    }
}
