package com.example.productservice.productserviceapidemo.repository;

import com.example.productservice.productserviceapidemo.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepoJpa  extends CrudRepository<ProductEntity,Long> {
}
