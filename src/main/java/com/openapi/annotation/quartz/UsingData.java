package com.openapi.annotation.quartz;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * job detail 中 job datamap
 *
 * @author Administrator
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface UsingData {

	/**
	 * 键
	 */
	String key();

	/**
	 * 值
	 */
	String value() default "";

}
