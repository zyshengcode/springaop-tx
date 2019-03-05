package com.ibm.aspect;

import com.ibm.springproxy.SpringService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 aspectJ的xml形式
 */
public class AspectJMean {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:spring/springaopaspectj.xml");

        AspectJservice aspectJservice = (AspectJservice) applicationContext.getBean("SpringserviceId");

        try {
            aspectJservice.delete();
        }catch (ArithmeticException e){
            System.out.println("      "+e.getMessage()+"try 处理");
        }

        System.out.println();

        aspectJservice.insert();


    }

}
