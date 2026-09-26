package com.sethdevkh.ecommerce.system.order.service;

import com.sethdevkh.ecommerce.system.order.service.domain.service.OrderDomainService;
import com.sethdevkh.ecommerce.system.order.service.domain.service.OrderDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* How to configure bean in java:
* 1. Annotation based
* 2. Java based (method)
* */
@Configuration
public class BeanConfig {

    @Bean
    public OrderDomainService orderDomainService() {
        return new OrderDomainServiceImpl();
    }
}
