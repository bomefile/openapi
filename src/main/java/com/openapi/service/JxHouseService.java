package com.openapi.service;

import com.openapi.entity.JxHouse;
import com.openapi.entity.JxHouseTuitui;
import com.openapi.exception.ShowTextException;

import java.util.List;
import java.util.Map;

/**
 * @author liuzeyuan
 */
public interface JxHouseService {

	/**
	 * 推推房源刷新
	 *
	 * @param houseId
	 *            房源编号
	 */
	Integer tuituiRefresh(String houseId, Long agent_id);

	/**
	 * 推推房源删除
	 *
	 * @param houseId
	 *            房源编号
	 */
	Integer tuituiDelete(String houseId);

	/**
	 * 根据 经纪人id查询出有效的经纪人的租房房源
	 *
	 * @param agent_id
	 * @return
	 */
	public List<JxHouse> selectAvaliableByAgentIdTuitui(Long agent_id);

	/**
	 * 推推房源注册
	 *
	 * @param params
	 * @throws ShowTextException
	 */
	String tuituiRegist(Map<String, String> params, final String type, final String token, final String pkId, final Long agent_id, final JxHouseTuitui tuituiInfo) throws ShowTextException;

}
