package com.handler;

import com.alibaba.fastjson.JSON;
import com.utils.Result;
import com.utils.UserThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * 在执行controller方法(handler)之前进行执行
         * 1.需要判断请求的接口路径，是否为handlermethod(controller)的方法
         * 2.判断token是否为空，如果为空，未登录。
         * 3.如果token不为空，登录验明证
         */
        if (!(handler instanceof HandlerMethod)) {
            //handler可能是RequestResourceHandler
            return true;
        }
        String token = request.getHeader("Authorization");
        if (token == null) {
            Result result = Result.fail(300, "未登录");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        return true;

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserThreadLocal.remove();
    }
}
