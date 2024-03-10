package com.example.productservice.productserviceapidemo.controller;

import com.example.productservice.productserviceapidemo.dto.ProductInfoRequestDto;
import com.example.productservice.productserviceapidemo.entity.ProductEntity;
import com.example.productservice.productserviceapidemo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController extends BaseController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/getProductsByCategory")
    public List<ProductInfoRequestDto> getProductsByCategory(@RequestParam String category) {
        return productService.getProductsByCategory(category);
    }

    @PostMapping(path = "/save")
    public ResponseEntity save(@RequestBody ProductInfoRequestDto request) {
        ResponseEntity<ProductEntity> response = productService.save(request);
        if(response.getStatusCode().equals(HttpStatus.CREATED)) {
            return new ResponseEntity<>("işleminiz gerçekleşmiştir",HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
