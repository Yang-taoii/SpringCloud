package com.yangtao.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author：杨涛
 * @create: 2021-04-09 09:08
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //使用注解赋予RestTemplate负载均衡能力 轮询
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
