package com.openapi.annotation.aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Inherited
public @interface IntercepterBy {
	Class<? extends  MethodInterceptor> [] value() ;
}
