package com.lh.beans;

/**
 * @program: spring-annotation
 * @description:1.@Bean指定init-method和destroy-method
 * @author: lh
 * @date: 2021-06-27 23:31
 **/
public class Car {

    public Car(){
        System.out.println("car construtor..");
    }

    public void init(){
        System.out.println("Car init.....");
    }

    public void destroy(){
        System.out.println("car destroy...");
    }
}
