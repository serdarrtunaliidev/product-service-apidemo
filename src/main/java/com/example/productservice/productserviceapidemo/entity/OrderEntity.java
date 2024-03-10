package com.example.productservice.productserviceapidemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

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

    /*@OneToMany(mappedBy = "order")*/
}
