package com.myasser.amazon.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public class Cart {
    List<Product> cartProduct;
    UUID userId;
    UUID cartId;
    double total;

    public Cart(@JsonProperty("cart-list") List<Product> cartProduct, UUID userId, UUID cartId) {
        this.cartProduct = cartProduct;
        this.userId = userId;
        this.cartId = cartId;
    }

    public List<Product> getCartProduct() {
        return cartProduct;
    }

    public void setCartProduct(List<Product> cartProduct) {
        this.cartProduct = cartProduct;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getCartId() {
        return cartId;
    }

    public void setCartId(UUID cartId) {
        this.cartId = cartId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cart(UUID cartId) {
        this.cartId = cartId;
    }
}
//todo: add methods to service and controller for get product by id, get all products, add product, clear, delete product, fetch products from DB