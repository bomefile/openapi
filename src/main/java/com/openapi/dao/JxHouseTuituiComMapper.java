package com.openapi.dao;

import com.openapi.annotation.mvc.Repository;
import com.openapi.entity.JxHouseTuituiCom;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Repository
public interface JxHouseTuituiComMapper {

	@Insert("insert into jx_house_tuitui_com(community_name,token,city_name,comment,day_time) values(#{com_name},#{token},#{cityName},#{comment},#{day_time})")
	Long insert(@Param("com_name") String com_name, @Param("token") String token, @Param("cityName") String cityName, @Param("comment") String comment, @Param("day_time") String dayTime);

	@Select("select * from jx_house_tuitui_com t where t.community_name=#{com_name} and t.token=#{token}  and t.city_name=#{cityName} and t.comment=#{comment} and t.day_time=#{day_time}")
	JxHouseTuituiCom selectExist(@Param("com_name") String com_name, @Param("token") String token, @Param("cityName") String cityName, @Param("comment") String comment, @Param("day_time") String dayTime);

	@Update("update jx_house_tuitui_com t set t.hits=t.hits+1 where t.id=#{id}")
	void updateHits(@Param("id") long id);
}
