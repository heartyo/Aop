package com.test.aop.aspect;

import android.util.Log;

import com.test.aop.annotation.BehaviorTrace;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect// 1 定义Aspect注解
public class BehaviorTraceAspect {

    //2定义切点pointcut
    @Pointcut("execution(@com.test.aop.annotation.BehaviorTrace *  *(..))")
    public void methodPointcut(){}

    @Around("methodPointcut()") //
    public Object traceEvent(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        String className = signature.getDeclaringType().getSimpleName();
        String value = signature.getMethod().getAnnotation(BehaviorTrace.class).value();
        Log.e("ddd", "1111"+methodName);
        Object result = joinPoint.proceed();
        return result;
    }


}
