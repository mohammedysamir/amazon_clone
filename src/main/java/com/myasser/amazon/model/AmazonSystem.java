package com.myasser.amazon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

@Document("system")
public class AmazonSystem {
    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    @Id
    @JsonProperty("systemId")
    @NonNull
    @Setter
    @Getter
    String systemId;
    @Setter
    @Getter
    @JsonProperty("users")
    List<User> users;

    public AmazonSystem(List<User> users) {
        this.users = users;
    }

    public AmazonSystem() {
        this.users = new ArrayList<>();
    }
//
//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }
}