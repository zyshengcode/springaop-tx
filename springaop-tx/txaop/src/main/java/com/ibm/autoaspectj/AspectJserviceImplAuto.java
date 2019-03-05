package com.ibm.autoaspectj;

import org.springframework.stereotype.Service;

/**
 * 通知 aspect
 */
@Service(value = "SpringserviceId")
public class AspectJserviceImplAuto implements AspectJserviceAuto {


    /**
     *pointcut  + jointcut 切入点，已经被增强的方法
     */

    public void insert() {
        System.out.println("正在执行*_*,^_^增加方法");
    }

    /**
     * jointcut 连接点   可能被增强或已经被增强的方法
     */

    public String delete() {
        int a = 10/0;
        System.out.println("删除方法");
        return "刀剑如梦";

    }
}
