package com.ibm.autoaspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
AspectJ的注解版本

 1.先对xml中切面类与目标类用注解进行替换
 2.扫描xml
 3.开始aspectj的自动代理
 4.配置公共的切入点pointcut
 */
public class AspectJMeanAuto {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:spring/springaopaspectjauto.xml");

        AspectJserviceAuto aspectJservice = (AspectJserviceAuto) applicationContext.getBean("SpringserviceId");

        try {
            aspectJservice.delete();
        }catch (ArithmeticException e){
            System.out.println("      "+e.getMessage()+"try 处理");
        }

        System.out.println();

        aspectJservice.insert();


    }

}
