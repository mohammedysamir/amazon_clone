package com.myasser.amazon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
public class User {
    @Id
    @Setter
    @Getter
    @JsonProperty("id")
    String userId;
    @Setter
    @Getter
    @JsonProperty("name")
    String name;
    @Setter
    @Getter
    @JsonProperty("email")
    String email;
    @Setter
    @Getter
    @JsonProperty("password")
    String password;
    @Setter
    @Getter
    @JsonProperty("cart")
    @DBRef
    Cart cart;

    public User(String name, String email, String password, Cart cart) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.cart = cart;
    }

    public User() {
    }
}