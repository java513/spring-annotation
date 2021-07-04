package com.lh.config;

import com.lh.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @program: spring-annotation
 * @description: 自动装配 spring依赖自动注入（DI）,完成对IOC容器中各个组件的依赖关系赋值
 *               1。autowird 自动注入
 *                1）默认优先按照类型去容器中找对应的组件
 *                2）如果找到多个类型相同的组件，再将属性的名称作为组件的ID去容器中查找
 *                3)使用@Qualifier指定需要装配的组件ID，而不是使用属性名
 *                4）自动转配一定要将熟悉赋值好，没有就会报错
 *                  可以使用autowired（required=false）
 *                5)@Primary.让Spring进行自动转配时，默认使用首选的bean，
 *                也可以继续使用@Qualifier指定需要转配的bean的名字
 *               2.Spring还支持使用@Resource（JSR520）和Inject（JSR220），java规范的注解
 *                 @Resource 可以和@Autowired一样实现自动转配，默认是按组件名称转配，没有能支持@Primary功能，没有支持@Autowird（required=false）
 *                 @Inject 和@Autowired功能一样，没有required=false的功能
 *               3.@Autowired:构造器，参数，方法，属性，都是从容器中获取组件的值
 *                 1）标注在方法位置，@Bean+方法参数，参数从容器获取，默认不加Autowired
 *                 2）标在构造器上，如果组件只有一个有参构造器，这个构造器的Autowired可以省略，参数位置的组件还是从容器中获取
 *                 3）放在参数位置
 *               4，自定义组件想使用Spring容器底层一些组件（ApplicationContext，BeanFactory,xxx);
 *                    自定义组件实现xxxAware,在创建对象的时候，会调用接口相关的方法注入组件；Aware把Spring底层一些组件注入到自定义Bean中
 * @author: lh
 * @date: 2021-06-29 22:56
 **/
@Configuration
@ComponentScan({"com.lh.service","com.lh.controller","com.lh.dao"})
public class MainConfigOfAutowired {

    @Bean("bookDao2")
    @Primary
    public BookDao bookDao(){
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }
}

