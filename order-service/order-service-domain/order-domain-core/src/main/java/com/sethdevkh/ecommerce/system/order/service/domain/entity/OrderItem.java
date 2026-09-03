package com.sethdevkh.ecommerce.system.order.service.domain.entity;

import com.sethdevkh.ecommerce.system.domain.entity.BaseEntity;
import com.sethdevkh.ecommerce.system.domain.valueobject.Money;
import com.sethdevkh.ecommerce.system.domain.valueobject.OrderId;
import com.sethdevkh.ecommerce.system.domain.valueobject.OrderItemId;

public class OrderItem extends BaseEntity<OrderItemId> {
    private final OrderItemId orderItemId;
    private final OrderId orderId;
    private final Product product;
    private final Integer quantity;
    private final Money price;
    private final Money subTotal;

    public OrderItem(OrderItemId orderItemId, OrderId orderId, Product product, Integer quantity, Money price, Money subTotal) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.subTotal = subTotal;
    }
}
