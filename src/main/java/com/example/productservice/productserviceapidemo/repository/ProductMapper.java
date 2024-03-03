package com.example.productservice.productserviceapidemo.repository;

import com.example.productservice.productserviceapidemo.dto.ProductInfoResponseDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<ProductInfoResponseDto> {
    @Override
    public ProductInfoResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
       return  ProductInfoResponseDto.builder()
                .name(rs.getString("name"))
               .category(rs.getString("category"))
               .price(rs.getDouble("price")).build();
    }
}
