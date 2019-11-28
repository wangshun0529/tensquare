package com.tensquare.friend.interceptor;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @Author wangshun
 * @create: 2019-11-28 15:59
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authHeader = request.getHeader("Authorization");
        if(authHeader!=null && authHeader.startsWith("Bearer ") ){
            String token = authHeader.substring(7);
            try {
                Claims claims = jwtUtil.parseJWT(token);
                if(claims!=null){
                    if("admin".equals( claims.get("roles") )){
                        request.setAttribute("admin_claims",claims);
                    }
                    if("user".equals( claims.get("roles") )){
                        request.setAttribute("user_claims",claims);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("令牌不正确");
            }
        }
        return true;
    }
}
