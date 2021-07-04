package com.lh.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

/**
 * @program: spring-annotation
 * @description: 红色
 * @author: lh
 * @date: 2021-06-27 22:52
 **/
public class Red implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
    private ApplicationContext context;
    @Override
    public void setBeanName(String name) {
        System.out.println("当前bean的名字"+name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("传入的ioc："+applicationContext);
        this.context = applicationContext;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String stringValue = resolver.resolveStringValue("你好${os.name},我是#{20-2}");
        System.out.println("解析的字符串："+stringValue);
    }
}
