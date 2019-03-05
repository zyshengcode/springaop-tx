package com.ibm.cglib;

/**
 * 通知 aspect
 */
public class CGLIBserviceImpl {


    /**
     *pointcut  + jointcut 切入点，已经被增强的方法
     */

    public void insert() {
        System.out.println("正在执行*_*,^_^增加方法");
    }

    /**
     * jointcut 连接点   可能被增强或已经被增强的方法
     */

    public void delete() {

    }
}
