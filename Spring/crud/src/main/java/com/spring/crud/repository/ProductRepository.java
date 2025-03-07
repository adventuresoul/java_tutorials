package com.spring.crud.repository;

import java.util.List;

import com.spring.crud.model.Product;

public interface ProductRepository {
    public Product findById(Long id);
    public List<Product> findAll();
    public void save(Product product);
    public void update(Product product);
    public void delete(Long id);
}
