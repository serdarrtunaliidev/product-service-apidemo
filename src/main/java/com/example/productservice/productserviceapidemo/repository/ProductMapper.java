package com.example.productservice.productserviceapidemo.repository;

import com.example.productservice.productserviceapidemo.dto.ProductInfoRequestDto;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class ProductMapper implements RowMapper<ProductInfoRequestDto> {
    @Override
    public ProductInfoRequestDto mapRow(ResultSet rs, int rowNum) throws SQLException {
       return  ProductInfoRequestDto.builder()
                .name(rs.getString("name"))
               .category(rs.getString("category"))
               .price(rs.getDouble("price")).build();
    }
}
