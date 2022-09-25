package com.myasser.amazon.service;

import com.myasser.amazon.model.Cart;
import com.myasser.amazon.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    User user;

    @Autowired
    UserService(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cart getCart() {
        return user.getCart();
    }

    public Cart putCart(Cart cart) {
        user.setCart(cart);
        return cart;
    }
}
