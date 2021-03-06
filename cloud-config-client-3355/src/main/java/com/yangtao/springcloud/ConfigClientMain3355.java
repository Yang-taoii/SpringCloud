package com.yangtao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author：杨涛
 * @create: 2021-04-21 14:00
 * 定点通知： 只需要通知 3355
 *      curl -X POST "http://localhost:3345/actuator/bus-refresh/config-client:3355"
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3355.class,args);
    }
}
