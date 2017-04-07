package com.openapi.service;

import com.openapi.entity.JxHouseTuituiCom;

/**
 * @author liuzeyuan
 */
public interface JxHouseTuituiComService {

	Long insert(String com_name, String token, String cityName, String comment, String dayTime);

	JxHouseTuituiCom selectExist(String com_name, String token, String cityName, String comment, String dayTime);

	void updateHits(long id);
}
