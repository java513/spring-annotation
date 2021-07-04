package com.lh.ext;

import com.lh.beans.Dog;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

/**
 * @program: spring-annotation
 * @description:
 * @author: lh
 * @date: 2021-07-03 18:57
 **/
@Component
public class MyBeanDefinitionRegisterPostProcessor implements BeanDefinitionRegistryPostProcessor {

    //BeanDefinitionRegistry Bean定义信息的保存中心，以后BeanFactory就是按照BeanDefinitionRegistry创建对象
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("postProcessBeanDefinitionRegistry..bean的数量"+registry.getBeanDefinitionCount());
        //RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Dog.class);
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Dog.class).getBeanDefinition();
        registry.registerBeanDefinition("hello",beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory..bean的数据"+beanFactory.getBeanDefinitionCount());
    }
}
