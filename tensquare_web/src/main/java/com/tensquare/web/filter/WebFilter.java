package com.tensquare.web.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 网页zuul过滤器
 * @Author wangshun
 * @create: 2019-11-29 00:19
 */
@Component
public class WebFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //向header中添加鉴权令牌
        //得到request上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //得到request域
        HttpServletRequest request = currentContext.getRequest();
        //得到头信息
        String authorization = request.getHeader("Authorization");
        //判断是否有头信息
        if(authorization!=null && !"".equals(authorization)){
            //把头信息继续向下传
            currentContext.addZuulRequestHeader("Authorization", authorization);
        }
        return null;
    }
}
