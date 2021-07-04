package com.lh.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @program: spring-annotation
 * @description:2.实现InitializingBean接口
 * @author: lh
 * @date: 2021-06-27 23:50
 **/
@Component
public class Cat implements InitializingBean, DisposableBean {

    public Cat(){
        System.out.println("cat construtor....");
    }

    public void destroy() throws Exception {
        System.out.println("cat destroy.....");
    }

    /**
     * 对象初始化完成，并赋值完成，开始调用
     * @throws Exception
     */
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat afterPropertiesSet...");
    }
}
