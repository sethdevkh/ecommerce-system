package com.sethdevkh.ecommerce.system.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "test";
    }
}
