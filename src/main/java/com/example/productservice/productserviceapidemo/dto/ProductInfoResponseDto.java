package com.example.productservice.productserviceapidemo.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductInfoResponseDto {
    private String name;
    private String category;
    private Double price;
}
