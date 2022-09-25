package com.myasser.amazon.controller;

import com.myasser.amazon.model.Product;
import com.myasser.amazon.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cart")
public class CartController {
    CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public Product postProductToCart(@RequestBody Product product) {
        return cartService.postProduct(product);
    }

    @DeleteMapping(path = "{id}")
    public void deleteProductFromCart(@PathVariable UUID id) {
        cartService.deleteProductById(id);
    }

    @GetMapping(path = "{id}")
    public Product getProductFromCart(@PathVariable UUID id) {
        return cartService.getCartProductById(id).orElse(null);
    }

    @GetMapping
    public List<Product> getCartProducts() {
        return cartService.getCartProducts();
    }
}
