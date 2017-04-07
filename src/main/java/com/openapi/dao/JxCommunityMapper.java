package com.openapi.dao;

import com.openapi.annotation.mvc.Repository;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Repository
public interface JxCommunityMapper {

	@Select("select id from jx_community where community_name=#{community_name} and  status!=-1 limit 1")
	String selectIDByComName(@Param("community_name") String community_name);

}
