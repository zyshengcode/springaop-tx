package com.ibm.cglib;

/**
 * CGLIB来实现aop（在没有接口只有实现类的情况下）
 */
public class CGLIBMean {

    public static void main(String[] args) {
       CGLIBserviceImpl cgliBservice = FactoryBean.createJDKService();
       cgliBservice.insert();


    }

}
