package com.openapi.dao;

import com.openapi.annotation.mvc.Repository;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Repository
public interface AgentOrgMapper {

	@Select("select AO_ID from agent_org where ORG_NAME =#{ORG_NAME} limit 1")
	String selectAoIdByName(@Param("ORG_NAME") String org_name);
}
