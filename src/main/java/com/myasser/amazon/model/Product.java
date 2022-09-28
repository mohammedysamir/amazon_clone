package com.myasser.amazon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import java.util.UUID;

@Document("products")
public class Product {
    public String getId() {
        return id;
    }

    public Product() {
    }

    public Product(String name, String description, String category, double price, int quantity, String image, String brand, String color) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.brand = brand;
    }

    @Setter
    @Getter
    @Id
    @JsonProperty("id")
    String id;
    @Setter
    @Getter
    @JsonProperty("name")
    @NonNull
    String name;
    @Setter
    @Getter
    @JsonProperty("description")
    @NonNull

    String description;
    @Setter
    @Getter
    @JsonProperty("image")
    String image;

    @NonNull
    @Setter
    @Getter
    @JsonProperty("category")
    String category;
    @Setter
    @Getter
    @JsonProperty("brand")
    String brand;
    @Setter
    @Getter
    @JsonProperty("color")
    String color;
    @Setter
    @Getter
    @NonNull
    @JsonProperty("price")
    double price;
    @Setter
    @Getter
    @NonNull
    @JsonProperty("quantity")
    int quantity;
}