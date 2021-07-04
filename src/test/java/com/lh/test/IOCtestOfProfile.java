package com.lh.test;

import com.lh.beans.Person;
import com.lh.config.MainConfig2;
import com.lh.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @program: spring-annotation
 * @description: 测试类
 * @author: lh
 * @date: 2021-06-27 21:17
 **/
public class IOCtestOfProfile {
    //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);

    //1.使用命令行动态参数：在虚拟机参数位置加载 -Dspring.profiles.active=test
    //2.代码的方式激活某个环境
    @Test
    public void test() {
        //1。创建一个applicationContext
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //2.设置需要激活的环境
        context.getEnvironment().setActiveProfiles("dev");
        //3。注册主配置类
        context.register(MainConfigOfProfile.class);
        //4。启动容器刷新
        context.refresh();
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
