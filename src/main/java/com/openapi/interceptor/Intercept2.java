package com.openapi.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Intercept2 implements MethodInterceptor {



    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Intercept2====<><><><><><><><><><>========");
        return invocation.proceed();
    }
}
