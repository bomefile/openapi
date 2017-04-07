package com.openapi.dao;

import com.openapi.annotation.mvc.Repository;
import com.openapi.entity.JxAgent;

import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface JxAgentMapper {

	@Select("select * from jx_agent j where j.mobile=#{mobile} and j.password=#{password} and j.status=1")
	JxAgent selectByMobileAndPwd(@Param("mobile") String mobile, @Param("password") String password);

	@Select("select count(*) from jx_agent j where j.mobile=#{mobile}  limit 1")
	Integer selectByMobileCnt(@Param("mobile") String mobile);

	@Insert("insert into jx_agent(SOURCE_AGENT_ID,SOURCE,CITY_ID,PASSWORD,EMAIL,AGENT_NAME,BD_ID,BBD_ID,ORG_ID,SEX,COMPANY_NAME,STORE_NAME,mobile,PHOTO_PATH,SMALL_PHOTO_PATH,USER_CODE,AUTH_CHECK_STATUS,AUTH_SF_CHECK_STATUS,CREATE_TIME,UPDATE_TIME)"//
			+ "values(#{source_agent_id},4,#{CITY_ID},#{userKey},#{email},#{Name},#{BD_ID},#{BBD_ID},#{ORG_ID},#{SEX},#{Company1},#{Company2},#{Mobile},#{Photo},#{Photo},#{USER_CODE},0,0,now(),now())")
	@SelectKey(statement = "select last_insert_id()", keyProperty = "AGENT_ID", before = false, resultType = String.class)
	@Options(useGeneratedKeys = true)
	Integer tuituiInsert(Map<String, String> values);

	@Select("SELECT * FROM jx_agent j WHERE j.PHOTO_PATH like 'http%' and j.LAST_MODIFY_TIME>=#{lastModifyTime} order by j.LAST_MODIFY_TIME desc")
	List<JxAgent> selectAgentIdWithStartHttp(@Param("lastModifyTime") Date lastModifyTime);

	@Select("select * from jx_agent where id=#{agent_id}")
	JxAgent selectById(@Param("agent_id") String agent_id);

	@Update("update jx_agent set PHOTO_PATH=#{photoPath},SMALL_PHOTO_PATH=#{photoPath} where id=#{id}")
	void updatePhotoPathById(@Param("id") String agent_id, @Param("photoPath") String photoPath);

	@Select("select id from jx_agent  where mobile=#{mobile} and status=1")
	List<Long> selectIdByMobilie(@Param("mobile") String mobile);
}
