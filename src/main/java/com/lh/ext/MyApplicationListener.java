package com.lh.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @program: spring-annotation
 * @description:
 * @author: lh
 * @date: 2021-07-03 19:25
 **/
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {
    //当容器中发布此事件后，方法触发
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("收到事件。。。。"+applicationEvent);
    }
}
