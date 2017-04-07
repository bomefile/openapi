package com.openapi.annotation.quartz;

import org.quartz.Scheduler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * quartz 中定时任务
 *
 * @author Administrator
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface Schedule {

	/**
	 * cron 时间表达式
	 */
	String cron() default "";

	/**
	 * 时间频率
	 */
	long interval() default -1;

	/**
	 * 时间单位
	 */
	TimeUnit unit() default TimeUnit.MILLISECONDS;

	/**
	 * job分组
	 */
	String group() default Scheduler.DEFAULT_GROUP;

	/**
	 * 描述
	 */
	String description() default "";

	/**
	 * 故障恢复(把欠缺的执行次数都补回来)
	 */
	boolean recovery() default false;

	/**
	 * 任务参数
	 */
	UsingData[] datas();
}
