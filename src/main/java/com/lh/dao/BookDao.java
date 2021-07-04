package com.lh.dao;

import org.springframework.stereotype.Repository;

/**
 * @program: spring-annotation
 * @description: 测试类
 * @author: lh
 * @date: 2021-06-27 21:16
 **/
//名字默认类名首字母小写
@Repository
public class BookDao {
    private String label="1";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "label='" + label + '\'' +
                '}';
    }
}
