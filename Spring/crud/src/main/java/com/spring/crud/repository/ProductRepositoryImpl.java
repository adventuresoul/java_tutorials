package com.spring.crud.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.crud.model.Product;

/*
Specialized for persistence layer (DAO/repository classes).
Automatically translates database exceptions (e.g., SQLException) into Spring’s DataAccessException, which is an unchecked exception.
Helps with AOP-based transactions and database error handling.
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository{
    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    // RowMapper to convert ResultSet to Product object
    RowMapper<Product> mapper = (rs, rowNum) -> {
            Product pr = new Product();
            pr.setId(rs.getLong("id"));
            pr.setName(rs.getString("name"));
            pr.setDescription(rs.getString("description"));
            pr.setPrice(rs.getDouble("price"));
            return pr;
    };

    /*
     * Returns the product by id
     * @param id the Long type unique id
     * @return the result object after sql operation
     */
    @Override
    public Product findById(Long id) {
        String sql = "SELECT * FROM product WHERE id = ?";
        return template.queryForObject(sql, mapper, id);
    }

    /*
     * Returns all the products
     * @param no params
     * @return the result List of object after sql operation
     */
    @Override
    public List<Product> findAll() {
        String sql = "SELECT * FROM product";
        return template.query(sql, mapper);
    }

    /*
     * Saves the product specified in @param
     * @param product obj ref
     * @return void
     */
    @Override
    public void save(Product product) {
        String sql = "INSERT INTO product (name, description, price) VALUES (?, ?, ?)";
        template.update(sql, product.getName(), product.getDescription(), product.getPrice());
    }

    /*
     * Updates the product specified in @param
     * @param product obj ref
     * @return void
     */
    @Override
    public void update(Product product) {
        String sql = "UPDATE product SET name = ?, description = ?, price = ? WHERE id = ?";
        template.update(sql, product.getName(), product.getDescription(), product.getPrice(), product.getId());
    }

    /*
     * deletes the product specified by id in @param
     * @param product id
     * @return void
     */
    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM product WHERE id = ?";
        template.update(sql, id);
    }
}