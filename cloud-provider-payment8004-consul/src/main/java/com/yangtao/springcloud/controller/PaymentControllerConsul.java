package com.yangtao.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author：杨涛
 * @create: 2021-04-13 09:37
 */
@RestController
public class PaymentControllerConsul {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/consul")
    public String paymentZ(){
        return "spring-cloud with consul："+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
