package com.example.productservice.productserviceapidemo.util;

import com.example.productservice.productserviceapidemo.entity.OrderEntity;
import com.example.productservice.productserviceapidemo.entity.OrderProductEntity;
import com.example.productservice.productserviceapidemo.entity.ProductEntity;
import com.example.productservice.productserviceapidemo.repository.OrderProductRepository;
import com.example.productservice.productserviceapidemo.repository.OrderRepository;
import com.example.productservice.productserviceapidemo.repository.ProductRepoJpa;
import com.example.productservice.productserviceapidemo.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class UtilOrderProduct {

private final OrderRepository orderRepository;
private final ProductRepoJpa productRepoJpa;
private final OrderProductRepository orderProductRepository;

    public UtilOrderProduct(OrderRepository orderRepository, ProductRepoJpa productRepoJpa, OrderProductRepository orderProductRepository) {
        this.orderRepository = orderRepository;
        this.productRepoJpa = productRepoJpa;
        this.orderProductRepository = orderProductRepository;
    }

    @PostConstruct
    public void init() {
        ProductEntity product = new ProductEntity();
        product.setCategory("phone");
        product.setName("ıphone 15");
        productRepoJpa.save(product);

        ProductEntity product3 = new ProductEntity();
        product3.setCategory("phone");
        product3.setName("ıphone 12");
        productRepoJpa.save(product3);

        ProductEntity product2 = new ProductEntity();
        product2.setCategory("tv");
        productRepoJpa.save(product2);

        OrderEntity order = new OrderEntity();
        order.setOrderDescription("order desc1");
        order.setOrderNumber("1");
        orderRepository.save(order);

        OrderProductEntity orderProduct = new OrderProductEntity();
        orderProduct.setOrder(order);
        orderProduct.setProduct(product);
        orderProductRepository.save(orderProduct);


    }
}
