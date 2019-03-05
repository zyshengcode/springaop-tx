package com.ibm.jdk;

import com.ibm.jdk.impl.JDKServiceImpl;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class FactoryBean {

    /**
     * 调用此方法来完成jdk的代理
     * @return
     */
    public static JDKService createJDKService(){
        //1.得到目标类
        final JDKService jdkService = new JDKServiceImpl();
        //2.得到切面类
        final JDKAspect jdkAspect = new JDKAspect();

        System.out.println(FactoryBean.class.getClassLoader()+".......");
        System.out.println(jdkService.getClass().getClassLoader()+"********");


        //切面类与目标类结合生成代理类
        /**
         * classload 类加载器一般为当前类
         * interface数组，二种方式可以得到   1.通过目标对象jdkService,getclass.getinterfaces  2.下面写到 数组方式
         * h,表示invocationhandler   处理类，用来对目标方法进行处理
         */
        JDKService target = (JDKService) Proxy.newProxyInstance(FactoryBean.class.getClassLoader(), new Class[]{JDKService.class},
                new InvocationHandler() {
                    /**
                     * 代理的每一个方法执行的时候都将调用invoke---->结合main函数来看
                     * insert（）{
                     *      invoke(Object proxy, Method method, Object[] args)
                     * }

                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        //传入目标对象，与目标参数
                        jdkAspect.before();
                        Object o = method.invoke(jdkService);
                        jdkAspect.after();
                        return o;
                    }
                });


        return target;
    }

}
