package com.example.productservice.productserviceapidemo.controller;

import com.example.productservice.productserviceapidemo.dto.ProductInfoRequestDto;
import com.example.productservice.productserviceapidemo.entity.ProductEntity;
import com.example.productservice.productserviceapidemo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/product")
@Slf4j
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
            log.info("hebe");
            return new ResponseEntity<>("işleminiz gerçekleşmiştir",HttpStatus.CREATED);

        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }


    @DeleteMapping()
    public ResponseEntity delete(@RequestParam Long productId){
        try {
            productService.deleteById(productId);
            return ResponseEntity.ok().build();
        }catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Not Found");
        }
    }
}
