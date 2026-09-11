//package com.sethdevkh.ecommerce.system.order.service.persistence.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.math.BigDecimal;
//import java.util.UUID;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@Entity
//@Table(name = "products")
//public class ProductEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID id;
//
//    private String name;
//    private BigDecimal price;
//
//    @OneToOne(mappedBy = "product")
//    private OrderItemEntity orderItem;
//}
