package com.example.productservice.productserviceapidemo.service;

import com.example.productservice.productserviceapidemo.dto.ProductInfoRequestDto;
import com.example.productservice.productserviceapidemo.entity.ProductEntity;

import com.example.productservice.productserviceapidemo.mapper.ProductMapperToEntity;
import com.example.productservice.productserviceapidemo.repository.ProductRepoJpa;
import com.example.productservice.productserviceapidemo.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService extends BaseService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;
    private final ProductRepoJpa productRepoJpa;
    private final ProductMapperToEntity productMapperToEntity;

    public ProductService(ProductRepository productRepository, ProductRepoJpa productRepoJpa, ProductMapperToEntity productMapperToEntity) {
        this.productRepository = productRepository;
        this.productRepoJpa = productRepoJpa;
        this.productMapperToEntity = productMapperToEntity;
    }

    public List<ProductInfoRequestDto> getProductsByCategory(String category) {
        return productRepository.getByCategory(category);
    }

    public ProductEntity getProductById(Long productId) {
        return productRepoJpa.findById(productId).get();
    }

    public ResponseEntity<ProductEntity> save(ProductInfoRequestDto incomingDto) {
        if(Objects.nonNull(incomingDto.getCategory()) && Objects.nonNull(incomingDto.getName()) && Objects.nonNull(incomingDto.getPrice())) {
            ProductEntity productEntity = productMapperToEntity.mapToEntity(incomingDto);
            ProductEntity response = productRepoJpa.save(productEntity);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        logger.error("Product parameter in request is invalid");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


    }

    public void deleteById(Long productId) {
        ProductEntity productEntity = productRepoJpa.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product Not Found"));
        productRepoJpa.delete(productEntity);
    }
}
