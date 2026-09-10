package com.sethdevkh.ecommerce.system.order.service.persistence.entity;

import com.sethdevkh.ecommerce.system.domain.valueobject.OrderStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID customerId;
    private UUID businessId;
    private BigDecimal price;

    @OneToMany(mappedBy = "order") // always use mapped by on Many side
    private List<OrderItemEntity> items;

    @OneToOne
    private StreetAddressEntity streetAddress;

    private UUID trackingId;
    private OrderStatus orderStatus;
    private String failureMessages;
}
