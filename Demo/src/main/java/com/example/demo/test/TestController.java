package com.example.demo.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/filter")
    public String testFilter() {
        System.out.println("===执行 controller===");
        System.out.println("===调用 service 进行业务处理===");
        System.out.println("===执行 return===");
        return "测试过滤器~";
    }

    @GetMapping("/interceptor")
    public String testInterceptor() {
        System.out.println("===执行 controller===");
        System.out.println("===调用 service 进行业务处理===");
        System.out.println("===执行 return===");
        return "测试拦截器~";
    }

    @GetMapping("/all")
    public String testAll() {
        System.out.println("===执行 controller===");
        System.out.println("===调用 service 进行业务处理===");
        System.out.println("===执行 return===");
        return "测试过滤器and拦截器~";
    }

}
