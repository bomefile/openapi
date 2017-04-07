package com.openapi.job;

import com.google.inject.Inject;
import com.openapi.dao.JxHouseMapper;
import com.openapi.dao.JxRentMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 暂存房源 15分钟要上线,2014-11-26
 *
 * @author liuzeyuan
 */
// @Schedule(interval = 1, unit = TimeUnit.MINUTES, description = "SE 暂存房源上线",
// recovery = false,//
// datas = { @UsingData(key = "key", value = "value") })
public class SeHouseSetOnlineJob implements Job {
	protected static final Logger logger = LogManager.getLogger(SeHouseSetOnlineJob.class);
	@Inject
	JxRentMapper jxRentMapper;
	@Inject
	JxHouseMapper jxHouseMapper;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("run SE job");
		jxHouseMapper.updateJob();
		jxRentMapper.updateJob();
	}
}
