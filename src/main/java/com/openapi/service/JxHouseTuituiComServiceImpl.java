package com.openapi.service;

import com.google.inject.Inject;
import com.openapi.entity.JxHouseTuituiCom;
import com.openapi.annotation.mvc.Service;
import com.openapi.dao.JxHouseTuituiComMapper;

/**
 * @author liuzeyuan
 */
@Service("jxHouseTuituiComServiceImpl")
public class JxHouseTuituiComServiceImpl implements JxHouseTuituiComService {

	@Inject
	JxHouseTuituiComMapper	jxHouseTuituiComMapper;

	@Override
	public Long insert(String com_name, String token, String cityName, String comment, String dayTime) {
		return this.jxHouseTuituiComMapper.insert(com_name, token, cityName, comment, dayTime);
	}

	@Override
	public JxHouseTuituiCom selectExist(String com_name, String token, String cityName, String comment, String dayTime) {
		return this.jxHouseTuituiComMapper.selectExist(com_name, token, cityName, comment, dayTime);
	}

	@Override
	public void updateHits(long id) {
		this.jxHouseTuituiComMapper.updateHits(id);
	}
}
