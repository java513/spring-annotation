package com.lh.beans;

import org.springframework.beans.factory.annotation.Value;

/**
 * @program: spring-annotation
 * @description: 实体类
 * @author: lh
 * @date: 2021-06-27 17:01
 **/
public class Person {

    //@value赋值
    //1。基本数值
    //2。使用SpEL,#{}
    //3.可以写${},读取配置文件中的值（在运行环境变量里的值）
    @Value("张三")
    private String name;
    @Value("#{20-2}")
    private int age;
    @Value("${person.nickname}")
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
