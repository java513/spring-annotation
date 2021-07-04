package com.lh.test;

import com.lh.beans.Person;
import com.lh.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring-annotation
 * @description: 测试类
 * @author: lh
 * @date: 2021-06-27 17:15
 **/
public class MainTest {
    public static void main(String[] args) {
        //1.配置文件加载bean的方式
        /*ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person);*/
        //2.注解加载bean的方式
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = context.getBean(Person.class);
        System.out.println(bean);
        //2.1默认name是方法名，除非指定name或者value
        String[] names = context.getBeanNamesForType(Person.class);
        for (String name : names) {
            System.out.println(name);
        }
    }
}
