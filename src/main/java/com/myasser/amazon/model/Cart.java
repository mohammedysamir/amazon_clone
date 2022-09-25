package com.myasser.amazon.model;

import java.util.List;
import java.util.UUID;

public class Cart {
    List<Product> cartProduct;
    UUID userId;
    UUID cartId;
    double total;

    public Cart(List<Product> cartProduct, UUID userId, UUID cartId) {
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
