package com.sethdevkh.ecommerce.system.order.service.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order_items")
@IdClass(OrderItemIdEntity.class)
public class OrderItemEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantity;
    private BigDecimal price;
    private BigDecimal subTotal;

    private UUID productId;

    @Id
    @ManyToOne
    private OrderEntity order;
}
