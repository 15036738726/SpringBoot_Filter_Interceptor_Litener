package com.example.demo.filter;
import javax.servlet.*;
import javax.servlet.FilterConfig;
import java.io.IOException;

/**
 * 自定义过滤器1
 */
public class MyFilter1 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 进入过滤器前处理逻辑
        System.out.println("===过滤器1前处理===");
        // 执行 doFilter() 方法
        filterChain.doFilter(servletRequest, servletResponse);
        // Controller 返回之后，客户端返回之前处理逻辑
        System.out.println("===过滤器1后处理===");
    }

}
