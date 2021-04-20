package com.yangtao.springcloud.service;

import com.yangtao.springcloud.pojo.CommonResult;
import com.yangtao.springcloud.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author：杨涛
 * @create: 2021-04-19 09:31
 */

@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeignService {

    @RequestMapping("/getOne/{id}")
    CommonResult<Payment> getOne(@PathVariable("id") Integer id);
}
