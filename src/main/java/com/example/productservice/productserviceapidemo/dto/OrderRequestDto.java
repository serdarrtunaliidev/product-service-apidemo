package com.example.productservice.productserviceapidemo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequestDto {
    private long productId;
    private String orderDescription;
    private Double totalAmount;
}
