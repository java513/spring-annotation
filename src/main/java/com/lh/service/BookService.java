package com.lh.service;

import com.lh.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @program: spring-annotation
 * @description: 测试类
 * @author: lh
 * @date: 2021-06-27 21:15
 **/
@Service
public class BookService {
    @Qualifier("bookDao2")
    @Autowired(required = false)
    //@Resource
    //@Inject
    private BookDao bookDao;

    public void print(){
        System.out.println(bookDao);
    }

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao+
                '}';
    }
}
