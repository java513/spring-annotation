package com.lh.config;

import com.lh.beans.*;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.*;

/**
 * @program: spring-annotation
 * @description: 注解配置类
 * @author: lh
 * @date: 2021-06-27 17:17
 **/
@Configuration
@Import({Blue.class,Red.class,MyImportSelect.class})
public class MainConfig2 {

    /**
     * prototype 多实例
     * sington 单实例 默认
     * @return
     */
    @Bean(name = "person")
   // @Scope(value = "prototype" )
 //   @Lazy
    public Person person(){
        System.out.println("给容器中添加person");
        return new Person("zs",19);
    }

    @Bean(name = "bill")
   // @Conditional(WindowsCondition.class)
    public Person person01(){
        return new Person("Bill Gates",26);
    }

    @Bean(name = "linus")
   // @Conditional(LinuxCondition.class)
    public Person person02(){
        return new Person("linus",27);
    }

    @Bean(name = "jobs")
   // @Conditional(MacCondition.class)
    public Person person03(){
        return new Person("Jobs",27);
    }

    /**
     * 给容器中注册组件
     * 1。包扫描+组件标注注解
     * 2。@bean（导入第三方包里的组件）
     * 3。@Import（快速给容器中导入一个组件）
     * 4.使用Spring提供的factoryBean
     */

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }

}
