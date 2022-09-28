package com.myasser.amazon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Id
    @JsonProperty("id")
    String id;
    @JsonProperty("name")
    @NonNull
    String name;
    @JsonProperty("description")
    @NonNull

    String description;
    @JsonProperty("image")
    String image;
    @NonNull

    @JsonProperty("category")
    String category;
    @JsonProperty("brand")
    String brand;
    @JsonProperty("color")
    String color;
    @NonNull
    @JsonProperty("price")
    double price;
    @NonNull
    @JsonProperty("quantity")
    int quantity;
}