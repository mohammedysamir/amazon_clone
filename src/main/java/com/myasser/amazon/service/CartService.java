package com.myasser.amazon.service;

import com.myasser.amazon.database.MongoCartRepository;
import com.myasser.amazon.model.Cart;
import com.myasser.amazon.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    MongoCartRepository cartRepository;

    public CartService() {
    }

    @Autowired
    public CartService(MongoCartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addProductToCart(String userId, Product product) {
        //get cart by user id
        //add product to its list -> save cart
        Optional<Cart> cart = cartRepository.findCartByUserId(userId);
        if (cart.isPresent()) {
            List<Product> products = cart.get().getCartProduct();
            products.add(product);
            cart.get().setCartProduct(products);
            cartRepository.save(cart.get());
        }
        System.out.println("Error: Cart not found");
    }

    public Optional<Cart> getCartByUserId(String userId) {
        return cartRepository.findCartByUserId(userId);
    }

    public void deleteProductById(String userId, String productId) {
        Optional<Cart> cart = cartRepository.findCartByUserId(userId);
        if (cart.isPresent()) {
            List<Product> products = cart.get().getCartProduct();
            products.removeIf(product -> product.getId().equals(productId));
            cart.get().setCartProduct(products);
            cartRepository.save(cart.get());
        }
        System.out.println("Error: Cart not found");
    }

    public List<Product> getCartProducts(String userId) {
        return cartRepository.findCartByUserId(userId).get().getCartProduct();
    }

    public Product getCartProduct(String userId, String productId) {
        return cartRepository.findCartByUserId(userId).get().getCartProduct().stream().filter(product -> product.getId().equals(productId)).findFirst().orElse(null);
    }

    public List<Product> getProductsByCategory(String userId, String category) {
        return cartRepository.findCartByUserId(userId).get().getCartProduct().stream().filter(product -> product.getCategory().equals(category)).toList();
    }
}
