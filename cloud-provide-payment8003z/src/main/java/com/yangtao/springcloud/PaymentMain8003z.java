package com.yangtao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author：杨涛
 * @create: 2021-04-12 17:59
 */

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class PaymentMain8003z {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8003z.class,args);
    }
}
