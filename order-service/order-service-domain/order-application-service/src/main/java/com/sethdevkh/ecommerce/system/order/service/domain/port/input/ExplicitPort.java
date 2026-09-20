package com.sethdevkh.ecommerce.system.order.service.domain.port.input;

import com.sethdevkh.ecommerce.system.order.service.domain.dto.CreateOrderCommand;

public interface ExplicitPort {
    void execute(CreateOrderCommand createOrderCommand);
}
