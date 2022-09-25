package com.myasser.amazon.model;

import java.util.ArrayList;
import java.util.List;

public class AmazonSystem {
    List<User> users;

    public AmazonSystem(List<User> users) {
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
