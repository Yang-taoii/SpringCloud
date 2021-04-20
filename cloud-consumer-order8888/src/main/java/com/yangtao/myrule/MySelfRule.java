package com.yangtao.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author：杨涛
 * @create: 2021-04-19 08:45
 * 配置自己的负载均衡策略为随机
 */
@Configuration
public class MySelfRule {
 @Bean
 public IRule myRule(){
     return new RandomRule();
 }
}
