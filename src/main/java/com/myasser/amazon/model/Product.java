package com.myasser.amazon.model;

import java.util.UUID;

public class Product {
    public UUID getId() {
        return id;
    }

    public Product(UUID id, String name, String description, String image, String category, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(UUID id, String name, String description, String image, String category, String brand, String color, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.category = category;
        Brand = brand;
        Color = color;
        this.price = price;
        this.quantity = quantity;
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
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
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
    String name, description, image, category, Brand, Color;
    double price;
    int quantity;
}
//todo: add method to service and  controller to get ,update, delete and post product