package com.openapi.dao;

import com.openapi.annotation.mvc.Repository;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Repository
public interface BasisBusinessDistrictMapper {

	@Select("select BBD_ID from basis_business_district where BUSINESS_DISTRICT_NAME =#{BUSINESS_DISTRICT_NAME} limit 1")
	String selectBBdIdByName(@Param("BUSINESS_DISTRICT_NAME") String businessDistricName);
}
