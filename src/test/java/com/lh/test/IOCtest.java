package com.lh.test;

import com.lh.beans.Person;
import com.lh.config.MainConfig;
import com.lh.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * @program: spring-annotation
 * @description: 测试类
 * @author: lh
 * @date: 2021-06-27 21:17
 **/
public class IOCtest {
    ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
    @Test
    public void test01(){

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

    @Test
    public void test02(){
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
        /*Object person = context.getBean("person");
        Object person2 = context.getBean("person");
        System.out.println(person==person2);*/
    }

    @Test
    public void test03(){
        String[] namesForType = context.getBeanNamesForType(Person.class);
        for (String name : namesForType) {
            System.out.println(name);
        }

        Map<String, Person> config2Map = context.getBeansOfType(Person.class);
        System.out.println(config2Map);

        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
    }

    /**
     * 测试 @Import注解
     * com.lh.beans.Blue 默认是全类名
     */
    @Test
    public void test04(){
        printBeans(context);
    }

    private void printBeans(ApplicationContext context){
        String[] definitionNames = context.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }

    @Test
    public void test05(){
        Object bean = context.getBean("colorFactoryBean");
        Object bean2 = context.getBean("colorFactoryBean");
        Object bean3 = context.getBean("&colorFactoryBean");
        System.out.println(bean==bean2);
        System.out.println(bean.getClass());
        System.out.println(bean3.getClass());
    }
}
