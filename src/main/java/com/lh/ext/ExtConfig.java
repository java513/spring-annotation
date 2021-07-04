package com.lh.ext;

import com.lh.beans.Blue;
import com.lh.beans.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: spring-annotation
 * @description: 扩展原理
 *1。 BeanPostProcessor,Bean后置处理器，bean创建对象初始化前后进行拦截工作的
 *  BeanFactoryPostProcessor beanFactory的后置处理器
 *      在BeanFactory标准初始化之后调用，所有的bean定义已经保存加载到beanFactory，但是bean的实例还未创建
 *  BeanFactoryPostProcessor 原理
 *      1)ioc容器创建对象
 *      2）invokeBeanFactoryPostProcessor(beanFactory) 执行BeanFactoryProcessor
 *          如何找到所有的BeanFactoryPostProcessor的组件，并执行他们的方法
 *          1）直接在BeanFactory中找到所有类型是BeanFactoryPostProcessor的组件，并执行他们的方法
 *          2）在初始化创建其他组件前面执行
 *
 * 2.BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor
 *      postProcessBeanDefinitionRegistry(); 再所有的bean定义信息将要被加载，bean实例还未创建
 *      优先于BeanFactoryPostProcessor执行，
 *      利用BeanDefinitionRegistryPostProcessor给容器中再额外添加一些组件
 *   原理：
 *      1）ioc创建对象
 *      2）refresh（）-> invokeBeanFactoryPostProcessor(beanFactory)
 *      3)从容器中获取所有的BeanDefinitionRegistryPostProcessor组件
 *          1。依次粗发所有的postProcessBeanDefinitionRegister()方法
 *          2。再来触发postProcessBeanFactory()方法BeanFactoryPostProcessor
 *      4)再从容器中找到BeanFactoryPostProcessor组件，再次触发postProcessBeanFactory()方法
 * 3.ApplicationListener 监听容器中发布的事件，事件驱动模型开发
 *      监听ApplicationEvent 及其下面的子事件
 *
 *   步骤
 *      1)写一个监听器来监听某个事件（ApplicationEvent及其子类）
 *      2）把监听器加入容器
 *      3）只要容器中有相关事件的发布，我们就能监听到这个事件
 *              ContextRefreshedEvent 容器刷新完成（所有bean都完成创建）会发布这个事件
 *              ContextClosedEvent   关闭容器会发布这个事件
 *       4）发布一个事件
 *
 * @author: lh
 * @date: 2021-07-03 18:29
 **/
@Configuration
@ComponentScan("com.lh.ext")
public class ExtConfig {
    @Bean
    public Dog dog(){
        return new Dog();
    }
}
