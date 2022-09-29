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

    public ProductController() {
    }

    @PutMapping(path = "{id}")
    public Product putProduct(@PathVariable String id, @RequestBody Product product) {
        return service.putProduct(id, product);
    }
    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @DeleteMapping(path = "{id}")
    public void deleteProduct(@PathVariable String id) {
        service.deleteProduct(id);
    }
}
