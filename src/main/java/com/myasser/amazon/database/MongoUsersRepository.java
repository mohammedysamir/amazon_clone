package com.myasser.amazon.database;

import com.myasser.amazon.model.Cart;
import com.myasser.amazon.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface MongoUsersRepository extends MongoRepository<User, String> {
    @Query(value = "{ 'id' : ?0 }", fields = "{ 'cart' : 1}")
    Cart getUserCart(String userId);

    @Query("{'id' : ?0}")
    Optional<User> getUserById(String id);
}
