package com.yangtao.springcloud.service;

import com.yangtao.springcloud.pojo.Payment;

/**
 * @author：杨涛
 * @create: 2021-04-08 17:17
 */

public interface PaymentService {

    int add(Payment payment);
    Payment getById(Integer id);
}
