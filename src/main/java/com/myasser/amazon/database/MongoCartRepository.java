package com.myasser.amazon.database;

import com.myasser.amazon.model.Cart;
import com.myasser.amazon.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MongoCartRepository extends MongoRepository<Cart, UUID> {
    @Query("{ 'id' : ?0 }")
    List<Product> getCartProduct(UUID cartId);

    @Query("{ 'id' : ?0 }")
    Cart putCart(UUID cartId, Cart cart);
}
