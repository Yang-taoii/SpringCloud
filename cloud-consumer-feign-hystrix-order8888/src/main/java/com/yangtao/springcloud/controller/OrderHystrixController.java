package com.yangtao.springcloud.controller;

import com.yangtao.springcloud.service.PaymentHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author：杨涛
 * @create: 2021-04-19 14:30
 */
@RestController
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService service;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){
        return service.payment_ok(id);
    }


    @GetMapping("/consumer/payment/hystrix/timeOut/{id}")
    public String payment_timeOut(@PathVariable("id") Integer id){
        return service.payment_timeOut(id);
    }

}
