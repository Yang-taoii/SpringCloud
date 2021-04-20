package com.yangtao.springcloud.controller;

import com.yangtao.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author：杨涛
 * @create: 2021-04-19 11:04
 */

@RestController
public class PaymentController {
    @Resource
    private PaymentService service;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){
        String result = service.paymentInfoOk(id)+"--"+serverPort;
        return result;
    }

    @GetMapping("/payment/hystrix/timeOut/{id}")
    public String payment_timeOut(@PathVariable("id") Integer id){
        String result = service.paymentInfoTimeOut(id)+"--"+serverPort;
        return result;
    }
}
