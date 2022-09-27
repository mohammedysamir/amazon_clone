package com.myasser.amazon.service;

import com.myasser.amazon.database.MongoUsersRepository;
import com.myasser.amazon.model.Cart;
import com.myasser.amazon.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
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

    public void putUser(User user) {
        usersRepository.putUser(user);
    }

    public Cart getCart(UUID id) {
        return usersRepository.getUserCart(id);
    }

    public Cart putCart(UUID id, Cart cart) {
        return usersRepository.putUserCart(id, cart);
    }
}
