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
    CartService cartService;

    public UserService() {
    }

    @Autowired
    UserService(MongoUsersRepository userRepo, CartService cartService) {
        this.usersRepository = userRepo;
        this.cartService = cartService;
    }

    public User getUser(String id) {
        return usersRepository.findById(id).orElse(null);
    }

    public User postUser(User user) {
        usersRepository.insert(user);
        return user;
    }


    public User putUser(String id, User user) {
        int index = usersRepository.findAll().indexOf(getUser(id));
        if (index >= 0) {
            return usersRepository.save(user);
        } else
            return postUser(user);
    }

    public Cart getCart(String id) {
        Optional<Cart> cart = cartService.getCartByUserId(id);
        return cart.orElse(null);
    }

    public Cart initiateUserCart(String userId) {
        Cart cart = new Cart();
        cart.setCartId(UUID.randomUUID().toString());
        cart.setUserId(userId);
        cart.setCartProduct(new ArrayList<>());
        return cart;
    }

    public Cart addProductToCart(String userId, Product product) {
        return cartService.addProductToCart(userId, product);
    }

    public Cart deleteProductFromCart(String userId, String productId) {
        return cartService.deleteProductById(userId, productId);
    }

    public List<Product> getCartProducts(String userId) {
        return cartService.getCartProducts(userId);
    }

    public Product getCartProduct(String userId, String productId) {
        return cartService.getCartProduct(userId, productId);
    }

    public Double calculateCartTotal(String userId) {
        return getCartProducts(userId).stream().mapToDouble(Product::getPrice).sum();
    }
}
