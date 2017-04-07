package com.openapi.dao;

import com.openapi.annotation.mvc.Repository;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Repository
public interface JxRentTagMapper {

	@Insert("INSERT INTO jx_rent_tag (rent_id,type, CODE, CREATE_TIME, UPDATE_TIME, STATUS) "//
			+ "VALUES (#{rent_id}, #{type},#{CODE}, now(), now(), 1)")
	Long insert(@Param("rent_id") String rent_id, @Param("CODE") String code, @Param("type") String type);

	@Delete("delete from jx_rent_tag  where rent_id=#{rent_id}")
	void realDeleteByHouseId(@Param("rent_id") Long rent_id);

	@Update("update jx_rent_tag  set STATUS=0  where rent_id=#{rent_id}")
	void softDeleteByHouseId(@Param("rent_id") Long rent_id);
}
