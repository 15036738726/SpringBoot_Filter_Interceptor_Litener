package com.example.demo.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 自定义事件监听器
 */
@Component
public class MyListener implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        // 监听到相应事件后的处理逻辑
        User user = myEvent.getUser();
        System.out.println("监听到事件发生>>> User 对象创建");
        System.out.println("username>>>  " + user.getUsername());
        System.out.println("password>>>  " + user.getPassword());
    }
}
