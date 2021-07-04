package com.lh.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @program: spring-annotation
 * @description: 切面类
 * @author: lh
 * @date: 2021-07-02 00:00
 **/
@Aspect
public class LogAspects {
    //抽取公共的切入点表达式
    //1。本类引用 point()
    //2。其他的切面引用  point(全类名)
    @Pointcut("execution(public int com.lh.aop.MathCalculator.*(..))")
    public void pointCut(){

    }
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+"运行。。。。参数列表是：{"+ Arrays.asList(args) +"}");
    }
    @After("com.lh.aop.LogAspects.pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"结束。。。。");
    }
    //joinPoint一定要在参数表的第一列
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){

        System.out.println(joinPoint.getSignature().getName()+"正常返回。。。运行结束：{"+result+"}");
    }
    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){
        System.out.println(joinPoint.getSignature().getName()+"异常。。。。异常信息：{"+exception+"}");
    }
}
