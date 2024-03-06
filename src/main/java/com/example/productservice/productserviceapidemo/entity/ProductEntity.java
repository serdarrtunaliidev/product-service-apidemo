package com.example.productservice.productserviceapidemo.entity;




import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity extends BaseEntity implements Serializable {
    private String name;
    private String category;
    private String photoUrl;
    private String description;
    private Double price;

}
