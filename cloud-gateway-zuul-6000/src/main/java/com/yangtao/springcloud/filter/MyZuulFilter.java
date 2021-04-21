package com.yangtao.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @author yangtao
 */
//@Component
public class MyZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        String type = FilterConstants.PRE_TYPE;
        System.out.println("过滤类型.....："+type);

        return type;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        // return false : 不会请求到controller
        System.out.println("放你一马.....");
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("假装这里有控制逻辑....");
        return "烧饼....";
    }
}
