package com.openapi.service;

import com.google.inject.Inject;
import com.openapi.annotation.mvc.Service;
import com.openapi.dao.JxHouseTuituiMapper;
import com.openapi.entity.JxHouseTuitui;

/**
 * @author liuzeyuan
 */
@Service("jxHouseTuituiServiceImpl")
public class JxHouseTuituiServiceImpl implements JxHouseTuituiService {
	@Inject
	JxHouseTuituiMapper	jxHouseTuituiMapper;

	public JxHouseTuitui selectExist(Long agent_id, String token, String pkid, String type) {
		return jxHouseTuituiMapper.selectExist(agent_id, token, pkid, type);
	}

}
