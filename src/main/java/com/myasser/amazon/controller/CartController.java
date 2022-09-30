package com.myasser.amazon.controller;

import com.myasser.amazon.model.Cart;
import com.myasser.amazon.model.Product;
import com.myasser.amazon.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {
    private CartService cartService;

    public CartController() {
    }

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(path = {"{userId}/products"})
    public void addProductToCart(@NonNull @PathVariable String userId, @RequestBody Product product) {
        cartService.addProductToCart(userId, product);
    }

    @GetMapping(path = {"{userId}"})
    public Optional<Cart> getCartByUserId(@PathVariable @NonNull String userId) {
        return cartService.getCartByUserId(userId);
    }

    @GetMapping(path = {"{userId}/products"})
    public void deleteProductById(@NonNull @PathVariable String userId, @NonNull String productId) {
        cartService.deleteProductById(userId, productId);
    }

    @GetMapping(path = {"{userId}/products)"})
    public List<Product> getCartProducts(@NonNull @PathVariable String userId) {
        return cartService.getCartProducts(userId);
    }

    @GetMapping(path = {"{userId}/products/{productId}"})
    public Product getCartProduct(@NonNull @PathVariable String userId, @NonNull @PathVariable String productId) {
        return cartService.getCartProduct(userId, productId);
    }

    @GetMapping(path = {"{userId}/products/category/{categoryName}"})
    public List<Product> getCartProductsByCategory(@NonNull @PathVariable String userId, @NonNull @PathVariable String categoryName) {
        return cartService.getProductsByCategory(userId, categoryName);
    }
}
