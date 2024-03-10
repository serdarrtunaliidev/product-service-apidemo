package com.example.productservice.productserviceapidemo.service;

import com.example.productservice.productserviceapidemo.dto.OrderRequestDto;
import com.example.productservice.productserviceapidemo.entity.OrderEntity;
import com.example.productservice.productserviceapidemo.entity.OrderProductEntity;
import com.example.productservice.productserviceapidemo.entity.ProductEntity;
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

    public OrderService(OrderRepository orderRepository, ProductService productService, OrderProductRepository orderProductRepository) {
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.orderProductRepository = orderProductRepository;
    }

    public ResponseEntity save(OrderRequestDto orderRequestDto) {
        long productId = orderRequestDto.getProductId();
        String orderDescription = orderRequestDto.getOrderDescription();
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderDescription(orderDescription);
        orderRepository.save(orderEntity);

        ProductEntity product = productService.getProductById(productId);
        OrderProductEntity orderProductEntity = new OrderProductEntity();
        orderProductEntity.setOrder(orderEntity);
        orderProductEntity.setProduct(product);
        orderProductRepository.save(orderProductEntity);

        return new ResponseEntity<>(orderEntity, HttpStatus.CREATED);



    }
}
