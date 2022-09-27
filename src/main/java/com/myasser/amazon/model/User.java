package com.myasser.amazon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document("users")
public class User {
    @Id
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

    public User(@JsonProperty("name") String name, @JsonProperty("email") String email, @JsonProperty("password") String password,@JsonProperty("cart") Cart cart) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.cart = cart;
    }

    public User(@JsonProperty("name") String name) {
        this.name = name;
    }

    public User(@JsonProperty("name") String name, @JsonProperty("email") String email, @JsonProperty("password") String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}