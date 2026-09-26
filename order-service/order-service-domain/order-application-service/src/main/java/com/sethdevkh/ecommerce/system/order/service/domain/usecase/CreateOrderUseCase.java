package com.sethdevkh.ecommerce.system.order.service.domain.usecase;

import com.sethdevkh.ecommerce.system.domain.valueobject.BusinessId;
import com.sethdevkh.ecommerce.system.domain.valueobject.Money;
import com.sethdevkh.ecommerce.system.domain.valueobject.ProductId;
import com.sethdevkh.ecommerce.system.order.service.domain.dto.CreateOrderCommand;
import com.sethdevkh.ecommerce.system.order.service.domain.dto.CreateOrderResult;
import com.sethdevkh.ecommerce.system.order.service.domain.entity.Business;
import com.sethdevkh.ecommerce.system.order.service.domain.entity.Order;
import com.sethdevkh.ecommerce.system.order.service.domain.entity.Product;
import com.sethdevkh.ecommerce.system.order.service.domain.event.OrderCreatedEvent;
import com.sethdevkh.ecommerce.system.order.service.domain.exception.OrderDomainException;
import com.sethdevkh.ecommerce.system.order.service.domain.mapper.OrderDomainMapper;
import com.sethdevkh.ecommerce.system.order.service.domain.port.output.BusinessRepository;
import com.sethdevkh.ecommerce.system.order.service.domain.port.output.CustomerRepository;
import com.sethdevkh.ecommerce.system.order.service.domain.port.output.OrderRepository;
import com.sethdevkh.ecommerce.system.order.service.domain.service.OrderDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class CreateOrderUseCase {

    private final OrderDomainService orderDomainService;
    private final OrderDomainMapper orderDomainMapper;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final BusinessRepository businessRepository;

    public CreateOrderResult execute(CreateOrderCommand createOrderCommand) {
        log.info("executing CreateOrderUseCase: {}", createOrderCommand);

        // Validate customer
        customerRepository.findCustomer(createOrderCommand.customerId())
                .orElseThrow(() -> new OrderDomainException("Could not find customer with ID: " + createOrderCommand.customerId()));

        // Validate business
        List<Product> products = createOrderCommand.items().stream()
                .map(commandOrderItem -> Product.builder()
                        .id(new ProductId(commandOrderItem.productId()))
                        .price(new Money(commandOrderItem.price()))
                        .build())
                .toList();

        Business business = Business.builder()
                .id(new BusinessId(createOrderCommand.businessId()))
                .products(products)
                .build();

        business = businessRepository.findBusiness(business)
                .orElseThrow(() -> new OrderDomainException("Could not find business with ID: " + createOrderCommand.businessId()));

        log.info("Found business: {}", business);

        // Invoke order domain logic
        Order order = orderDomainMapper.createOrderCommandToOrder(createOrderCommand);
        log.info("Order price: {}", order.getPrice().getAmount());
        OrderCreatedEvent orderCreatedEvent = orderDomainService.validateAndInitiateOrder(order, business);
        log.info("Order created event: {}", orderCreatedEvent.getOrder().getId());

        // Save order into database
        Order savedOrder = orderRepository.saveOrder(order);
        if (savedOrder == null) {
            throw  new OrderDomainException("Could not save order into database");
        }

        return new CreateOrderResult(savedOrder.getId().value());
    }

}
