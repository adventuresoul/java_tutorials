package com.spring.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.model.Product;
import com.spring.crud.repository.ProductRepositoryImpl;

@Service
public class ProductService {
    private final ProductRepositoryImpl productRepo;

    @Autowired
    public ProductService(ProductRepositoryImpl repo) {
        this.productRepo = repo;
    }

    public List<Product> getAllProducts() {
        return this.productRepo.findAll();
    }

    public Product getProductById(Long id) {
        return this.productRepo.findById(id);
    }

    public void addProduct(Product product) {
        this.productRepo.save(product);
    }

    public void updateProduct(Product product) {
        this.productRepo.update(product);
    }

    public void deleteProduct(Long id) {
        this.productRepo.delete(id);
    }
}
