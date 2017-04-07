package com.openapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.openapi.annotation.mvc.Repository;
import com.openapi.entity.JxUserBaidu;

@Repository
public interface JxUserBaiduMappper {

	@Select("select * from jx_user_baidu  where user_id=#{userid} and type=#{type} and devicetype=#{deviceType}")
	Long findBaidu(@Param("userid") Long userid, @Param("type") int type, @Param("deviceType") int deviceType);

	/**
	 * @param userIds
	 * @param type
	 *            // type:1为经纪人,2为用户
	 * @param deviceType
	 *            // devicetype:1为android,2为ios
	 * @return
	 */
	@Select({ "<script>", //
			"select * from jx_user_baidu  where  user_id IN", //
			"<foreach item='item' index='index' collection='userIds' open='(' separator=',' close=')'>",//
			"#{item}", //
			"</foreach>",//
			" and type=#{type} and devicetype=#{deviceType}",//
			"</script>" })
	List<JxUserBaidu> findAll(@Param("userIds") List<Long> userIds, @Param("type") int type, @Param("deviceType") int deviceType);
}
