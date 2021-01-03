package com.test.aop.aspect;

import android.content.Context;
import android.util.Log;

import com.test.aop.annotation.LoginFilter;
import com.test.aop.impl.ILogin;
import com.test.aop.init.LoginSDK;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect// 1 定义Aspect注解
public class LoginFilterAspect {

    //2定义切点pointcut
    @Pointcut("execution(@com.test.aop.annotation.LoginFilter *  *(..))")
    public void loginFilter(){}

    @Around("loginFilter()") //
    public void aroundLoginPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        ILogin login = LoginSDK.getLoginSDK().getLogin();
        if (login == null) {
            throw new Exception("LoginSDK没有初始化！");
        }
        Signature signature = joinPoint.getSignature();
        if (!(signature instanceof MethodSignature)) {
            throw new Exception("LoginIntercept注解只能用于方法上");
        }
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        if (methodSignature != null) {
            String methodName = methodSignature.getMethod().getName();
            String className = methodSignature.getDeclaringType().getSimpleName();
            LoginFilter loginFilter = methodSignature.getMethod().getAnnotation(LoginFilter.class);
            Log.e("ddd", "1111"+methodName);
            Context context = LoginSDK.getLoginSDK().getContext();
            if (login.isLogin()) { //已经登陆不拦截执行后面方法
                joinPoint.proceed();
            }else { //未登录去登陆
                login.login(context,loginFilter.actionDefine());
            }
        }
        Log.e("ddd", "failture");


    }


}
