package com.ibm.autoaspectj;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
@Aspect
public class AspectJAspectAuto {

    //切入点方法一般为私有，无返回值
    @Pointcut("execution(* com.ibm.autoaspectj.AspectJserviceImplAuto.*(..))")
    private void pointCutMethod(){

    }

/*    @Before("execution(* com.ibm.autoaspectj.AspectJserviceImplAuto.*(..))")
   类似<aop:before method="aspectjBefor" pointcut-ref="aspectjPointCut" pointcut="">中
    的属性pointcut：为前置通知定制自己特有的pointcut切入点
   public void aspectjBefor(JoinPoint joinPoint) {
       System.out.println("aspectj的前置通知");
   }

    @AfterReturning(value = "pointCutMethod()",returning = "ret")  //方法执行或执行之前有异常，此方法不执行

   类似<aop:before method="aspectjBefor" pointcut-ref="aspectjPointCut" pointcut="">中
    的属性pointcut-ref：为后置通知引用公共的pointcut切入点
    public void aspectjAfterReturn(JoinPoint joinPoint,Object ret){
        System.out.println("aspectj的后置通知"+joinPoint.getSignature().getName()+"****"+joinPoint.getSignature()
        +"^^^^^"+ret);
    }*/

    @Around("pointCutMethod()")
    public Object aspectjAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("环绕通知里面的aspectj前置通知");

        Object proceed = proceedingJoinPoint.proceed();

        System.out.println("环绕通知里面的aspectj后置通知");

        return proceed;
    }

/*    @AfterThrowing(value = "pointCutMethod()",throwing = "e")
    public void aspectjThrows(JoinPoint joinPoint,Throwable e){
        System.out.println("抛出异常信息"+e.getMessage());
    }*/

  /*  @After(value = "pointCutMethod()")//先于AfterReturning执行
    public void aspectjFinally(JoinPoint joinPoint){

        System.out.println("最终通知");
    }*/
}
