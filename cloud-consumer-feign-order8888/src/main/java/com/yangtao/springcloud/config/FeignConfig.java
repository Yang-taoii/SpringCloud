package com.yangtao.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author：杨涛
 * @create: 2021-04-19 10:11
 * Feign 打印日志需要的配置类
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level FeignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
