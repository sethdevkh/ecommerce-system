package com.sethdevkh.ecommerce.system.user.service.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Setter
@Getter
@Table(name = "users")
@Entity
public class UserEntity {
    @Id
    private String id;

    @Column(unique = true, nullable = false)
    private String username;
    private String gender;
    private Date birthDate;

    @Column(unique = true)
    private String mobilePhone;
    private String address;
}
