package com.lh.config;

import com.lh.beans.Yellow;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.javafx.binding.StringFormatter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @program: spring-annotation
 * @description: Profile,Spring为我们提供的可以根据当前环境，动态激活和切换一系列组件的功能
 *         开发环境，测试环境，生产环境
 *         @Profile 指定组件在哪个环境的条件下才能被注册到容器中，不指定，任何环境都能注册
 *         1）加了环境标识的bean，只有在这个环境被激活的时候才能注册到容器中，默认是default
 *
 * @author: lh
 * @date: 2021-06-30 23:51
 **/
@Configuration
@PropertySource("classpath:db.properties")
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

    private StringValueResolver resolver;

    private String driverClass;

    @Value("${db.user}")
    private String user;

    @Profile("test")
    @Bean
    public Yellow yellow(){
        return new Yellow();
    }

    @Profile("dev")
    @Bean("devDatasource")
    public DataSource dataSourceDev(@Value("${db.password")String password) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setDataSourceName("jdbc:mysql://localhost:3306/dev");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }
    @Profile("test")
    @Bean("testDatasource")
    public DataSource dataSourceTest(@Value("${db.password")String password) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setDataSourceName("jdbc:mysql://localhost:3306/test");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }
    @Profile("prd")
    @Bean("prdDatasource")
    public DataSource dataSourcePrd(@Value("${db.password")String password) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setDataSourceName("jdbc:mysql://localhost:3306/prd");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        this.resolver = stringValueResolver;
        driverClass = stringValueResolver.resolveStringValue("${db.driverClass}");
    }
}
