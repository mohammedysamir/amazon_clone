package com.myasser.amazon.database;

import com.myasser.amazon.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface MongoSystemRepository extends MongoRepository<User, String> {
    @Query("{ 'name' : ?0 }")
    Optional<User> getUserByName(String name);

    @Query("{ 'id' : ?0 }")
    Optional<User> getUserById(String id);

    @Query("{ 'id' : ?0 }")
    User updateUserById(String id, User user);
}
