package com.openapi.dao;

import com.openapi.annotation.mvc.Repository;
import com.openapi.entity.JxHouseTuitui;
import org.apache.ibatis.annotations.*;

@Repository
public interface JxHouseTuituiMapper {

	@Insert("insert into jx_house_tuitui(house_id,token,pkid,agent_id,type) values(#{house_id},#{token},#{pkid},#{agent_id},#{type})")
	Long insert(@Param("house_id") String house_id, @Param("token") String token, @Param("pkid") String pkid, @Param("agent_id") Long agent_id, @Param("type") String type);

	@Select("select * from jx_house_tuitui t where t.token=#{token} and t.pkid=#{pkid} and t.type=#{type} and t.agent_id=#{agent_id}")
	JxHouseTuitui selectExist(@Param("agent_id") Long agent_id, @Param("token") String token, @Param("pkid") String pkid, @Param("type") String type);

	@Delete("delete from jx_house_tuitui where house_id=#{house_id} and type=#{type}")
	void realDeleteByHouseId(@Param("house_id") Long house_id, @Param("type") String type);

	@Update("update jx_house_tuitui set last_modify_time=now() where token=#{token} and pkid=#{pkid} and type=#{type}")
	void refresh(@Param("token") String token, @Param("pkid") String pkid, @Param("type") String type);
}
