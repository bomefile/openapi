package com.openapi.dao;

import com.openapi.annotation.mvc.Repository;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Repository
public interface BasisDistrictMapper {

	@Select("select BD_ID from basis_district where DISTRICT_NAME =#{DISTRICT_NAME} limit 1")
	String selectBdIdByName(@Param("DISTRICT_NAME") String districtName);
}
