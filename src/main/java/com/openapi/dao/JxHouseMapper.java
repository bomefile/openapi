package com.openapi.dao;

import com.openapi.annotation.mvc.Repository;
import com.openapi.entity.JxHouse;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface JxHouseMapper {

	@Update("update jx_house j set  j.UPDATE_TIME=now() where j.ID=#{houseId} and j.AGENT_ID=#{agent_id}")
	Integer tuituiRefresh(@Param("houseId") String houseId, @Param("agent_id") Long agent_id);

	@Update("update jx_house j set  j.HOUSE_STATUS='-1' where j.ID=#{houseId} and j.AGENT_ID=#{agent_id}")
	Integer softDelete(@Param("houseId") String houseId, @Param("agent_id") Long agent_id);

	@Insert("INSERT INTO jx_house (UPDATE_TIME,CREATE_TIME,COMMUNITY_ID, BUILDING_NAME, HOUSE_TITLE, HOUSE_TOTAL_PRICE, HOUSE_UNIT_PRICE, FLOOR_NO, TOTAL_FLOORS, BEDROOM_NUMS, HALL_NUMS, BATHROOM_NUMS, KITCHEN_NUMS,  HO_ID, BUILDING_AREA, HD_ID,FINISHED_YEAR,house_text, HOUSE_INFO, FULL_VIEW_PATH, HOUSE_STATUS,  HOUSE_TYPE, CHECK_TIME,  INTER_HOUSE_CODE,AGENT_ID,SOURCE,mobile) "//
			+ "VALUES (now(),now(),#{COMMUNITY_ID}, #{Community}, #{Topic}, #{Total}, #{HOUSE_UNIT_PRICE}, #{Floor}, #{Floors}, #{Shi}, #{Ting}, #{Wei}, #{Chu}, #{HO_ID}, #{Square},#{HD_ID}, #{Years},#{house_text},#{Content}, #{Thumbnail}, -100, #{HOUSE_TYPE}, #{CHECK_TIME}, #{INTER_HOUSE_CODE},  #{AGENT_ID}, #{SOURCE},#{ContactMobile})")
	@SelectKey(statement = "select last_insert_id()", keyProperty = "HOUSE_ID", before = false, resultType = String.class)
	@Options(useGeneratedKeys = true)
	Long tuituiInsert(Map<String, String> params);

	@Update("update jx_house set UPDATE_TIME=now(),COMMUNITY_ID =#{COMMUNITY_ID}, BUILDING_NAME=#{Community}, HOUSE_TITLE=#{Topic}, HOUSE_TOTAL_PRICE=#{Total}, HOUSE_UNIT_PRICE=#{HOUSE_UNIT_PRICE}"//
			+ ", FLOOR_NO=#{Floor}, TOTAL_FLOORS=#{Floors}, BEDROOM_NUMS=#{Shi}, HALL_NUMS=#{Ting}, BATHROOM_NUMS=#{Wei}, KITCHEN_NUMS=#{Chu},  HO_ID=#{HO_ID}, BUILDING_AREA=#{Square}"//
			+ ", HD_ID=#{HD_ID},FINISHED_YEAR=#{Years},house_text=#{house_text}, HOUSE_INFO=#{Content}, HOUSE_TYPE=#{HOUSE_TYPE}, mobile=#{ContactMobile} where id=#{HOUSE_ID}")
	Long tuituiUpdate(Map<String, String> params);

	@Delete("delete from jx_house where ID=#{houseId}")
	Integer realDelete(@Param("houseId") Long houseId);

	@Select("select * from jx_house where ID=#{houseId}")
	JxHouse selectById(@Param("houseId") String houseId);

	@Select("select j.AGENT_ID from jx_house j where (j.HOUSE_STATUS>0 or j.HOUSE_STATUS=-100)  group by j.AGENT_ID having count(*)>#{cnt}")
	List<Long> selectAgentIdForOverCount(@Param("cnt") Integer cnt);

	/**
	 * 查出推推有效的房子 房子状态包含1 和-100,-100 代表是要下载图片的
	 *
	 * @param agent_id
	 * @param house_status
	 * @return
	 */
	@Select("select * from jx_house j where j.AGENT_ID=#{AGENT_ID} and (j.HOUSE_STATUS='1' or  j.HOUSE_STATUS='-100') order by j.id desc")
	List<JxHouse> selectAvaliableByAgentIdTuitui(@Param("AGENT_ID") Long agent_id);

	@Update("update jx_house set FULL_VIEW_PATH=#{fullviewPath} where ID=#{houseId} ")
	void updateFullViewPath(@Param("houseId") String houseId, @Param("fullviewPath") String fullviewPath);

	@Update("update jx_house set HOUSE_STATUS=1 where ID=#{houseId} ")
	void enableHouse(@Param("houseId") String houseId);

	@Update("update jx_house set HOUSE_STATUS=-1 where ID=#{houseId} ")
	Integer disableHouse(@Param("houseId") String houseId);

	@Select("SELECT * FROM jx_house j WHERE j.FULL_VIEW_PATH LIKE 'http%'  and j.LAST_MODIFY_TIME>=#{lastModifyTime} order by j.LAST_MODIFY_TIME desc")
	List<JxHouse> selectHouseIdWithStartHttp(@Param("lastModifyTime") Date lastModifyTime);

	@Select("SELECT j.AGENT_ID, j.HOUSE_TITLE title FROM jx_house j WHERE (j.HOUSE_STATUS='1' or  j.HOUSE_STATUS='-100')  GROUP BY j.AGENT_ID,REPLACE(j.HOUSE_TITLE,' ','') HAVING COUNT(*)>1")
	List<JxHouse> selectHasRepeatAgent();

	/**
	 * 老温提供的sql,跑任务,每分钟一次
	 */
	@Update("update jx_house set HOUSE_STATUS = '1' where se_agent>0 and HOUSE_STATUS =0 and time_to_sec(now())-time_to_sec(LAST_MODIFY_TIME) > 600")
	Long updateJob();

}
