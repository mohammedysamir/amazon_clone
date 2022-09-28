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
    Cart cart;
    MongoCartRepository cartRepository;

    @Autowired
    public CartService(MongoCartRepository cartRepository) {
        this.cartRepository = cartRepository;
        //todo: fetch cart here and assign it to cart attribute
    }

    public CartService() {
    }

    public Cart postCart() {
        return cartRepository.save(cart);
    }

    public Cart getCart(String cartId) {
        //todo: solve 'no value present error'
        cart = cartRepository.findById(cartId).get();
        return cart;
    }

    public Cart putCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public void deleteCart(String id) {
        cartRepository.delete(getCart(id));
    }

    public Product postProduct(Product product) {
        cart.getCartProduct().add(product);
        return product;
    }

    public void deleteProductById(String cartId, String id) {
        getCart(cartId).getCartProduct().removeIf(product -> product.getId().equals(id));
    }

    public List<Product> getCartProducts(String id) {
        return getCart(id).getCartProduct();
    }

    public Optional<Product> getCartProductById(String cartId, String id) {
        return getCart(id).getCartProduct().stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    public double calculateTotalPrice(String cartId) {
        double total = 0.0;
        for (Product product : getCartProducts(cartId)) {
            total += product.getPrice();
        }
        cart.setTotal(total);
        return total;
    }
}
