package com.sethdevkh.ecommerce.system.order.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {
        "com.sethdevkh.ecommerce.system.order.service.persistence.entity"
})
@EnableJpaRepositories(basePackages = {
        "com.sethdevkh.ecommerce.system.order.service.persistence.repository"
})
@SpringBootApplication
public class OrderServiceApplication {
    static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
