package com.lh.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @program: spring-annotation
 * @description:
 * @author: lh
 * @date: 2021-07-04 10:27
 **/
@Service
public class UserService {
    @EventListener(classes = {ApplicationEvent.class})
    public void listen(ApplicationEvent event){
        System.out.println("UserService监听到事件。。。。"+event);
    }
}
