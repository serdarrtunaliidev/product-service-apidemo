package com.example.productservice.productserviceapidemo.repository;

import com.example.productservice.productserviceapidemo.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity,Long> {
}
