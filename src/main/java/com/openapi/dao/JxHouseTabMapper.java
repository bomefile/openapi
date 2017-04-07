package com.openapi.dao;

import com.openapi.annotation.mvc.Repository;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Repository
public interface JxHouseTabMapper {

	@Insert("INSERT INTO jx_house_tab (HOUSE_ID,TYPE, CODE, CREATE_TIME, UPDATE_TIME, STATUS) "//
			+ " VALUES (#{HOUSE_ID}, #{type},#{CODE}, now(), now(), 1);")
	Long insert(@Param("HOUSE_ID") String house_id, @Param("CODE") String code, @Param("type") String type);

	@Delete("delete from jx_house_tab  where house_id=#{house_id}")
	void realDeleteByHouseId(@Param("house_id") Long house_id);

	@Update("update jx_house_tab  set STATUS=0  where house_id=#{house_id}")
	void softDeleteByHouseId(@Param("house_id") Long house_id);
}
