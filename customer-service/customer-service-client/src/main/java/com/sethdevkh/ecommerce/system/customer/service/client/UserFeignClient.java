package com.sethdevkh.ecommerce.system.customer.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "users-service", path = "/api/users", fallback = UserFeignClientFallback.class )
public interface UserFeignClient {

    @GetMapping("/{id}")
    UserResponse getById(@PathVariable String id);

    @PostMapping
    UserResponse create( @RequestBody UserCreateRequest userCreateRequest);

}
