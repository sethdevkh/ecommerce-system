package com.sethdevkh.ecommerce.system.order.service.domain.service;

import com.sethdevkh.ecommerce.system.order.service.domain.entity.Business;
import com.sethdevkh.ecommerce.system.order.service.domain.entity.Order;
import com.sethdevkh.ecommerce.system.order.service.domain.entity.OrderItem;
import com.sethdevkh.ecommerce.system.order.service.domain.entity.Product;
import com.sethdevkh.ecommerce.system.order.service.domain.event.OrderCancelledEvent;
import com.sethdevkh.ecommerce.system.order.service.domain.event.OrderCreatedEvent;
import com.sethdevkh.ecommerce.system.order.service.domain.event.OrderPaidEvent;
import com.sethdevkh.ecommerce.system.order.service.domain.exception.OrderDomainException;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrderDomainServiceImpl implements OrderDomainService {
    @Override
    public OrderCreatedEvent validateAndInitiateOrder(Order order, Business business) {
        if (!business.isActive()) {
            throw new OrderDomainException("Business is not active.");
        }

        Order orderWithCatalogProducts = enrichOrderWithBusinessProducts(order, business);
        orderWithCatalogProducts.validateOrder();
        orderWithCatalogProducts.initializeOrder();

        return new OrderCreatedEvent(orderWithCatalogProducts, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    private Order enrichOrderWithBusinessProducts(Order order, Business business) {
        Map<UUID, Product> catalogProductsById = business.getProducts().stream()
                .collect(Collectors.toMap(product -> product.getId().value(), Function.identity()));

        List<OrderItem> enrichedItems = order.getItems().stream()
                .map(orderItem -> {
                    UUID productId = orderItem.getProduct().getId().value();
                    Product catalogProduct = catalogProductsById.get(productId);
                    if (catalogProduct == null) {
                        throw new OrderDomainException("Product is not sold by business: " + productId);
                    }
                    return OrderItem.builder()
                            .product(catalogProduct)
                            .quantity(orderItem.getQuantity())
                            .price(orderItem.getPrice())
                            .subTotal(orderItem.getSubTotal())
                            .build();
                })
                .toList();

        return Order.builder()
                .customerId(order.getCustomerId())
                .businessId(order.getBusinessId())
                .deliveryAddress(order.getDeliveryAddress())
                .price(order.getPrice())
                .items(enrichedItems)
                .build();
    }

    @Override
    public OrderPaidEvent payOrder(Order order) {
        order.pay();
        return new OrderPaidEvent(order, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public void approveOrder(Order order) {
        order.approve();
    }

    @Override
    public OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages) {
        order.initCancel(failureMessages);
        return new OrderCancelledEvent(order, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public void cancelOrder(Order order, List<String> failureMessages) {
        order.cancel(failureMessages);
    }
}
