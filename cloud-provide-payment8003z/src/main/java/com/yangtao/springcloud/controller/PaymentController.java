package com.yangtao.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author：杨涛
 * @create: 2021-04-12 19:10
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/z")
    public String paymentZ(){
        return "spring-cloud with zookeeper："+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
