package com.lh.beans;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @program: spring-annotation
 * @description: Mac
 * @author: lh
 * @date: 2021-06-27 22:31
 **/
public class MacCondition implements Condition {
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();
        String os = environment.getProperty("os.name");
        if(os.contains("Mac")){
            return true;
        }
        return false;
    }
}
