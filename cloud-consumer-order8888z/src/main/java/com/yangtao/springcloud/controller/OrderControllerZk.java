package com.yangtao.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @author：杨涛
 * @create: 2021-04-13 08:59
 */

@RestController
public class OrderControllerZk {
    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/z")
    public String paymentInfo(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/z",String.class);
    }
}
