package com.openapi.service.hr;

import com.google.inject.Inject;
import com.openapi.annotation.mvc.Service;
import com.openapi.dao.hr.HrSetIdMappper;
import com.openapi.entity.hr.DataBlockEntity;
import com.openapi.entity.hr.HrSetIdEntity;
import com.openapi.service.BaseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.guice.transactional.Transactional;

import java.util.Date;
import java.util.List;


@Service("HrSetIdService")
public  class HrSetIdService extends BaseService{

	@Inject
	HrSetIdMappper hrSetIdMappper;


	/**
	 * 插入数据，请保证数据完整
	 * @param entity
	 * @return
     */
	@Transactional
	public int insert(HrSetIdEntity entity){
		return hrSetIdMappper.insert(entity);
	}

	/**
	 * 批量插入，请保证数据完整
	 * @param list
	 * @return
     */
	@Transactional
	public Integer insertBatch(List<HrSetIdEntity> list){
		return hrSetIdMappper.insertBatch(list);
	}

	@Transactional
	public Integer insertBatch(DataBlockEntity<HrSetIdEntity> entity){
		return hrSetIdMappper.insertBatchEntity(entity);

	}
}
