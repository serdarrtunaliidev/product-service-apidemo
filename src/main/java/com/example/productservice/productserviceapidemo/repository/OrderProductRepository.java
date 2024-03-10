package com.example.productservice.productserviceapidemo.repository;

import com.example.productservice.productserviceapidemo.entity.OrderProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderProductRepository extends CrudRepository<OrderProductEntity,Long> {
}
