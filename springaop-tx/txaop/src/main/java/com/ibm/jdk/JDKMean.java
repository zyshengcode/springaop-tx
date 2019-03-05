package com.ibm.jdk;

/**
 * JDK动态代理来实现aop     必须实现接口
 */
public class JDKMean {

    public static void main(String[] args) {
     JDKService jdkService = FactoryBean.createJDKService();
     jdkService.insert();
        /**
         * 调用insert方法----->其实相当于是没有实现的，产生的代理里面的insert（）方法（类似JDKService中的insert方法），
         * 其实是先调用处理类invocationhandler中的invoke方法，
         * 然后调用增强方法，然后调用实现类（SpringAutoServiceImpl）的insert（）方法
         */
    }

}
