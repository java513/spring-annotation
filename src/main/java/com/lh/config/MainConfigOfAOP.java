package com.lh.config;

import com.lh.aop.LogAspects;
import com.lh.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @program: spring-annotation
 * @description: AOP:动态代理
 *                  指在程序运行期间动态的将某段代码切入到指定位置进行运行的编程方式
 *               1。导入aop模块，Spring AOP (spring-aspects)
 *               2.定义某个业务逻辑（MathCalculator）,在业务逻辑运行的时间将日志进行打印（方法之前，方法运行结束）
 *               3。定义一个日志切面（LogAspects），切面类里面的方法需要动态感知MathCalculator div运行到哪些，然后执行
 *                  通知方法：
 *                      前置通知：logStart:在目标方法div运行之前运行
 *                      后置通知：logEnd:在目标方法div运行结束运行(无论方法正常结束还是异常结束)
 *                      返回通知：logReturn:在目标方法div正常返回运行
 *                      异常通知：logException:在目标方法div运行出现异常运行
 *                      环绕通知：动态代理，手动推动目标方法运行（joinPoint.procced()）
 *                 4.给切面类的目标方法标注何时何地运行（通知注解）
 *                 5.将切面类和业务逻辑类（目标方法所在类）都加入容器中
 *                 6.必须告诉Spring哪个是切面类（给切面类加@Aspect注解）
 *                 7。给配置类加@EnableAspectJAutoProxy注解【开启基于注解的aop模式】
 *                    在Spring中很多
 *三步
 *  1）将业务逻辑组件和切面类都加入到容器中，告诉Spring哪个是切面类（@Aspect）
 *  2）将切面类上的每一个通知方法上标注通知注解，告诉Spring何时何地运行（切入点表达式）
 *  3）给配置类加@EnableAspectJAutoProxy【开启基于注解的aop模式】
 *
 *AOP原理
 *  @EnableAspectJAutoProxy
 *    @Import({AspectJAutoProxyRegistrar.class})，给容器中导入AspectJAutoProxyRegistrar
 *      利用AspectJAutoProxyRegistrar自定义给容器中注册bean
 *         internalAutoProxyCreator=AnnotationAwareAspectJAutoProxyCreator
 *      给容器中注册一个AnnotationAwareAspectJAutoProxyCreator
 *  AnnotationAwareAspectJAutoProxyCreator
 *    AbstractAdvisorAutoProxyCreator
 *       AbstractAutoProxyCreator
 *          ProxyProcessorSupport
 *流程
 *   1）传入配置类，创建IOC容器
 *   2）注册配置类，调用refresh（），刷新容器
 *   3）registerBeanPostProcessors(beanFactory)，注册bean的后置处理器来方便拦截bean的创建
 *         1）先获取ioc容器已经定义了的需要创建对象的所有BeanPostProcessor
 *         2) 容器中加别的BeanPostProcessor
 *         3）优先注册实现了PriorityOrdered接口的BeanPostProcessor
 *         4)再给容器中注册实现了Ordered接口的BeanPostProcessor
 *         5）注册没实现优先级接口的BeanPostProcessor
 *         6）注册BeanPostProcessor，实际上就是创建BeanPostProcessor对象，保存到容器中
 *             创建internalAutoProxyCreator的BeanPostProcessor【AnnotationAwareAspectJAutoProxyCreator】
 *             1）创建bean的实例
 *             2）populateBean，给bean的各种属性赋值
 *             3）initializeBean，初始化Bean
 *                   1）invokeAwareMethods,处理Aware接口的方法回调
 *                   2）applyBeanPostProcessorBeforeInitialization(),处理后置处理器的postProcessorBeforeInitialization()
 *                   3）invokeInitMethods() 执行自定义的初始化方法
 *                   4）applyBeanPostProcessorAfterInitialization(),执行后置处理器的postProcessorBeforeInitialization()
 *             4）BeanPostProcessor(AnnotationAwareAspectJAutoProxyCreator)创建成功
 *          7）把beanPostProcessor注册到BeanFactory中
 *             beanFactory.addBeanPostProcessor(postProcessor);
 * ========以上是创建和注册AnnotationAwareAspectJAutoProxyCreator的过程===========
 *       AnnotationAwareAspectJAutoProxyCreator => InstantiationAwareBeanPostProcessor
 *    4)finishBeanFactoryInitialization(beanFactory);完成BeanFactory初始化工作，创建剩下的单实例bean
 *      1）遍历获取容器中所有的bean，依次创建对象getBean(beanName)
 *         getBean->doGetBean()->getSingleton()->
 *      2)创建bean
 *          AnnotationAwareAspectJAutoProxyCreator在所有bean创建之前会有一个拦截
 *        1）先从缓存中获取当前bean，如果能获取到，说明bean是之前创建的，直接使用，否则再创建
 *           只要创建的bean都会被缓存起来
 *        2）create（）；创建bean
 *          BeanProcessor是在Bean对象创建完成初始化前后调用的
 *          InstantiationAwareBeanPostProcessor是在创建Bean实例之前先尝试用后置处理器返回对象的
 *           1）resolveBeforeInstantiation(bean,mddToUser),解析BeforeInstantiation
 *              希望后置处理器在此能返回一个代理对象，如果能返回代理对象就使用，如果不能就继续
 *              1），后置处理器先尝试返回对象
 *                  bean = applyBeanPostProcessorBeforeInitialization（）；
 *                  if（bean!=null){
 *
 *                  }
 *
 *           2）doCreate(beanName,mbdToUser,args)；真正的创建一个bean实例
 *
 * @author: lh
 * @date: 2021-07-01 23:53
 **/
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {
    //业务逻辑类加入容器中
    @Bean
    public MathCalculator mathCalculator(){
        return new MathCalculator();
    }
    //切面类加入容器中
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }

}
