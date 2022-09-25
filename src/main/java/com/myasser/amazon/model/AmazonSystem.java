package com.myasser.amazon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("system")
public class AmazonSystem {
    List<User> users;

    public AmazonSystem(@JsonProperty("user-list") List<User> users) {
        this.users = users;
    }

    public AmazonSystem() {
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}