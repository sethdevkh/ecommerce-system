package com.sethdevkh.ecommerce.system.order.service.domain.ports.input;

import com.sethdevkh.ecommerce.system.order.service.domain.dto.CreateOrderCommand;

public interface ExplicitPort {
    void execute(CreateOrderCommand createOrderCommand);
}
