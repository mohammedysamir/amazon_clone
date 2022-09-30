package com.myasser.amazon.controller;

import com.myasser.amazon.model.Product;
import com.myasser.amazon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {
    ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    public ProductController() {
    }

    @PutMapping(path = "{id}")
    public Product putProduct(@PathVariable String id, @RequestBody Product product) {
        return service.putProduct(id, product);
    }

    @GetMapping(path = "{id}")
    public Product getProduct(@PathVariable String id) {
        return service.getProductById(id);
    }

    //todo: maybe need to delete below functions -> accessed from system after all.
    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @DeleteMapping(path = "{id}")
    public void deleteProduct(@PathVariable String id) {
        service.deleteProduct(id);
    }
}
