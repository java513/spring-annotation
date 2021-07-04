package com.lh.test;

import com.lh.beans.Person;
import com.lh.config.MyConfigOfPropertyValue;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * @program: spring-annotation
 * @description:
 * @author: lh
 * @date: 2021-06-28 23:57
 **/
public class IOCPropertyValueTest {
    AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext(MyConfigOfPropertyValue.class);
    @Test
    public void test01() throws IOException {
        printBeans(context);
        Person person = (Person) context.getBean("person");
        System.out.println("person=="+person);
        ConfigurableEnvironment environment = context.getEnvironment();
        String nickname = environment.getProperty("person.nickname");
        System.out.println("nickname="+nickname);
        //-----------------------------------
        Properties properties = new Properties();
        InputStream inputStream = this.getClass().getResourceAsStream("/person.properties");
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        properties.load(br);
        System.out.println(properties.getProperty("person.nickname"));
        //-------------------------------------
        context.close();
    }

    private void printBeans(ApplicationContext context){
        String[] definitionNames = context.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }
}
