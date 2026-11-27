package com.sethdevkh.ecommerce.system.customer.service.client;

import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallback  implements UserFeignClient{

    @Override
    public UserResponse getById(String id) {
        System.out.println("User Feign Client Fallback User Id: " + id);
        throw new UserServiceUnavailableException("User service is unavailable");
    }

    @Override
    public UserResponse create(UserCreateRequest userCreateRequest) {
        System.out.println("User Feign Client Fallback User Create Request: " + userCreateRequest);
        return null;
    }
}
