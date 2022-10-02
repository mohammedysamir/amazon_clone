package com.myasser.amazon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;
import java.util.List;

@Document(collection = "carts")
public class Cart {
    @Id
    @Setter
    @Getter
    @JsonProperty("cartId")
    String cartId;
    @JsonProperty("products")
    @Setter
    @Getter
    List<Product> cartProduct;
    @Setter
    @Getter
    @JsonProperty("userId")
    String userId;
    @Setter
    @Getter
    @JsonProperty("total")
    double total;

    public Cart(List<Product> cartProduct, String userId) {
        this.cartProduct = cartProduct;
        this.userId = userId;
    }

    public Cart() {
    }
}