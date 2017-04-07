package com.openapi.dao;

import com.openapi.entity.JxRent;
import com.openapi.annotation.mvc.Repository;

import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface JxRentMapper {

	@Update("update jx_rent j set  j.UPDATE_TIME=now() where j.rent_id=#{rent_id} and j.AGENT_ID=#{agent_id}")
	Integer tuituiRefresh(@Param("rent_id") String rent_id, @Param("agent_id") Long agent_id);

	@Insert("INSERT INTO jx_rent (updater_id,house_text,ident,rent_type,rental_extra,UPDATE_TIME,CREATE_TIME,COMMUNITY_ID,community_name,rental, HOUSE_TITLE,FLOOR_NO, total_floor, bedroom_total, hall_total, bathroom_total,kitchen_total, HO_ID, BUILDING_AREA, HD_ID,FINISHED_YEAR, HOUSE_INFO, title_img, HOUSE_STATUS,HOUSE_TYPE,  INTER_HOUSE_CODE,AGENT_ID,SOURCE,mobile) "//
			+ "VALUES (-1,#{house_text},2,#{RENT_TYPE},#{RENT_EXTRA},now(),now(),#{COMMUNITY_ID}, #{Community}, #{Total},#{Topic}, #{Floor}, #{Floors}, #{Shi}, #{Ting}, #{Wei}, #{Chu}, #{HO_ID}, #{Square},#{HD_ID}, #{Years},#{Content}, #{Thumbnail}, -100, #{HOUSE_TYPE}, #{INTER_HOUSE_CODE},  #{AGENT_ID}, #{SOURCE},#{ContactMobile})")
	@SelectKey(statement = "select last_insert_id()", keyProperty = "HOUSE_ID", before = false, resultType = String.class)
	@Options(useGeneratedKeys = true)
	Long tuituiInsert(Map<String, String> params);

	@Update("update jx_rent set updater_id=-1,house_text=#{house_text},rent_type=#{RENT_TYPE},rental_extra=#{RENT_EXTRA},UPDATE_TIME=now(),COMMUNITY_ID =#{COMMUNITY_ID}, community_name=#{Community},rental=#{Total},HOUSE_TITLE=#{Topic}"//
			+ ", FLOOR_NO=#{Floor}, total_floor=#{Floors}, bedroom_total=#{Shi}, hall_total=#{Ting}, bathroom_total=#{Wei}, kitchen_total=#{Chu}, HO_ID=#{HO_ID}, BUILDING_AREA=#{Square}"//
			+ ", HD_ID=#{HD_ID},FINISHED_YEAR=#{Years}, HOUSE_INFO=#{Content}, HOUSE_TYPE=#{HOUSE_TYPE}, mobile=#{ContactMobile} where rent_id=#{HOUSE_ID}")
	Long tuituiUpdate(Map<String, String> params);

	@Delete("delete from jx_rent where rent_id=#{rent_id}")
	Integer realDelete(@Param("rent_id") Long rent_id);

	@Select("select * from jx_rent where rent_id=#{rent_id}")
	JxRent selectById(@Param("rent_id") String rent_id);

	@Select("select j.AGENT_ID from jx_rent j where (j.HOUSE_STATUS>0 or j.HOUSE_STATUS=-100)  group by j.AGENT_ID having count(*)>#{cnt}")
	List<Long> selectAgentIdForOverCount(@Param("cnt") Integer cnt);

	/**
	 * 查出推推有效的房子 房子状态包含1 和-100,-100 代表是要下载图片的
	 *
	 * @param agent_id
	 * @param house_status
	 * @return
	 */
	@Select("select * from jx_rent j where j.AGENT_ID=#{AGENT_ID} and (j.HOUSE_STATUS='1' or  j.HOUSE_STATUS='-100') order by j.rent_id desc")
	List<JxRent> selectAvaliableByAgentIdTuitui(@Param("AGENT_ID") Long agent_id);

	@Update("update jx_rent set title_img=#{title_img} where rent_id=#{rent_id} ")
	void updateFullViewPath(@Param("rent_id") String rent_id, @Param("title_img") String title_img);

	@Update("update jx_rent set HOUSE_STATUS=1 where rent_id=#{rent_id} ")
	void enableHouse(@Param("rent_id") String rent_id);

	@Update("update jx_rent set HOUSE_STATUS=-1 where rent_id=#{rent_id} ")
	Integer disableHouse(@Param("rent_id") String rent_id);

	@Select("SELECT * FROM jx_rent j WHERE j.title_img LIKE 'http%' and j.update_time>=#{lastModifyTime} order by j.update_time desc")
	List<JxRent> selectHouseIdWithStartHttp(@Param("lastModifyTime") Date lastModifyTime);

	@Select("SELECT j.AGENT_ID, j.HOUSE_TITLE title FROM jx_rent j WHERE (j.HOUSE_STATUS>0  or j.HOUSE_STATUS=-100 )GROUP BY j.AGENT_ID,REPLACE(j.HOUSE_TITLE,' ','') HAVING COUNT(*)>1")
	List<JxRent> selectHasRepeatAgent();

	/**
	 * 老温提供的sql,跑任务,每分钟一次
	 */
	@Update("update jx_rent set HOUSE_STATUS = '1' where se_agent>0 and house_status =0 and time_to_sec(now())-time_to_sec(update_time) > 600")
	Long updateJob();

}
