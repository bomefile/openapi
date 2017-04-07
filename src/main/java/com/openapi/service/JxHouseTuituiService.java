package com.openapi.service;

import com.openapi.entity.JxHouseTuitui;

/**
 * @author liuzeyuan
 */
public interface JxHouseTuituiService {

	public JxHouseTuitui selectExist(Long agent_id, String token, String pkid, String type);

}
