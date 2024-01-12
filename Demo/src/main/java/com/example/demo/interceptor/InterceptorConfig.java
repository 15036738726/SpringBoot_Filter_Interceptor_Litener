package com.example.demo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置拦截器
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截路径
        String[] urls = new String[]{"/test/interceptor", "/test/all"};
        // 配置自定义的拦截器，配置路径以及顺序
        registry.addInterceptor(new MyInterceptor1()).addPathPatterns(urls).order(1);
        registry.addInterceptor(new MyInterceptor2()).addPathPatterns(urls).order(2);
    }
}
