package com.example.productservice.productserviceapidemo.mapper;


import com.example.productservice.productserviceapidemo.dto.OrderRequestDto;
import com.example.productservice.productserviceapidemo.dto.ProductInfoRequestDto;
import com.example.productservice.productserviceapidemo.entity.OrderEntity;
import com.example.productservice.productserviceapidemo.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperToEntity {
    public OrderEntity mapToEntity(OrderRequestDto incomingDto) {
        return OrderEntity.builder()
                .orderDescription(incomingDto.getOrderDescription())
                .totalAmount(incomingDto.getTotalAmount())
                .build();
    }
}
