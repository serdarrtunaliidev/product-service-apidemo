package com.example.productservice.productserviceapidemo.controller;

import com.example.productservice.productserviceapidemo.dto.ProductInfoResponseDto;
import com.example.productservice.productserviceapidemo.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController extends BaseController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/getProductsByCategory")
    public List<ProductInfoResponseDto> getProductsByCategory(@RequestParam String category) {
        return productService.getProductsByCategory(category);
    }
}
