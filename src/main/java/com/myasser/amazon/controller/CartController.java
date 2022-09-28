package com.myasser.amazon.controller;

import com.myasser.amazon.model.Product;
import com.myasser.amazon.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    public CartController() {
    }

    @PostMapping
    public Product postProductToCart(@RequestBody Product product) {
        return cartService.postProduct(product);
    }

    @DeleteMapping(path = "{id}")
    public void deleteProductFromCart(@NonNull String id, @PathVariable String productId) {
        cartService.deleteProductById(id, productId);
    }

    @GetMapping(path = "{id}/{productId}")
    public Product getProductFromCart(@NonNull String id, @PathVariable String productId) {
        return cartService.getCartProductById(id, productId).orElse(null);
    }

    @GetMapping(path = "{id}")
    public List<Product> getCartProducts(@PathVariable String id) {
        return cartService.getCartProducts(id);
    }

    @GetMapping(path = "{id}/total")
    public double getCartTotal(@PathVariable String id) {
        return cartService.calculateTotalPrice(id);
    }
}
