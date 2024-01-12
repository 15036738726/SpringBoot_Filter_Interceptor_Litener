package com.example.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器1
 */
public class MyInterceptor2 implements HandlerInterceptor {

    /**
     * 在 controller 执行之前进行拦截，返回结果将决定后续操作是否执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 编写拦截器逻辑
        System.out.println("===拦截器2前处理===");
        return true;
    }

    /**
     * 在执行完 controller 的方法后进行拦截，可对 model 和 view 进行修改
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("===拦截器2后处理===");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 在整个请求完成之后执行，即视图渲染之后执行，若返回 json 数据则不会执行此方法
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
