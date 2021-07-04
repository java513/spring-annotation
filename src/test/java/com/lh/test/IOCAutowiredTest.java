package com.lh.test;

import com.lh.config.MainConfigOfAutowired;
import com.lh.dao.BookDao;
import com.lh.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: spring-annotation
 * @description:
 * @author: lh
 * @date: 2021-06-29 23:08
 **/
public class IOCAutowiredTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        BookService bookService = context.getBean(BookService.class);
        System.out.println(bookService);
        BookDao bookDao = context.getBean(BookDao.class);
        System.out.println(bookDao);
        context.close();
    }
}
