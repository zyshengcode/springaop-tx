package com.ibm.springautoproxy;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/**
 *  实现MethodInterceptor为环绕通知
 */
public class SpringAutoAspect implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        System.out.println("^_^方法执行之前--------springxml自动配置实现aop");

        Object proceed = invocation.proceed();

        System.out.println("springxml自动配置实现aop**********方法执行结束 @_@");

        return proceed;
    }
}
