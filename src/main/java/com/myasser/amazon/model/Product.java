package com.myasser.amazon.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Product {
    public UUID getId() {
        return id;
    }

    public Product(@JsonProperty("name") String name, @JsonProperty("description") String description, @JsonProperty("image") String image, @JsonProperty("category") String category, @JsonProperty("price") double price, @JsonProperty("quantity") int quantity) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(@JsonProperty("name") String name, @JsonProperty("description") String description, @JsonProperty("image") String image, @JsonProperty("brand") String brand, @JsonProperty("color") String color, @JsonProperty("category") String category, @JsonProperty("price") double price, @JsonProperty("quantity") int quantity) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.brand = brand;
    }

    public void setId(UUID id) {
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
        brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        color = color;
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

    UUID id;
    String name, description, image, category, brand, color;
    double price;
    int quantity;
}