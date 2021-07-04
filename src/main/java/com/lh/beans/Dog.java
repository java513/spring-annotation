package com.lh.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @program: spring-annotation
 * @description: 3.JSR250
 * @author: lh
 * @date: 2021-06-28 23:11
 **/
@Component
public class Dog {
    public Dog(){
        System.out.println("Dog construct.........");
    }

    @PostConstruct
    public void init(){
        System.out.println("Dog PostConstruct......");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Dog PreDestroy.....");
    }
}
