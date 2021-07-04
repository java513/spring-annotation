package com.lh.beans;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @program: spring-annotation
 * @description: ..
 * @author: lh
 * @date: 2021-06-27 22:24
 **/
public class WindowsCondition implements Condition {
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();
        String os = environment.getProperty("os.name");
        if(os.contains("Windows")){
            return true;
        }
        return false;
    }
}
