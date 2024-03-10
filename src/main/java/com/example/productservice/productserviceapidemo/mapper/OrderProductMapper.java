package com.example.productservice.productserviceapidemo.mapper;

import com.example.productservice.productserviceapidemo.dto.OrderRequestDto;
import com.example.productservice.productserviceapidemo.entity.OrderEntity;
import com.example.productservice.productserviceapidemo.entity.OrderProductEntity;
import com.example.productservice.productserviceapidemo.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderProductMapper {
    public OrderProductEntity mapToEntity(ProductEntity product,OrderEntity order,String description) {
        return OrderProductEntity.builder()
                .order(order)
                .product(product)
                .orderProductDesc(description)
                .build();
    }
}
