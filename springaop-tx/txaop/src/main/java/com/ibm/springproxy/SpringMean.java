package com.ibm.springproxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring半自动实现aop
 *
 * 如果目标类有接口采用JDK，没有接口采用CGLIB，如果有声明为CGLIB，则为CGLIB
 *
 */
public class SpringMean {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/springaop.xml");

        //得到工厂类（用于产生代理类）
        SpringService springserviceId =(SpringService) applicationContext.getBean("Proxy_Class");
        springserviceId.insert();


    }

}
