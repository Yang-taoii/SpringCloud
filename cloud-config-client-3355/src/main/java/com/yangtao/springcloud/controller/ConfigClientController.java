package com.yangtao.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：杨涛
 * @create: 2021-04-21 14:02
 *  config客户端
 *      完成客户端3355 对 服务端3345配置信息的读取 （github远程配置文件 application-dev.yml）
 *      //@RefreshScope 发送post请求 手动刷新
 *          curl -X POST "http://localhost:3355/actuator/refresh"
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;
    @Value("${config.version}")
    private String version;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo+"---"+version;
    }
}
