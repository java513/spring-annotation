package com.lh.config;

import com.lh.beans.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @program: spring-annotation
 * @description:
 * 构建（对象创建）
 *   单实例：在容器启动时创建对象
 *   多实例：在每次获取多时候创建对象
 * 初始化
 *    对象创建完成，并赋值好，调用初始化方法
 * 销毁
 *    单实例：容器关闭时
 *    多实例：容器不会管理这些bean
 * @author: lh
 * @date: 2021-06-27 23:31
 **/

/**
 * 1.指定初始化和销毁方法
 *     通过@Bean指定init-method和destroy-method
 * 2.通过让bean实现InitializingBean接口（定义初始化逻辑）
 *   通过让bean实现DisposableBean接口（定义销毁逻辑）
 * 3.可以使用JSR250
 *   @PostConstruct 在bean创建完成且属性赋值完成，执行初始化方法
 *   @PreDestroy 在容器销毁bean之前通知我们进行清理工作
 * 4.BeanPostProcessor接口，bean的后置处理器
 *   在bean初始化前后进行一些清理工作
 *   postProcessBeforeInitialization:在初始化之前工作
 *   postProcessAfterInitialization:在初始化之后工作
 *
 */
@Configuration
@ComponentScan("com.lh.beans")
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init",destroyMethod = "destroy")
   // @Scope("prototype")
    public Car car(){
        return new Car();
    }


}
