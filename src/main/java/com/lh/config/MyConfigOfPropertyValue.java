package com.lh.config;

import com.lh.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @program: spring-annotation
 * @description:
 * @author: lh
 * @date: 2021-06-28 23:55
 **/
@Configuration
@PropertySource(value = {"classpath:person.properties"})
public class MyConfigOfPropertyValue {

    @Bean
    public Person person(){
        return new Person();
    }
}
