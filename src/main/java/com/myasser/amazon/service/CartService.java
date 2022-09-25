package com.myasser.amazon.service;

import com.myasser.amazon.model.Cart;
import com.myasser.amazon.model.Product;
import com.myasser.amazon.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CartService {
    //todo: add database
    Cart cart;
    User user;

    @Autowired
    public CartService(User user) {
        user = user;
    }

    public CartService(User user, Cart cart) {
        this.user = user;
        this.cart = cart;
    }

    public Cart postCart() {
        cart = new Cart(new ArrayList<Product>(), UUID.randomUUID(), user.getUserId());
        //todo: save to db
        return cart;
    }

    public Cart getCart() {
        return cart;
    }

    public Cart putCart(Cart cart) {
        this.cart = cart;
        return cart;
    }

    public void deleteCart() {
        cart = null;
    }

    public Product postProduct(Product product) {
        cart.getCartProduct().add(product);
        return product;
    }

    public void clearCart() {
        cart.getCartProduct().clear();
    }

    public void deleteProductById(UUID id) {
        cart.getCartProduct().removeIf(product -> product.getId().equals(id));
    }

    public List<Product> getCartProducts(){
        return cart.getCartProduct();
    }

    public Optional<Product> getCartProductById(UUID id) {
        return cart.getCartProduct().stream().filter(product -> product.getId().equals(id)).findFirst();
    }
}
