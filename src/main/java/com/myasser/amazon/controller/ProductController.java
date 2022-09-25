package com.myasser.amazon.controller;

import com.myasser.amazon.model.Product;
import com.myasser.amazon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/product")
@RestController
public class ProductController {
    ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Product postProduct(@RequestBody Product product) {
        product.setId(UUID.randomUUID());
        return service.postProduct(product);
    }

    @PutMapping(path = "{id}")
    public Product putProduct(@PathVariable UUID id, @RequestBody Product product) {
        return service.putProduct(id, product);
    }

    @GetMapping(path = "{id}")
    public Product getProductById(@PathVariable UUID id) {
        return service.getProductById(id).orElse(null);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @DeleteMapping(path = "{id}")
    public void deleteProduct(@PathVariable UUID id) {
        service.deleteProduct(id);
    }
}
