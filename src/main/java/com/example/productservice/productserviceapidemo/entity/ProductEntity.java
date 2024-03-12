package com.example.productservice.productserviceapidemo.entity;




import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Table(name = "product")
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
    @OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE)
    private Set<OrderProductEntity> orderProducts = new HashSet<>();

}
