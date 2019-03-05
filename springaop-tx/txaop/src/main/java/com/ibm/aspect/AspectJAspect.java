package com.ibm.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 *  为切面  方法名字任意，因为会在配置文件中指定
 *
 *  JoinPoint用于描述连接点的目标方法，可以获取方法名字以及参数等信息
 *
 *  aspectjAfterReturn(JoinPoint joinPoint,Object ret)  后置通知，
 *  第二个参数表示连接点方法的返回值，ret必须要与xml中return属性一致
 *
 *  aspectjAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
 *  环绕通知返回值必须为Object, 第一个参数必须为为joinpoint的子类，必须抛出异常
 *  收到执行目标方法
 *
 *aspectjThrows(JoinPoint joinPoint,Throwable e)
 * 第一个参数连接点，第二个参数获取异常的信息  e与xml中throwing对应
 * 并且后面的方法不在执行
 *
 *
 * aspectjFinally(JoinPoint joinPoint)  最终通知
 */
public class AspectJAspect  {

/*    public void aspectjBefor(JoinPoint joinPoint){
        System.out.println("aspectj的前置通知");
    }*/

    public void aspectjAfterReturn(JoinPoint joinPoint,Object ret){
        System.out.println("aspectj的前置通知"+joinPoint.getSignature().getName()+"****"+joinPoint.getSignature()
        +"^^^^^"+ret);
    }


    /*public Object aspectjAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("环绕通知里面的aspectj前置通知");

        Object proceed = proceedingJoinPoint.proceed();

        System.out.println("环绕通知里面的aspectj后置通知");

        return proceed;
    }*/

    public void aspectjThrows(JoinPoint joinPoint,Throwable e){
        System.out.println("抛出异常信息"+e.getMessage());
    }

    public void aspectjFinally(JoinPoint joinPoint){

        System.out.println("最终通知");
    }
}
