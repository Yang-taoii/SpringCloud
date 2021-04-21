package com.yangtao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author：杨涛
 * @create: 2021-04-21 16:00
 *
 * 启动 7001 6000 8001 8002 8888
 *      访问地址 ： http://127.0.0.1:6000/provider/payment/getOne/1
 *                 http://localhost:6000/consumer/consumer/payment/getOne/2
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulMain6000 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulMain6000.class, args);
    }
}
