package com.yangtao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author：杨涛
 * @create: 2021-04-19 09:29
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients //激活并开启feign
public class OrderFeignMain8888 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain8888.class,args);
    }
}
