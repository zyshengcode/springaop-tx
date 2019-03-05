package com.ibm.springautoproxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring全自动配置实现代理
 *
 */
public class SpringAutoMean {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/springautoaop.xml");

       //得到目标对象
        SpringAutoService springserviceId =(SpringAutoService) applicationContext.getBean("SpringserviceId");
        springserviceId.insert();
        System.out.println();
        springserviceId.delete();

    }

}
