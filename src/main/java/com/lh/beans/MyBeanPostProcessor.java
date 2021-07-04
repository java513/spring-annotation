package com.lh.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @program: spring-annotation
 * @description: 4.BeanPostProcessor接口，bean的后置处理器
 * @author: lh
 * @date: 2021-06-28 23:31
 **/
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization bean="+bean+",beanName"+beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization bean="+bean+",beanName"+beanName);
        return bean;
    }
}
