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
        return usersRepository.findById(id).orElse(null);
    }

    public User postUser(User user) {
        return usersRepository.insert(user);
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
}
