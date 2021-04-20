package com.yangtao.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author：杨涛
 * @create: 2021-04-19 10:56
 */
@Service
public class PaymentService {

    public String paymentInfoOk(Integer id){
        return "线程池："+Thread.currentThread().getName()+"\t"+"paymentInfo_ok";
    }


    @HystrixCommand(fallbackMethod ="payment_timeOutHandle",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")  //设置正常业务逻辑等待时间
    })
    public String paymentInfoTimeOut(Integer id){
        try{
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"\t"+"paymentInfo---TimeOut";
    }

    public String payment_timeOutHandle(Integer id){
        return "友好提示页面";
    }
}
