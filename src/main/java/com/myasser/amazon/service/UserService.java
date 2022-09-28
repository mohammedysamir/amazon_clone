package com.myasser.amazon.service;

import com.myasser.amazon.database.MongoUsersRepository;
import com.myasser.amazon.model.Cart;
import com.myasser.amazon.model.Product;
import com.myasser.amazon.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Configuration
public class UserService {
    MongoUsersRepository usersRepository;

    List<User> users;

    public UserService() {
        users = new ArrayList<User>();
    }

    @Autowired
    UserService(MongoUsersRepository userRepo) {
        this.usersRepository = userRepo;
        users = usersRepository.findAll();
    }

    //todo: maybe fail because of UUID
    public User getUser(String id) {
        return usersRepository.getUserById(id).orElse(null);
    }

    public User postUser(User user) {
        usersRepository.insert(user);
        return user;
    }

    //todo: need to be removed and just called from system
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    public User putUser(String id, User user) {
        int index = usersRepository.findAll().indexOf(getUser(id));
        if (index >= 0) {
            users.set(index, user);
            usersRepository.save(user);
            return users.get(index);
        } else
            return postUser(user);
    }

    public Cart getCart(String id) {
        return usersRepository.getUserCart(id);
    }

    public Cart initiateUserCart(String userId) {
        Cart cart = new Cart();
        cart.setCartId(UUID.randomUUID().toString());
        cart.setUserId(userId);
        cart.setCartProduct(new ArrayList<>());
        return cart;
    }
}
