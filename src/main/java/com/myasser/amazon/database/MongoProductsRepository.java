package com.myasser.amazon.database;

import com.myasser.amazon.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MongoProductsRepository extends MongoRepository<Product, UUID> {

    @Query("{ 'id' : ?0 }")
    Optional<Product> getProductById(String id);


    @Query("{ 'category' : ?0 }")
    Optional<List<Product>> getProductByCategory(String category);
}
