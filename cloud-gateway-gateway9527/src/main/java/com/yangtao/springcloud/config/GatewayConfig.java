package com.yangtao.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author：杨涛
 * @create: 2021-04-20 11:07
 * 这个配置类对应yml文件配置的路由配置 routes:
 * 配置了一个路由规则
 *      当访问 http://localhost:9527/guonei时，
 *      会转发到地址 ： http://news.baidu.com/guonei
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator1(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        //配置路由名称  自定义  使用网关配置  百度链接
        routes.route("path_route_baidu1",
                r->r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator routeLocator2(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        //配置路由名称  自定义  使用网关配置  百度链接
        routes.route("path_route_baidu2",
                r->r.path("/guoji")
                        .uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }
}
