package com.openapi.dao;

import com.openapi.annotation.mvc.Repository;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Repository
public interface BasisCityMapper {

	@Select("select CITY_CODE from basis_city where  CITY_NAME like #{CITY_NAME}")
	String selectCityCodeByName(@Param("CITY_NAME") String cityName);

}
