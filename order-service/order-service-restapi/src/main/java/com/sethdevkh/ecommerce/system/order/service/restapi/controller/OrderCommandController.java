package com.sethdevkh.ecommerce.system.order.service.restapi.controller;

import com.sethdevkh.ecommerce.system.order.service.domain.dto.CreateOrderResult;
import com.sethdevkh.ecommerce.system.order.service.domain.usecase.CreateOrderUseCase;
import com.sethdevkh.ecommerce.system.order.service.restapi.dto.OrderCreateRequest;
import com.sethdevkh.ecommerce.system.order.service.restapi.dto.OrderCreateResponse;
import com.sethdevkh.ecommerce.system.order.service.restapi.mapper.OrderWebMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderCommandController {

    private final CreateOrderUseCase createOrderUseCase;
    private final OrderWebMapper orderWebMapper;

    /*public OrderCommandController(CreateOrderUseCase createOrderUseCase) {
        this.createOrderUseCase = createOrderUseCase;
    }*/

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public OrderCreateResponse createOrder(@Valid @RequestBody OrderCreateRequest request) {
        CreateOrderResult result = createOrderUseCase.execute(orderWebMapper.orderCreateRequestToCreateOrderCommand(request));
        OrderCreateResponse response = orderWebMapper.createOrderResultToOrderCreateResponse(result);

        return OrderCreateResponse.builder()
                .orderId(response.orderId())
                .build();
    }
}
