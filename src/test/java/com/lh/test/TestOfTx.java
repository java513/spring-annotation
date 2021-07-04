package com.lh.test;

import com.lh.aop.MathCalculator;
import com.lh.config.MainConfigOfAOP;
import com.lh.tx.TxConfig;
import com.lh.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: spring-annotation
 * @description: aop测试类
 * @author: lh
 * @date: 2021-06-27 21:17
 **/
public class TestOfTx {

    @Test
    public void test() {
        //1。创建一个applicationContext
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);

        UserService service = context.getBean(UserService.class);
        service.insert();
    }
}
