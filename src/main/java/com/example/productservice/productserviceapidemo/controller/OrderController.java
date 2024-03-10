package com.example.productservice.productserviceapidemo.controller;

import com.example.productservice.productserviceapidemo.dto.OrderRequestDto;
import com.example.productservice.productserviceapidemo.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody OrderRequestDto orderRequestDto) {
        ResponseEntity responseEntity = orderService.save(orderRequestDto);
        return responseEntity;
    }
}
