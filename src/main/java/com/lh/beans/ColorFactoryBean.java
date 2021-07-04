package com.lh.beans;

import org.springframework.beans.factory.FactoryBean;

/**
 * @program: spring-annotation
 * @description: 工厂bean
 * @author: lh
 * @date: 2021-06-27 23:15
 **/
public class ColorFactoryBean implements FactoryBean<Color> {


    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean..getObject..");
        return new Color();
    }

    public Class<?> getObjectType() {
        return null;
    }

    public boolean isSingleton() {
        return true;
    }
}
