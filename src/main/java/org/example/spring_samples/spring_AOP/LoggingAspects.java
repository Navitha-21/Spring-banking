package org.example.spring_samples.spring_AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspects {
    @Before(" execution(* org.example.spring_samples.spring_AOP.PaymentService.*(..))")
    public void logBefore(JoinPoint jp){
        String name = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        System.out.println("Logging Before payment method execution. MethodName: "+name + "  args:  "+ Arrays.asList(args));
    }

    @After(" execution(* org.example.spring_samples.spring_AOP.PaymentService.*(..))")
    public void logAfter(JoinPoint jp){
        String name = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        System.out.println("Logging After payment method execution. MethodName: "+name + "  args:  "+ Arrays.asList(args));
    }

    @Around(" execution(* org.example.spring_samples.spring_AOP.PaymentService.*(..))")
    public Object logAround(ProceedingJoinPoint jp) throws Throwable{
        String name = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        System.out.println("Logging After payment method execution. MethodName: "+name + "  args:  "+ Arrays.asList(args));
        Long startTime = System.currentTimeMillis();
        Object result = jp.proceed();
        Long endTime = System.currentTimeMillis();
        System.out.println("Execution Time : "+(endTime - startTime));
        System.out.println("Logging After payment method execution. MethodName: "+name + "  args:  "+ Arrays.asList(args) + " Result: "+result);
        return result;
    }
}
