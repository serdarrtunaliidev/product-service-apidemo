package com.example.productservice.productserviceapidemo.mapper;

import com.example.productservice.productserviceapidemo.dto.ProductInfoResponseDto;
import com.example.productservice.productserviceapidemo.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperToEntity {
    public ProductEntity mapToEntity(ProductInfoResponseDto incomingDto) {
        return ProductEntity.builder()
                .name(incomingDto.getName())
                .price(incomingDto.getPrice())
                .category(incomingDto.getCategory())
                .description("deneme")
                .photoUrl("deneme.jpg")
                .build();
    }
}
