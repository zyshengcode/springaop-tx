package com.ibm.springautoproxy.impl;

import com.ibm.springautoproxy.SpringAutoService;

public class SpringAutoServiceImpl implements SpringAutoService {


    /**
     *pointcut  + jointcut 切入点，已经被增强的方法
     */
    @Override
    public void insert() {
        System.out.println("正在执行*_*     ,   ^_^增加方法");
    }

    /**
     * jointcut 连接点   可能被增强或已经被增强的方法
     */
    @Override
    public void delete() {
        System.out.println( "*********!!!!!!!删除方法实现!!!!!!*********");
    }
}
