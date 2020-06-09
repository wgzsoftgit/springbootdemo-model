package com.demomodel.configure.doubledatasource.textdoubledatasource.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
//@Order(1)   //使用Order改变切面顺序，数值越小优先级越高
public class LogUtils {
 
    /**
     * 切入点
     */
    @Pointcut("execution(* com.demomodel.configure.doubledatasource.textdoubledatasource.master.map..*.*(..))")
    public void executePackage(){};
 
    /**
     * 前置通知，目标方法调用前被调用
     */
    @Before("executePackage()")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("- - - - - 前置通知 - - - - -");
        Signature signature = joinPoint.getSignature();
        System.out.println("返回目标方法的签名："+signature);
        System.out.println("代理的是哪一个方法："+signature.getName());
        Object[] obj = joinPoint.getArgs();
        System.out.println("获取目标方法的参数信息："+Arrays.asList(obj));
    }
 
    /**
     * 后置通知，目标方法执行完执行
     */
    @After("execution(* com.demomodel.configure.doubledatasource.textdoubledatasource.master.map..*.*(..))")
    public void afterAdvice(){
        System.out.println("- - - - - 后置通知- - - - -");
    }
 
    /**
     * 后置返回通知
     * 如果参数中的第一个参数为JoinPoint，则第二个参数为返回值的信息
     * 如果参数中的第一个参数不为JoinPoint，则第一个参数为returning中对应的参数
     * returning 只有目标方法返回值与通知方法相应参数类型时才能执行后置返回通知，否则不执行
     */
   @AfterReturning(value = "executePackage()",returning = "res")
    public void afterReturningAdvice(JoinPoint joinPoint, Object res){
        System.out.println("- - - - - 后置返回通知- - - - -");
        System.out.println("后置返回通知 返回值："+res);
    }
 
 
    /**
     * 后置异常通知
     *  定义一个名字，该名字用于匹配通知实现方法的一个参数名，当目标方法抛出异常返回后，将把目标方法抛出的异常传给通知方法；
     *  throwing 只有目标方法抛出的异常与通知方法相应参数异常类型时才能执行后置异常通知，否则不执行，
     */
    @AfterThrowing(value = "executePackage()",throwing = "exception")
    public void afterThrowingAdvice(JoinPoint joinPoint,NullPointerException exception){
        System.out.println("- - - - - 后置异常通知 - - - - -");
    }
 
    /**
     * 环绕通知：
     * 环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
     * 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     */
    @Around("executePackage()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        Object[] args = proceedingJoinPoint.getArgs();  //参数
        try {
        	for (Object object : args) {
				System.err.println(object);
			}
            System.out.println("- - - - - 环绕前置通知 - - - -");
            Object obj = proceedingJoinPoint.proceed(args);//调用执行目标方法
            System.out.println("- - - - - 环绕后置返回通知 - - - -");
            return obj;
        } catch (Throwable throwable) {  
            throwable.printStackTrace();
            System.out.println("- - - - - 环绕异常通知 - - - -");
        }finally {
            System.out.println("- - - - - 环绕后置通知 - - - -");
        }
        return null;
    }
}
//https://blog.csdn.net/Luck_ZZ/java/article/details/100047014