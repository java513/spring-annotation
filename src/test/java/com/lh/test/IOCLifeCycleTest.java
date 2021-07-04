package com.lh.test;

import com.lh.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: spring-annotation
 * @description:
 * @author: lh
 * @date: 2021-06-27 23:34
 **/
public class IOCLifeCycleTest {

    @Test
    public void test(){
        //1.创建ioc容器
        AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成");
       /* context.getBean("car");*/
        //关闭容器
        context.close();
    }
}
