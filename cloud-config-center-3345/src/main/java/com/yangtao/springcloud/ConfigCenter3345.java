package com.yangtao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author：杨涛
 * @create: 2021-04-21 12:24
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigCenter3345 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenter3345.class,args);
    }
}
