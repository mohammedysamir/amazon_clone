package com.myasser.amazon.service;

import com.myasser.amazon.database.MongoUsersRepository;
import com.myasser.amazon.model.Cart;
import com.myasser.amazon.model.Product;
import com.myasser.amazon.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Configuration
public class UserService {
    MongoUsersRepository usersRepository;

    List<User> users;

    public UserService() {
        users = new ArrayList<User>();
    }

    @Autowired
    UserService(MongoUsersRepository userRepo) {
        this.usersRepository = userRepo;
        users = usersRepository.findAll();
    }

    public User getUser(String id) {
        return usersRepository.getUserById(id).orElse(null);
    }

    public User postUser(User user) {
        usersRepository.insert(user);
        return user;
    }


    public User putUser(String id, User user) {
        int index = usersRepository.findAll().indexOf(getUser(id));
        if (index >= 0) {
            users.set(index, user);
            usersRepository.save(user);
            return users.get(index);
        } else
            return postUser(user);
    }

    public Cart getCart(String id) {
        return usersRepository.getUserCart(id);
    }

    public Cart initiateUserCart(String userId) {
        Cart cart = new Cart();
        cart.setCartId(UUID.randomUUID().toString());
        cart.setUserId(userId);
        cart.setCartProduct(new ArrayList<>());
        return cart;
    }

    public Cart addProductToCart(String userId, Product product) {
        Cart cart = getCart(userId);
        cart.getCartProduct().add(product);
        User user = getUser(userId);
        user.setCart(cart);
        usersRepository.save(user);
        return cart;
    }

    public Cart deleteProductFromCart(String userId, String productId) {
        Cart cart = getCart(userId);
        cart.getCartProduct().removeIf(product -> product.getId().equals(productId));
        User user = getUser(userId);
        user.setCart(cart);
        usersRepository.save(user);
        return cart;
    }

    public List<Product> getCartProducts(String userId) {
        return getCart(userId).getCartProduct();
    }

    public Optional<Product> getCartProduct(String userId, String productId) {
        return getCartProducts(userId).stream().filter(product -> product.getId().equals(productId)).findFirst();
    }

    public Double calculateCartTotal(String userId) {
        return getCartProducts(userId).stream().mapToDouble(Product::getPrice).sum();
    }
}
