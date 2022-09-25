package com.myasser.amazon.service;

import com.myasser.amazon.database.MongoCartRepository;
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

    MongoCartRepository cartRepository;
    @Autowired
    public CartService(MongoCartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart postCart() {
        return cartRepository.save(cart);
    }

    public Cart getCart(UUID cartId) {
        cart = cartRepository.findById(cartId).get();
        return cart;
    }

    public Cart putCart(UUID id,Cart cart) {
        return cartRepository.putCart(id,cart);
    }

    public void deleteCart(UUID id) {
        cartRepository.delete(getCart(id));
    }

    public Product postProduct(Product product) {
        cart.getCartProduct().add(product);
        return product;
    }

    public void deleteProductById(UUID cartId,UUID id) {
        getCart(cartId).getCartProduct().removeIf(product -> product.getId().equals(id));
    }

    public List<Product> getCartProducts(UUID id){
        return getCart(id).getCartProduct();
    }

    public Optional<Product> getCartProductById(UUID cartId,UUID id) {
        return getCart(id).getCartProduct().stream().filter(product -> product.getId().equals(id)).findFirst();
    }
}
