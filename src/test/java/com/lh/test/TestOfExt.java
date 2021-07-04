package com.lh.test;

import com.lh.ext.ExtConfig;
import com.lh.tx.TxConfig;
import com.lh.tx.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: spring-annotation
 * @description: aop测试类
 * @author: lh
 * @date: 2021-06-27 21:17
 **/
public class TestOfExt {

    @Test
    public void test() {
        //1。创建一个applicationContext
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExtConfig.class);
        context.publishEvent(new ApplicationEvent(new String("我发布了一个事件")) {
        });

        context.close();
    }
}
