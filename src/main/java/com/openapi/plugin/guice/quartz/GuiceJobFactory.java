package com.openapi.plugin.guice.quartz;

import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.openapi.annotation.mvc.Component;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.spi.JobFactory;
import org.quartz.spi.TriggerFiredBundle;

import javax.inject.Inject;

@Component
@Singleton
public class GuiceJobFactory implements JobFactory {

	private Injector	injector;

	@Inject
	public GuiceJobFactory(Injector injector) {
		this.injector = injector;
	}

	public Job newJob(TriggerFiredBundle bundle, Scheduler scheduler) throws SchedulerException {

		JobDetail jobDetail = bundle.getJobDetail();
		Class<? extends Job> jobClass = jobDetail.getJobClass();
		return injector.getInstance(jobClass);
	}

}