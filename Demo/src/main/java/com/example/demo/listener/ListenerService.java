package com.example.demo.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zqf
 */
@Service
public class ListenerService {

    @Resource
    private ApplicationContext applicationContext;

    /**
     * 定时任务模拟时间发生进行测试
     *
     * 10s 执行一次
     */
    @Scheduled(cron = "*/10 * * * * ?")
    public void testListenerEvent() {
        // 模拟事件发生
        System.out.println("模拟事件发生>>> User 对象创建");
        User user = User.builder()
                .username("test" + Math.random())
                .password("123@qq.com")
                .build();
        // 手动发布事件
        MyEvent myEvent = new MyEvent(this, user);
        applicationContext.publishEvent(myEvent);
    }

}

