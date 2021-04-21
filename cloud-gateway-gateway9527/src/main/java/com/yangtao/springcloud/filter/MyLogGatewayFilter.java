package com.yangtao.springcloud.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author：杨涛
 * @create: 2021-04-21 10:48
 * 自定义全局过滤器
 *      geteway 自带单一过滤器以及全局过滤器
 */
@Component
public class MyLogGatewayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("******进入全局过滤器**********"+new Date());
        //请求地址必须带参数才能访问通过 http://localhost:9527/payment/getOne/3?username=123
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (username==null){
            System.out.println("用户名为空");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        //加载过滤器的顺序 越小优先级越高
        return 0;
    }
}
