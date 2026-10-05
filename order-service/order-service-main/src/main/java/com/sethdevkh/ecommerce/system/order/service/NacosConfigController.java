package com.sethdevkh.ecommerce.system.order.service;

import com.alibaba.nacos.client.config.NacosConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Scope("prototype")
@RequiredArgsConstructor
public class NacosConfigController {

    private final NacosConfigProps nacosConfigProps;

//    @Value("${service.name}")
//    private String serviceName;

    @GetMapping
    public String nacosConfig() {
        return nacosConfigProps.getName();
    }
}
