package com.yangtao.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yangtao
 */
//@Component
public class TokenFilter  extends ZuulFilter {
    @Override
    public String filterType() {
        String preType = FilterConstants.PRE_TYPE;
        System.out.println("过滤器的类型："+preType);
        return preType;
    }

    @Override
    public int filterOrder() {
        // 正整数  数字越小，优先级越高
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        //return true:放行往下走 run,false 不执行run方法
        System.out.println("TokenFilter的shouldFilter");
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //编写过滤代码
        RequestContext ctx= RequestContext.getCurrentContext();
        //获取请求
        HttpServletRequest request = ctx.getRequest();
        //获取访问信息
        String requestURI = request.getRequestURI();
        //请求token
        String token = request.getHeader("token");

        System.out.println("uri:"+requestURI+"::token:"+token);
        //放行基本页面 login
        if(requestURI.contains("clogin")||requestURI.contains("login")){
            ctx.setSendZuulResponse(true);
            System.out.println("你是登录放你过去");
            return "sb";
        }

        //从redis取出token
        if(token==null||token.isEmpty()){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.getResponse().setContentType("text/html;charset=utf-8");
            String mess="{\"mess\":\"no token，no pass ,没有token\"}";
            ctx.setResponseBody(mess);
            return "no";
        }else{
            ctx.setSendZuulResponse(true);
            System.out.println("token不为空放行");
        }


        return "success";
    }
}
