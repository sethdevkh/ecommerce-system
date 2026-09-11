package com.sethdevkh.ecommerce.system.order.service.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {
        "com.sethdevkh.ecommerce.system.order.service.persistence"
})
@EnableJpaRepositories(basePackages = {
        "com.sethdevkh.ecommerce.system.order.service.persistence"
})
public class OrderServiceApplication {
    static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
