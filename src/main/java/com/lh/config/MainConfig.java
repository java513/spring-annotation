package com.lh.config;

import com.lh.beans.Person;
import org.springframework.context.annotation.*;

/**
 * @program: spring-annotation
 * @description: 注解配置类
 * @author: lh
 * @date: 2021-06-27 17:17
 **/
@Configuration
//@ComponentScan(value = "com.lh") //注解包扫描
@ComponentScans(value = {@ComponentScan(value = "com.lh",includeFilters = {
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = MyFilter.class)
},useDefaultFilters = false)})
public class MainConfig {

    @Bean(value = "person")
    public Person person01(){
        return new Person("zs",19);
    }
}
