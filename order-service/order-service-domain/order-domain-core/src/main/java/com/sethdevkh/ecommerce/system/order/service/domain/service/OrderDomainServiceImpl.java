package com.sethdevkh.ecommerce.system.order.service.domain.service;

import com.sethdevkh.ecommerce.system.order.service.domain.entity.Business;
import com.sethdevkh.ecommerce.system.order.service.domain.entity.Order;
import com.sethdevkh.ecommerce.system.order.service.domain.entity.Product;
import com.sethdevkh.ecommerce.system.order.service.domain.event.OrderCancelledEvent;
import com.sethdevkh.ecommerce.system.order.service.domain.event.OrderCreatedEvent;
import com.sethdevkh.ecommerce.system.order.service.domain.event.OrderPaidEvent;
import com.sethdevkh.ecommerce.system.order.service.domain.exception.OrderDomainException;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class OrderDomainServiceImpl implements OrderDomainService {

    @Override
    public OrderCreatedEvent validateAndInitiateOrder(Order order, Business business) {
        // Validate business
        if (!business.isActive()) {
            throw new OrderDomainException("Business wit ID: " +  business.getId() + "is not currently active");
        }

        // Set order product information
        order.getItems().forEach(orderItem -> {
            business.getProducts().forEach(businessProduct -> {
                Product currentProduct = orderItem.getProduct();
                if (businessProduct.equals(currentProduct)) {
                    currentProduct.updateConfirmedNameAndPrice(businessProduct.getName(),
                            businessProduct.getPrice());
                }
            });
        });

        order.validateOrder();
        order.initializeOrder();

        return new OrderCreatedEvent(order, ZonedDateTime.now(ZoneId.of("UTC")));
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
