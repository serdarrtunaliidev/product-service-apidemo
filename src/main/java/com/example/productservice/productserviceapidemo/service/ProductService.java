package com.example.productservice.productserviceapidemo.service;

import com.example.productservice.productserviceapidemo.dto.ProductInfoResponseDto;
import com.example.productservice.productserviceapidemo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends BaseService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductInfoResponseDto> getProductsByCategory(String category) {
        return productRepository.getByCategory(category);
    }
}
