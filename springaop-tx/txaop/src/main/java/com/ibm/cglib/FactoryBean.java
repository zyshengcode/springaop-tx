package com.ibm.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class FactoryBean {

    /**
     * 调用此方法来完成CGLIB的代理     运行时创建目标类的子类，来对目标类进行增强
     * @return
     */
        public static CGLIBserviceImpl createJDKService(){
        //1.得到目标对象
        final CGLIBserviceImpl cgliBservice = new CGLIBserviceImpl();
        //2.得到切面
        final CGLIBAspect cglibAspect = new CGLIBAspect();



        //3.1得到核心类，即子类
            Enhancer enhancer = new Enhancer();
        //3.2得到父类
               enhancer.setSuperclass(cgliBservice.getClass());
            /**
             *   3.3创建处理类  设置回调函数，类似jdk的 invocationhandler接口,与jdk类似
             *
             *   Method method的invoke与 MethodProxy methodProxy的invokeSuper方法功能类似
             */


        enhancer.setCallback(new MethodInterceptor(){

            @Override
            public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                cglibAspect.before();
                method.invoke(cgliBservice);
                /**
                 * 目标类的父类方法进行代理
                 */
                methodProxy.invokeSuper(proxy,objects);//proxy为目标类
                cglibAspect.after();

                 return  null;
            }
        });

        //3.4 创建代理
            CGLIBserviceImpl proxttarget  = (CGLIBserviceImpl) enhancer.create();

            return proxttarget;
    }

}
