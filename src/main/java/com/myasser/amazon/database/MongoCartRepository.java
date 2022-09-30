package com.myasser.amazon.database;

import com.myasser.amazon.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface MongoCartRepository extends MongoRepository<Cart, String> {
    @Query(value = "{ 'userId' : ?0 }")
    Optional<Cart> findCartByUserId(String userId);
}
