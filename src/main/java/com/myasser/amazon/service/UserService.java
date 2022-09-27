package com.myasser.amazon.service;

import com.myasser.amazon.database.MongoUsersRepository;
import com.myasser.amazon.model.Cart;
import com.myasser.amazon.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Configuration
public class UserService {
    MongoUsersRepository usersRepository;


    public UserService() {
    }

    @Autowired
    UserService(MongoUsersRepository userRepo) {
        this.usersRepository = userRepo;
    }

    public User getUser(UUID id) {
        return usersRepository.findById(id).orElse(null);
    }

    public User postUser(User user){
        return usersRepository.insert(user);
    }

    public void putUser(User user) {
        usersRepository.save(user);
    }

    public Cart getCart(UUID id) {
        return usersRepository.getUserCart(id);
    }
}
