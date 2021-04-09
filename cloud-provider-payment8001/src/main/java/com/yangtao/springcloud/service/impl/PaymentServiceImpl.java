package com.yangtao.springcloud.service.impl;

import com.yangtao.springcloud.mapper.PaymentMapper;
import com.yangtao.springcloud.pojo.Payment;
import com.yangtao.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author：杨涛
 * @create: 2021-04-08 17:17
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper mapper;


    @Override
    public int add(Payment payment) {
        return mapper.add(payment);
    }

    @Override
    public Payment getById(Integer id) {
        return mapper.getById(id);
    }
}
