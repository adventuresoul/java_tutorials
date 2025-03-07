package com.spring.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.model.Product;
import com.spring.crud.service.ProductService;


@RestController
public class ProductController {
    private final ProductService serivce;

    @Autowired
    public ProductController(ProductService service) {
        this.serivce = service;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return this.serivce.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return this.serivce.getProductById(id);
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        this.serivce.addProduct(product);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        this.serivce.updateProduct(product);
    }

    @DeleteMapping("/{id}") 
    public void deleteProduct(@PathVariable Long id) {
        this.serivce.deleteProduct(id);
    }
}
