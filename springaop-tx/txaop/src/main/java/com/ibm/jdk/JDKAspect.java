package com.ibm.jdk;


/**
 *  为切面  增强的方法
 */
public class JDKAspect {

    /**
     * advice  通知
     */
    public void before(){
        System.out.println("^_^方法执行之前");
    }

    public void after(){
        System.out.println("方法执行结束 @_@");
    }

}
