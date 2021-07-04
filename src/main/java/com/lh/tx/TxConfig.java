package com.lh.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @program: spring-annotation
 * @description: 声明式事物
 *  环境搭建
 *  1，导入相关依赖
 *      数据源，数据库驱动，Spring-jdbc模块
 *  2。配置数据源 JdbcTemplate（Spring提供的简化数据库操作工具）操作数据
 *  3.给方法标注@Transcational 表示当前方法是一个事物方法
 *  4.@EnableTransactionManagement 开启基于注解对事物管理功能
 *  5。配置事物管理器 PlatformTransactionManager
 *
 *  原理
 *  1）EnableTransactionManagement
 *      利用TransactionManagementConfigurationSelector给容器中导入组件
 *      导入2个组件
 *      AutoProxyRegistrar
 *      ProxyTransactionManagementConfiguration
 *  2) AutoProxyRegistrar
 *      给容器中注册一个InfrastructureAdvisorAutoProxyCreator组件
 *      InfrastructureAdvisorAutoProxyCreator ？
 *      利用后置处理器机制在对象创建以后，包装对象，返回一个代理对象（增强器），代理对象执行方法利用拦截器链进行处理
 *  3）ProxyTransactionManagementConfiguration
 *     1。给容器中注册事物增强器
 *        1）事物增强器要用事物注解的信息 AnnotationTransactionAttributeSource解析事物
 *        2）事物拦截器
 *              TransactionInterceptor 保存了事物属性信息，事物管理器
 *              他是一个MethodInterceptor
 *              在目标方法执行的时候
 *                  执行拦截器
 *                  事物拦截器
 *                      1）先获取事物相关的属性
 *                      2）再获取PlatformTransactionManager，如果事先没有添加指定任何transactionManager
 *                        最终会从容器中按照类型获取一个PlatformTransactionManager
 *                      3）执行目标方法
 *                          如果异常，获取到事物管理器，利用事物管理回滚操作
 *                          如果正常，获取到事物管理器，利用事物管理器提交操作
 * @author: lh
 * @date: 2021-07-03 16:57
 **/
@Configuration
@ComponentScan("com.lh.tx")
@EnableTransactionManagement
public class TxConfig {
    @Bean
    public DataSource dataSource()throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws Exception{
        //Spring对@Configuration类会特殊处理，给容器中加组件对方法，多次调用都只是从容器中找组件
        return new JdbcTemplate(dataSource());
    }

    //注册事物管理器到容器中
    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(dataSource());
    }
}
