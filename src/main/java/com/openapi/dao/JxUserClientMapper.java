package com.openapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.openapi.annotation.mvc.Repository;

@Repository
public interface JxUserClientMapper {
	@Select("select id from jx_user_client  where mobile=#{mobile}")
	List<Long> selectIdByMobilie(@Param("mobile") String mobile);
}
