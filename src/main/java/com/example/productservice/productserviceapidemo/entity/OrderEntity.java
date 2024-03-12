package com.example.productservice.productserviceapidemo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name = "orders")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OrderEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String orderNumber;
    private Date orderDate;
    private String orderDescription;
    private Double totalAmount;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private Set<OrderProductEntity> orderProducs = new HashSet<>();

    /*@OneToMany(mappedBy = "order")*/
}
