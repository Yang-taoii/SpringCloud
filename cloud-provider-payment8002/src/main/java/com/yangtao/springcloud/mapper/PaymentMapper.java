package com.yangtao.springcloud.mapper;

import com.yangtao.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author：杨涛
 * @create: 2021-04-08 15:33
 */
@Mapper
@Repository
public interface PaymentMapper {

    int add(Payment payment);
    Payment getById(Integer id);
}
