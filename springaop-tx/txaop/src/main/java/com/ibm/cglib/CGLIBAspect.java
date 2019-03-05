package com.ibm.cglib;


/**
 *  为切面  增强的方法
 */
public class CGLIBAspect {

    /**
     * advice  通知
     */
    public void before(){
        System.out.println("^_^方法执行之前CGLIB");
    }

    public void after(){
        System.out.println("CGLIB方法执行结束 @_@");
    }

}
