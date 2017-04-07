package com.openapi.dao;

import com.openapi.annotation.mvc.Repository;
import com.openapi.entity.JxAgentAuth;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface JxAgentAuthMapper {

	@Select("select count(*) from jx_agent_auth  where  CARD_NUMS=#{CARD_NUMS}")
	Integer selectCntByCardNum(@Param("CARD_NUMS") String cardNum);

	@Insert("insert jx_agent_auth(AGENT_ID,CARD_NUMS,TYPE,IMAGE_PATH_1,CREATE_TIME,CHECK_STATUS) "//
			+ "values(#{AGENT_ID},#{IDCard},'0',#{PhotoIDCard},now(),'0')")
	Integer tuituiInsertIDCard(Map<String, String> values);

	@Select("select * from jx_agent_auth where agent_id=#{agent_id}")
	List<JxAgentAuth> selectByAgentId(@Param("agent_id") String agent_id);

	@Update("update jx_agent_auth set IMAGE_PATH_1=#{photoPath}  where id=#{id}")
	void updatePhotoPathById(@Param("id") String id, @Param("photoPath") String photoPath);

	@Select("SELECT * FROM  jx_agent_auth p WHERE ( p.IMAGE_PATH_1 LIKE 'http%' or p.IMAGE_PATH_2 LIKE 'http%') and p.LAST_MODIFY_TIME>=#{lastModifyTime} order by p.LAST_MODIFY_TIME desc")
	List<JxAgentAuth> selectAgentIdWithStartHttp(@Param("lastModifyTime") Date lastModifyTime);

	@Delete("delete from jx_agent_auth where id=#{id}")
	void realDeleteById(@Param("id") String id);
}
