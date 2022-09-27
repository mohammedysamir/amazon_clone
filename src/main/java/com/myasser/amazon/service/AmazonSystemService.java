package com.myasser.amazon.service;

import com.myasser.amazon.database.MongoSystemRepository;
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
    MongoSystemRepository systemRepository;

    @Autowired
    public AmazonSystemService(MongoSystemRepository systemRepository) {
        this.systemRepository = systemRepository;
    }

    public List<User> getUsers() {
        return systemRepository.findAll();
    }

    public Optional<User> getUserById(UUID id) {
        return systemRepository.getUserById(id.toString());
    }

    public User putUser(UUID id, User user) {
        return systemRepository.updateUserById(id.toString(), user);
    }

    public User postUser(User user) {
        return systemRepository.save(user);
    }

    public void deleteUser(UUID id) {
        User user = systemRepository.deleteUserById(id.toString());
        System.out.println("User deleted with id: " + user.getUserId());
    }
}
