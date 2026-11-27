package com.sethdevkh.ecommerce.system.customer.service;

import com.sethdevkh.ecommerce.system.customer.service.client.UserCreateRequest;
import com.sethdevkh.ecommerce.system.customer.service.client.UserFeignClient;
import com.sethdevkh.ecommerce.system.customer.service.client.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final UserFeignClient userFeignClient;

    public String getCustomer(@RequestParam(required = false, defaultValue = "0") int page, @RequestParam(required = false, defaultValue = "25") int size) {

        return "Customer is created successfully";
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getCustomers(@PathVariable String id) {
        UserResponse user = userFeignClient.getById(id);

        System.out.println("================");
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public String createCustomer(@Valid @RequestBody CustomerCreateRequest customerCreateRequest){
        System.out.println("Customer Create Request: " + customerCreateRequest);
        UserCreateRequest request = UserCreateRequest.builder()
                .email(customerCreateRequest.email())
                .build();
        userFeignClient.create(request);
        return "user is created successfully";
    }

}
