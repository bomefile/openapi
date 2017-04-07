package com.openapi.dao;

import com.openapi.entity.JxTuituiBlacklist;
import com.openapi.annotation.mvc.Repository;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Repository
public interface JxTuituiBlacklistMapper {

	@Select("select * from jx_tuitui_blacklist t where   t.name=#{name}  and t.type=#{type} and status=1")
	JxTuituiBlacklist selectExist(@Param("name") String name, @Param("type") String type);
}
