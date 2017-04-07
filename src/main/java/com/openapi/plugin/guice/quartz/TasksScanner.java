package com.openapi.plugin.guice.quartz;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.openapi.annotation.mvc.Component;
import com.openapi.annotation.quartz.Schedule;
import com.openapi.annotation.quartz.UsingData;
import com.openapi.config.ConfigHolder;
import com.openapi.util.ClassLookup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

@Component
@Singleton
public class TasksScanner {
    protected static final Logger logger = LogManager.getLogger(TasksScanner.class);

    @Inject
    GuiceJobFactory guiceJobFactory;

    @Inject
    public void run() {
        try {
            // /因为这部分功能还没上线,再配置文件中加个开关
            if (!ConfigHolder.getQuartzJobEnable()) {
                logger.info("Job disabled!!!!");
                return;
            }
            Set<Class<?>> classes = ClassLookup.getUserClasses();
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.setJobFactory(guiceJobFactory);

            for (Class<?> clazz : classes) {
                if (clazz.isAnnotationPresent(Schedule.class)) {
                    Schedule scheduled = clazz.getAnnotation(Schedule.class);
                    String group = scheduled.group();

                    Class<?>[] interfaceClazzes = clazz.getInterfaces();
                    for (Class<?> interfaceClazz : interfaceClazzes) {
                        if (interfaceClazz.equals(Job.class)) {
                            // 创建任务 JobDetail
                            JobDetail jobDetail = buildJobDetail(scheduled, clazz);
                            // 创建触发器
                            Trigger trigger = buildTrigger(scheduled);
                            JobKey jobKey = new JobKey(clazz.getName(), group);
                            JobDetail temp_jobDetail = scheduler.getJobDetail(jobKey);
                            if (temp_jobDetail == null) {
                                scheduler.scheduleJob(jobDetail, trigger);
                            }
                            logger.info(" Task: group[" + group + "]" +
                                    "\tname[ " + clazz.getName() + "]" +
                                    "\tcron[" + scheduled.cron() + "]" +
                                    "\tinterval[" + scheduled.interval() + "]" +
                                    "\tunit[" + scheduled.unit() + "]"
                            );
                        } else {
                            logger.info(clazz.getName() + " dose not implement [" + Job.class.getName() + "]");
                        }
                    }
                }
            }
            // 启动任务
            scheduler.start();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
    }

    protected static JobDetail buildJobDetail(Schedule scheduled, Class<?> clazz) {
        String group = scheduled.group();
        String description = scheduled.description();
        boolean recovery = scheduled.recovery();
        UsingData[] datas = scheduled.datas();
        JobBuilder jobBuilder = newJob((Class<? extends Job>) clazz)
                .withIdentity(clazz.getName(), group)//
                .withDescription(description)//
                .requestRecovery(recovery);//
        for (UsingData data : datas) {
            jobBuilder.usingJobData(data.key(), data.value());
        }
        return jobBuilder.build();
    }

    protected static Trigger buildTrigger(Schedule scheduled) {
        TriggerBuilder<Trigger> trigger = newTrigger();
        if (scheduled.cron() != null && scheduled.cron().trim().length() > 0) {
            trigger.withSchedule(cronSchedule(scheduled.cron()));
        } else if (scheduled.interval() != -1) {
            trigger.withSchedule(simpleSchedule()//
                    .withIntervalInMilliseconds(TimeUnit.MILLISECONDS.convert(scheduled.interval(), scheduled.unit()))//
                    .repeatForever())//
                    .startNow();
        } else {
            throw new IllegalArgumentException("One of 'cron' or 'interval' is required for the @Scheduled annotation");
        }
        return trigger.build();
    }

    public static void main(String[] args) {
        System.out.println(

                TimeUnit.MILLISECONDS.convert(5, TimeUnit.MINUTES));
    }
}
