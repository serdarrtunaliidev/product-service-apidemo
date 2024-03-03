package com.example.productservice.productserviceapidemo.repository;

import com.example.productservice.productserviceapidemo.dto.ProductInfoResponseDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ProductInfoResponseDto> getByCategory (String category) {
        String sql = "SELECT * FROM products WHERE category = ?";
        return jdbcTemplate.query(sql, new Object[]{category}, new ProductMapper());
    }
}
