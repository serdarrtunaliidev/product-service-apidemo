package com.example.productservice.productserviceapidemo.service;

import com.example.productservice.productserviceapidemo.dto.OrderRequestDto;
import com.example.productservice.productserviceapidemo.entity.OrderEntity;
import com.example.productservice.productserviceapidemo.entity.OrderProductEntity;
import com.example.productservice.productserviceapidemo.entity.ProductEntity;
import com.example.productservice.productserviceapidemo.mapper.OrderMapperToEntity;
import com.example.productservice.productserviceapidemo.mapper.OrderProductMapper;
import com.example.productservice.productserviceapidemo.repository.OrderProductRepository;
import com.example.productservice.productserviceapidemo.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderService extends BaseService{

    private final OrderRepository orderRepository;
    private final ProductService productService;

    private final OrderProductRepository orderProductRepository;
    private final OrderMapperToEntity orderMapperToEntity;
    private final OrderProductMapper orderProductMapper;

    public OrderService(OrderRepository orderRepository, ProductService productService, OrderProductRepository orderProductRepository, OrderMapperToEntity orderMapperToEntity, OrderProductMapper orderProductMapper) {
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.orderProductRepository = orderProductRepository;
        this.orderMapperToEntity = orderMapperToEntity;
        this.orderProductMapper = orderProductMapper;
    }

    public ResponseEntity<OrderEntity> save(OrderRequestDto orderRequestDto) {

        OrderEntity orderEntity = orderMapperToEntity.mapToEntity(orderRequestDto);
        orderRepository.save(orderEntity);
        Long productId = orderRequestDto.getProductId();
        String orderDescription = orderRequestDto.getOrderDescription();
        ProductEntity product = productService.getProductById(productId);
        OrderProductEntity orderProductEntity = orderProductMapper.mapToEntity(product,orderEntity,orderDescription);
        orderProductRepository.save(orderProductEntity);

        return new ResponseEntity<>(orderEntity, HttpStatus.CREATED);



    }
}
