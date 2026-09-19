package com.sethdevkh.ecommerce.system.order.service.domain.usecase;

import com.sethdevkh.ecommerce.system.order.service.domain.dto.CreateOrderCommand;
import com.sethdevkh.ecommerce.system.order.service.domain.dto.CreateOrderResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class CreateOrderUseCase {
    public CreateOrderResult execute(CreateOrderCommand createOrderCommand) {
        log.info("Create Order Request: {}", createOrderCommand);

        return new CreateOrderResult(UUID.randomUUID());
    }
}
