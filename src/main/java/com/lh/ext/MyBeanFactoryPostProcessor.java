package com.lh.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @program: spring-annotation
 * @description:
 * @author: lh
 * @date: 2021-07-03 18:34
 **/
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanFactoryPostProcessor...postProcessBeanFactory");
        int count = beanFactory.getBeanDefinitionCount();
        String[] definitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println("当前beanFactory中有"+count+"，个bean");
        System.out.println(Arrays.asList(definitionNames));

    }
}
