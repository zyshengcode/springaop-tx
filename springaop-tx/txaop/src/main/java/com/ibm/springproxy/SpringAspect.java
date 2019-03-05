package com.ibm.springproxy;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/**
 *  实现MethodInterceptor为环绕通知
 */
public class SpringAspect implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        System.out.println("^_^方法执行之前");

        Object proceed = invocation.proceed();

        System.out.println("方法执行结束 @_@");

        return proceed;
    }
}
