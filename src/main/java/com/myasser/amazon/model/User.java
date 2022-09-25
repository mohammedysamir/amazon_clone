package com.myasser.amazon.model;

import java.util.UUID;

public class User {
    UUID userId;
    String name, email, password;
    Cart cart;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public User(UUID userId, String name, String email, String password, Cart cart) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cart = cart;
    }

    public User(UUID userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
