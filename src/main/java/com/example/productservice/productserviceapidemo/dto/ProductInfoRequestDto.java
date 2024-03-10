package com.example.productservice.productserviceapidemo.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductInfoRequestDto {
    private String name;
    private String category;
    private Double price;
}
