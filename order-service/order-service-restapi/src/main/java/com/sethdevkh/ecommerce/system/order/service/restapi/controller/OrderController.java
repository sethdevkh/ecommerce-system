package com.sethdevkh.ecommerce.system.order.service.restapi.controller;

import com.sethdevkh.ecommerce.system.order.service.restapi.dto.OrderCreateRequest;
import com.sethdevkh.ecommerce.system.order.service.restapi.dto.OrderCreateResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public OrderCreateResponse createOrder(@Valid @RequestBody OrderCreateRequest request) {
        return OrderCreateResponse.builder()
                .orderId(UUID.randomUUID())
                .build();
    }
}
