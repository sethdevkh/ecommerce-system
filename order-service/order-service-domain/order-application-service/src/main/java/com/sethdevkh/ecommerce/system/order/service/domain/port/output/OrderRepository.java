package com.sethdevkh.ecommerce.system.order.service.domain.port.output;

import com.sethdevkh.ecommerce.system.order.service.domain.entity.Order;

public interface OrderRepository {
    Order saveOrder(Order order);
}
