package com.sethdevkh.ecommerce.system.order.service.domain.entity;

import com.sethdevkh.ecommerce.system.domain.entity.BaseEntity;
import com.sethdevkh.ecommerce.system.domain.valueobject.Money;
import com.sethdevkh.ecommerce.system.domain.valueobject.OrderId;
import com.sethdevkh.ecommerce.system.domain.valueobject.OrderItemId;

public class OrderItem extends BaseEntity<OrderItemId> {
    private OrderId orderId;
    private Product product;
    private Integer quantity;
    private Money price;
    private Money subTotal;
}
