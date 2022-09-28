package com.myasser.amazon.database;

import com.myasser.amazon.model.Cart;
import com.myasser.amazon.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MongoCartRepository extends MongoRepository<Cart, String> {
    @Query(value = "{ 'id' : ?0 }", fields = "{ 'products' : 1 }")
    List<Product> getCartProduct(String cartId);
}
