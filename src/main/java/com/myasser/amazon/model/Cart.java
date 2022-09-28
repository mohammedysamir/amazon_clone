package com.myasser.amazon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.UUID;

@Document("cart")
public class Cart {
    @Id
    @JsonProperty("cartId")
    @NonNull
    String cartId;
    @JsonProperty("products")
    List<Product> cartProduct;
    @JsonProperty("userId")
    String userId;
    @JsonProperty("total")
    double total;

    public Cart(List<Product> cartProduct, String userId, String cartId) {
        this.cartProduct = cartProduct;
        this.userId = userId;
        this.cartId = cartId;
    }

    public Cart() {
        cartId = UUID.randomUUID().toString();
    }

    public List<Product> getCartProduct() {
        return cartProduct;
    }

    public void setCartProduct(List<Product> cartProduct) {
        this.cartProduct = cartProduct;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cart(String cartId) {
        this.cartId = cartId;
    }
}
//todo: add methods to service and controller for get product by id, get all products, add product, clear, delete product, fetch products from DB