package com.sethdevkh.ecommerce.system.order.service.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantity;
    private BigDecimal price;
    private BigDecimal subTotal;

    @OneToOne
    private ProductEntity product;

    @ManyToOne
    private OrderEntity order;
}
