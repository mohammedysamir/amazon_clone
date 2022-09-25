package com.myasser.amazon.database;

import com.myasser.amazon.model.Cart;
import com.myasser.amazon.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface MongoUsersRepository extends MongoRepository<User, UUID> {
    Cart getUserCart(UUID userId);

    Cart putUserCart(UUID userId, Cart cart);

    User getUserById(UUID id);

    void postUser(User user);

    void postUsers(List<User> users);

    void putUser(User user);

    void deleteUser(UUID id);
}
