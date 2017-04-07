package com.openapi.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuzeyuan
 */
public interface BasisDicInfoService {

	public String selectCodeIdByName(@Param("name") String name, @Param("type") int type);

	public List<String> selectCodeIdsByNames(@Param("names") String[] names);
}
