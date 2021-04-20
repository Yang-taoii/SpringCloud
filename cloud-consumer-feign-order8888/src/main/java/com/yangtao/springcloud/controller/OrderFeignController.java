package com.yangtao.springcloud.controller;


import com.yangtao.springcloud.pojo.CommonResult;
import com.yangtao.springcloud.pojo.Payment;
import com.yangtao.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author：杨涛
 * @create: 2021-04-19 09:36
 */
@RestController
public class OrderFeignController {

    @Resource
    PaymentFeignService service;

    @GetMapping("/consumer/payment/getOne/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Integer id){
        return service.getOne(id);
    }
}
