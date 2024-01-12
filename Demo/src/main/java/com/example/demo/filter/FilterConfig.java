package com.example.demo.filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * 配置过滤器
 */
@Configuration
public class FilterConfig {
    /**
     * 过滤路径
     */
    private static final String[] URLS = new String[]{"/test/filter", "/test/all"};

    @Bean("myFilter1")
    public FilterRegistrationBean<Filter> myFilter1() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>(new MyFilter1());
        // 配置要应用过滤器的路径，若存在多个则传入 String[]
        registrationBean.addUrlPatterns(URLS);
        // 设置执行顺序，数值越小，越先执行，服务器返回客户端时则相反
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean("myFilter2")
    public FilterRegistrationBean<Filter> myFilter2() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>(new MyFilter2());
        registrationBean.addUrlPatterns(URLS);
        registrationBean.setOrder(2);
        return registrationBean;
    }

}
